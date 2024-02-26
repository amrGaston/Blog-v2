package com.blog.blog.responseModel;

import com.blog.blog.controller.models.PostResponseModel;
import com.blog.blog.model.Post;
import com.blog.blog.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class PostResponseModelTest {
    private PostResponseModel postResponseModel;
    private Post post = new Post();
    @BeforeEach
    void setUp(){
        this.post.setTitulo("prueba titulo");
        this.post.setTexto("prueba texto");
        this.post.setId(1L);
        this.post.setComentarios(new ArrayList<>());
        this.postResponseModel = new PostResponseModel(this.post);
    }

    @Test
    void getTituloDevuelveUnTitulo(){
        Assertions.assertEquals("prueba titulo",this.postResponseModel.getTitulo());
    }

    @Test
    void getTextoDevuelveUntexto(){
        Assertions.assertEquals("prueba texto",this.postResponseModel.getTexto());
    }

    @Test
    void getIDDevuelveUnID(){
        Assertions.assertEquals(1L,this.postResponseModel.getId());
    }

    @Test
    void getComentariosDevuelveUnaListaDeComentarios(){
        Assertions.assertNotNull(this.postResponseModel.getComentarios());
    }

    @Test
    void getLocalDateDevuelveUnLocalDateActual(){
        Assertions.assertEquals(LocalDate.now(),this.postResponseModel.getLocalDate());
    }
}
