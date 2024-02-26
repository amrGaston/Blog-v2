package com.blog.blog.responseModel;

import com.blog.blog.controller.models.ComentarioResponseModel;
import com.blog.blog.model.Comentario;
import com.blog.blog.model.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ComentarioResponseModelTest {

    private ComentarioResponseModel comentarioResponseModel;
    private Comentario comentario;
    @BeforeEach
    void setUp(){
        this.comentario = new Comentario();
        this.comentario.setTexto("prueba");
        this.comentario.setId(1L);
        this.comentarioResponseModel = new ComentarioResponseModel(this.comentario);
    }

    @Test
    void getTextoDevuelveUnTexto(){
        Assertions.assertEquals("prueba",this.comentarioResponseModel.getTexto());
    }

    @Test
    void getIDDevuelveUnID(){
        Assertions.assertEquals(1L,this.comentarioResponseModel.getId());
    }
}
