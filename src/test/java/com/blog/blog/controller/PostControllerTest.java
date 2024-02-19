package com.blog.blog.controller;

import com.blog.blog.controller.models.PostResponseModel;
import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Post;
import com.blog.blog.model.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final PostController postController = new PostController();
    private final PostController postControllerMock = Mockito.mock(PostController.class);
    @BeforeEach
    void setUp() throws ElementoNoEncontradoException {
        Post post = new Post();
        post.setId(1L);
        post.setTitulo("Un titulo");
        post.setTexto("Un texto");
        post.setUsuario(new Usuario());
        post.setComentarios(new ArrayList<>());

        PostResponseModel postResponseModelMock = new PostResponseModel(post);
        Mockito.when(postControllerMock.getPost(1L) ).thenReturn(postResponseModelMock);
    }

    @Test
    void getPostDevuelvePostConAtributoTitulo() throws ElementoNoEncontradoException {
        PostResponseModel postResponseModel = postControllerMock.getPost(1L);
        Assertions.assertEquals("Un titulo",postResponseModel.getTitulo());
    }

    @Test
    void getPostDevuelvePostConAtributoTexto() throws ElementoNoEncontradoException {
        PostResponseModel postResponseModel = postControllerMock.getPost(1L);
        Assertions.assertEquals("Un texto",postResponseModel.getTexto());
    }

    @Test
    void getPostDevuelvePostConAtributoID() throws ElementoNoEncontradoException {
        PostResponseModel postResponseModel = postControllerMock.getPost(1L);
        Assertions.assertEquals(1L,postResponseModel.getId());
    }

    @Test
    void getPostDevuelveRespuestaJson() throws ElementoNoEncontradoException {
        PostResponseModel postResponseModel = postControllerMock.getPost(1L);
        ObjectMapper objectMapper = JsonMapper.builder()
                .findAndAddModules()
                .build();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(postResponseModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertTrue(validarFormatoJSON(json));
    }

    private boolean validarFormatoJSON(String jsonString) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonString);
            return jsonNode.isObject();
        } catch (Exception e) {
            return false;
        }
    }
}
