package dev.victor.PostAPI.controller;

import dev.victor.PostAPI.dto.PostResponseDTO;
import dev.victor.PostAPI.service.PostService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public PostResponseDTO createPost(
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("postagem") String postagem,
            @RequestParam("tag1") String tag1,
            @RequestParam("tag2") String tag2,
            @RequestParam(value = "imagem", required = false) MultipartFile imagem
    ) {
        return postService.createPost(titulo, descricao, postagem, tag1, tag2, imagem);
    }

    @GetMapping
    public List<PostResponseDTO> getAllPosts() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostResponseDTO getPostById(@PathVariable Long id) {
        return postService.findById(id);
    }

    @GetMapping("/search/titulo")
    public List<PostResponseDTO> searchByTitulo(@RequestParam String titulo) {
        return postService.searchByTitulo(titulo);
    }

    @GetMapping("/search/descricao")
    public List<PostResponseDTO> searchByDescricao(@RequestParam String descricao) {
        return postService.searchByDescricao(descricao);
    }

    @PutMapping("/{id}")
    public PostResponseDTO updatePost(
            @PathVariable Long id,
            @RequestParam("titulo") String titulo,
            @RequestParam("descricao") String descricao,
            @RequestParam("postagem") String postagem,
            @RequestParam("tag1") String tag1,
            @RequestParam("tag2") String tag2,
            @RequestParam(value = "imagem", required = false) MultipartFile imagem
    ) {
        return postService.updatePost(id, titulo, descricao, postagem, tag1, tag2, imagem);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }
}
