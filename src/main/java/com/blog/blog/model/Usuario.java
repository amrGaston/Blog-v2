package com.blog.blog.model;

import com.blog.blog.config.Constantes;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="usuario")
public class Usuario {

    @NotNull(message = "El nombre " + Constantes.MENSAJE_NO_NULO)
    @NotBlank(message = "El nombre " + Constantes.MENSAJE_NO_VACIO)
    private String nombre;
    @NotNull(message = "El correo " + Constantes.MENSAJE_NO_NULO)
    @NotBlank(message = "El correo " + Constantes.MENSAJE_NO_VACIO)
    @Email
    private String correo;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true,nullable = false)
    private Long id;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Post> posts = new ArrayList<>();
    private Boolean activo;

    public Usuario(){
        this.activo=true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Boolean isActivo(){
        return this.activo;
    }

    public void setActivo(Boolean activo){
        this.activo=activo;
    }
}
