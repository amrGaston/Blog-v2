package com.blog.blog.controller.models;

import com.blog.blog.model.Post;
import com.blog.blog.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioResponseModel {

    private String nombre;
    private String correo;

    private Long id;

    private List<PostResponseModel> posts = new ArrayList<>();

    public UsuarioResponseModel(Usuario usuario){
        this.nombre = usuario.getNombre();
        this.correo = usuario.getCorreo();
        this.id = usuario.getId();
        this.posts = guardarPost(usuario.getPosts());
    }

    private List<PostResponseModel> guardarPost(List<Post> posts) {
        List<PostResponseModel> postsActivos = new ArrayList<>();
        for (Post post: posts){
            if(post.isActivo()){
                postsActivos.add(new PostResponseModel(post));
            }
        }
        return postsActivos;
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

    public List<PostResponseModel> getPosts() {
        return posts;
    }

    public void setPosts(List<PostResponseModel> posts) {
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
