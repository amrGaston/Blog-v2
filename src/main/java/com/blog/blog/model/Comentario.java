package com.blog.blog.model;

import com.blog.blog.config.Constantes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    @NotNull(message = "El texto " + Constantes.MENSAJE_NO_NULO)
    @NotBlank(message = "El texto " + Constantes.MENSAJE_NO_VACIO)
    private String texto;

    private Boolean activo;

    @NotNull(message = "El post con un atributo 'id' " + Constantes.MENSAJE_NO_NULO)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id",nullable = false)
    @JsonBackReference
    private Post post;

    public Comentario(){
        this.activo = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
