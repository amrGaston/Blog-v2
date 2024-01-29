package com.blog.blog.controller.models;

import com.blog.blog.model.Comentario;

public class ComentarioResponseModel {
    private Long id;
    private String texto;

    public ComentarioResponseModel(Comentario comentario){
        this.id = comentario.getId();
        this.texto = comentario.getTexto();
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
}