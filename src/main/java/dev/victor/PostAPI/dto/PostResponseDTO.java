package dev.victor.PostAPI.dto;

public class PostResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String postagem;
    private String tag1;
    private String tag2;
    private String imagemUrl;
    private String criadoEm; // AGORA é String formatada

    public PostResponseDTO(Long id, String titulo, String descricao, String postagem,
                           String tag1, String tag2, String imagemUrl, String criadoEm) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.postagem = postagem;
        this.tag1 = tag1;
        this.tag2 = tag2;
        this.imagemUrl = imagemUrl;
        this.criadoEm = criadoEm;
    }

    // Getters e Setters normais...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPostagem() {
        return postagem;
    }

    public void setPostagem(String postagem) {
        this.postagem = postagem;
    }

    public String getTag1() {
        return tag1;
    }

    public void setTag1(String tag1) {
        this.tag1 = tag1;
    }

    public String getTag2() {
        return tag2;
    }

    public void setTag2(String tag2) {
        this.tag2 = tag2;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }
}
