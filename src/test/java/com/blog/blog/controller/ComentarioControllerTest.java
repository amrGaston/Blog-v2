package com.blog.blog.controller;

import com.blog.blog.controller.models.ComentarioResponseModel;
import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Comentario;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ComentarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final ComentarioController comentarioController = new ComentarioController();
    private final ComentarioController comentarioControllerMock = Mockito.mock(ComentarioController.class);
    @BeforeEach
    void setUp() throws ElementoNoEncontradoException {
        Comentario comentario = new Comentario();
        comentario.setTexto("Un Comentario");
        comentario.setId(1L);
        ComentarioResponseModel comentarioResponseModelMock = new ComentarioResponseModel(comentario);
        Mockito.when(comentarioControllerMock.getComentario(1L) ).thenReturn(comentarioResponseModelMock);
    }

    @Test
    void getComentarioDevuelveComentarioConAtributoTexto() throws ElementoNoEncontradoException {
        ComentarioResponseModel comentarioResponseModel = comentarioControllerMock.getComentario(1L);
        Assertions.assertEquals("Un Comentario",comentarioResponseModel.getTexto());
    }

    @Test
    void getComentarioDevuelveComentarioConAtributoID() throws ElementoNoEncontradoException {
        ComentarioResponseModel comentarioResponseModel = comentarioControllerMock.getComentario(1L);
        Assertions.assertEquals(1L,comentarioResponseModel.getId());
    }

    @Test
    void getComentarioDevuelveRespuestaJson() throws ElementoNoEncontradoException {
        ComentarioResponseModel comentarioResponseModel = comentarioControllerMock.getComentario(1L);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(comentarioResponseModel);
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

    //@Test
    public void getComentarioDevuelveRespuesta200() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(comentarioController).build();
        mockMvc.perform(get("/comentario/1")).andExpect(status().isOk() );

    }
}
