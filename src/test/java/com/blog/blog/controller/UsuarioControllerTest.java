package com.blog.blog.controller;

import com.blog.blog.controller.models.UsuarioResponseModel;
import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Usuario;
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

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final UsuarioController usuarioController = new UsuarioController();
    private final UsuarioController usuarioControllerMock = Mockito.mock(UsuarioController.class);
    @BeforeEach
    void setUp() throws ElementoNoEncontradoException {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombre("Gastón");
        usuario.setCorreo("gaston@gmail.com");
        usuario.setPosts(new ArrayList<>());

        UsuarioResponseModel usuarioResponseModelMock = new UsuarioResponseModel(usuario);
        Mockito.when(usuarioControllerMock.getUsuario(1L) ).thenReturn(usuarioResponseModelMock);
    }

    @Test
    void getUsuarioDevuelveUsuarioConAtributoNombre() throws ElementoNoEncontradoException {
        UsuarioResponseModel usuarioResponseModel = usuarioControllerMock.getUsuario(1L);
        Assertions.assertEquals("Gastón",usuarioResponseModel.getNombre());
    }

    @Test
    void getUsuarioDevuelveUsuarioConAtributoID() throws ElementoNoEncontradoException {
        UsuarioResponseModel usuarioResponseModel = usuarioControllerMock.getUsuario(1L);
        Assertions.assertEquals(1L,usuarioResponseModel.getId());
    }

    @Test
    void getUsuarioDevuelveUsuarioConAtributoCorreo() throws ElementoNoEncontradoException {
        UsuarioResponseModel usuarioResponseModel = usuarioControllerMock.getUsuario(1L);
        Assertions.assertEquals("gaston@gmail.com",usuarioResponseModel.getCorreo());
    }

    @Test
    void getUsuarioDevuelveRespuestaJson() throws ElementoNoEncontradoException {
        UsuarioResponseModel usuarioResponseModel = usuarioControllerMock.getUsuario(1L);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            json = objectMapper.writeValueAsString(usuarioResponseModel);
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
