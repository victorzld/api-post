package dev.victor.PostAPI;

import me.paulschwarz.springdotenv.DotenvPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class PostApiApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(PostApiApplication.class);

		// Adiciona suporte a .env
		app.addInitializers(ctx -> {
			ConfigurableEnvironment env = ctx.getEnvironment();
			DotenvPropertySource.addToEnvironment(env);
		});

		app.run(args);
	}
}