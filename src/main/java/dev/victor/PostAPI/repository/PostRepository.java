package dev.victor.PostAPI.repository;

import dev.victor.PostAPI.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTituloContainingIgnoreCase(String titulo);
    List<Post> findByDescricaoContainingIgnoreCase(String descricao);
}
