package com.blog.blog.model;

import com.blog.blog.config.Constantes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="post")
public class Post {

    @NotNull(message = "El título " + Constantes.MENSAJE_NO_NULO)
    @NotBlank(message = "El título " + Constantes.MENSAJE_NO_VACIO)
    private String titulo;
    @NotNull(message = "El texto " + Constantes.MENSAJE_NO_NULO)
    @NotBlank(message = "El texto " + Constantes.MENSAJE_NO_VACIO)
    private String texto;
    private LocalDate date = LocalDate.now();
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Comentario> comentarios = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;
    private Boolean activo;

    @NotNull(message = "El usuario con un atributo 'id' " + Constantes.MENSAJE_NO_NULO)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id",nullable = false)
    @JsonBackReference
    private Usuario usuario;

    public Post(){
        this.activo = true;
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

    public LocalDate getDate() {
        return date;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
