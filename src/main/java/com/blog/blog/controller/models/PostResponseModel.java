package com.blog.blog.controller.models;

import com.blog.blog.model.Comentario;
import com.blog.blog.model.Post;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PostResponseModel {

    private String titulo;
    private String texto;
    private LocalDate localDate;
    private List<ComentarioResponseModel> comentarios = new ArrayList<>();
    private Long id;


    public PostResponseModel(Post post) {
        this.titulo = post.getTitulo();
        this.texto = post.getTexto();
        this.localDate = post.getDate();
        this.getComentarios(post.getComentarios());
        this.id = post.getId();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<ComentarioResponseModel> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioResponseModel> comentarios) {
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void getComentarios(List<Comentario> comentarios) {
        for (Comentario comentario : comentarios){
            if (comentario.isActivo()){
                this.comentarios.add(new ComentarioResponseModel(comentario));
            }
        }
    }
}
