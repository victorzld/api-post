package dev.victor.PostAPI.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.UUID;

@Service
@Slf4j
public class CloudflareR2Service {

    @Value("${cloudflare.r2.accessKey}")
    private String accessKey;

    @Value("${cloudflare.r2.secretKey}")
    private String secretKey;

    @Value("${cloudflare.r2.endpoint}")
    private String endpoint;

    @Value("${cloudflare.r2.bucket}")
    private String bucket;

    private S3Client s3Client;

    @PostConstruct
    public void init() {
        s3Client = S3Client.builder()
                .endpointOverride(URI.create(endpoint))
                .region(Region.US_EAST_1)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)))
                .build();
    }

    public String uploadFile(MultipartFile file) {
        String key = UUID.randomUUID() + "-" + file.getOriginalFilename();

        try {
            s3Client.putObject(PutObjectRequest.builder()
                            .bucket(bucket)
                            .key(key)
                            .contentType(file.getContentType())
                            .build(),
                    software.amazon.awssdk.core.sync.RequestBody.fromBytes(file.getBytes()));

            return endpoint + "/" + bucket + "/" + key;
        } catch (Exception e) {
            log.error("Erro ao enviar imagem para R2", e);
            throw new RuntimeException("Erro ao enviar imagem");
        }
    }
}
