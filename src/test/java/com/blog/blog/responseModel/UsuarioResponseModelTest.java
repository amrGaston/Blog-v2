package com.blog.blog.responseModel;

import com.blog.blog.controller.models.UsuarioResponseModel;
import com.blog.blog.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UsuarioResponseModelTest {

    private Usuario usuario = new Usuario();
    private UsuarioResponseModel usuarioResponseModel;

    @BeforeEach
    void setUp(){
        this.usuario.setId(1L);
        this.usuario.setNombre("Gastón");
        this.usuario.setCorreo("prueba@prueba.com");
        this.usuario.setPosts(new ArrayList<>());
        this.usuarioResponseModel = new UsuarioResponseModel(this.usuario);
    }

    @Test
    void getIDDevuelveUnID(){
        Assertions.assertEquals(1L,this.usuarioResponseModel.getId());
    }

    @Test
    void getNombreDevuelveUnNombre(){
        Assertions.assertEquals("Gastón",this.usuarioResponseModel.getNombre());
    }

    @Test
    void getCorreoDevuelveUnCorreo(){
        Assertions.assertEquals("prueba@prueba.com",this.usuarioResponseModel.getCorreo());
    }

    @Test
    void getPostsDevuelveUnaListaDePost(){
        Assertions.assertNotNull(this.usuarioResponseModel.getPosts());
    }
}
