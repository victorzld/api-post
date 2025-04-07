package dev.victor.PostAPI.service;

import dev.victor.PostAPI.dto.PostResponseDTO;
import dev.victor.PostAPI.model.Post;
import dev.victor.PostAPI.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDTO createPost(String titulo, String descricao, String postagem, String tag1, String tag2, MultipartFile imagem) {
        String imagemUrl = (imagem != null && !imagem.isEmpty())
                ? "https://meu-bucket.cloudflare-r2.com/" + UUID.randomUUID()
                : null;

        Post post = Post.builder()
                .titulo(titulo)
                .descricao(descricao)
                .postagem(postagem)
                .tag1(tag1)
                .tag2(tag2)
                .imagemUrl(imagemUrl)
                .build(); // criadoEm será definido automaticamente

        Post saved = postRepository.save(post);
        return convertToDTO(saved);
    }

    public List<PostResponseDTO> findAll() {
        return postRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PostResponseDTO findById(Long id) {
        return postRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public List<PostResponseDTO> searchByTitulo(String titulo) {
        return postRepository.findByTituloContainingIgnoreCase(titulo).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<PostResponseDTO> searchByDescricao(String descricao) {
        return postRepository.findByDescricaoContainingIgnoreCase(descricao).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public PostResponseDTO updatePost(Long id, String titulo, String descricao, String postagem,
                                      String tag1, String tag2, MultipartFile imagem) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) return null;

        Post post = optionalPost.get();
        post.setTitulo(titulo);
        post.setDescricao(descricao);
        post.setPostagem(postagem);
        post.setTag1(tag1);
        post.setTag2(tag2);

        if (imagem != null && !imagem.isEmpty()) {
            post.setImagemUrl("https://meu-bucket.cloudflare-r2.com/" + UUID.randomUUID());
        }

        Post updated = postRepository.save(post);
        return convertToDTO(updated);
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    private PostResponseDTO convertToDTO(Post post) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String criadoEmFormatado = post.getCriadoEm() != null
                ? post.getCriadoEm().format(formatter)
                : null;

        return new PostResponseDTO(
                post.getId(),
                post.getTitulo(),
                post.getDescricao(),
                post.getPostagem(),
                post.getTag1(),
                post.getTag2(),
                post.getImagemUrl(),
                criadoEmFormatado
        );
    }
}
