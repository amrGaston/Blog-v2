package com.blog.blog.service;

import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Usuario;
import com.blog.blog.repository.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.mockito.Mockito.when;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    private final Usuario usuario = new Usuario();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        this.usuario.setNombre("Gastón");
        this.usuario.setId(1L);
        this.usuario.setCorreo("prueba@prueba.com");
        this.usuario.setPosts(new ArrayList<>());

        when(this.usuarioRepository.findById(1L)).thenReturn(Optional.of(this.usuario));
    }
    @Test
    void getUsuarioDevuelveUnUsuario() throws ElementoNoEncontradoException {
        Assertions.assertNotNull(this.usuarioService.getUsuario(1L));
    }

    @Test
    void getUsuarioDevuelveUnUsuarioConAtributoID() throws ElementoNoEncontradoException {
        Usuario usuario = this.usuarioService.getUsuario(1L);
        Assertions.assertEquals(1L,usuario.getId());
    }

    @Test
    void getUsuarioDevuelveUnUsuarioConNombre() throws ElementoNoEncontradoException {
        Usuario usuario = this.usuarioService.getUsuario(1L);
        Assertions.assertEquals("Gastón",usuario.getNombre());
    }
    @Test
    void getUsuarioDevuelveUnUsuarioConCorreo() throws ElementoNoEncontradoException {
        Usuario usuario = this.usuarioService.getUsuario(1L);
        Assertions.assertEquals("prueba@prueba.com",usuario.getCorreo());
    }

    @Test
    void getUsuarioDevuelveUnUsuarioConPosts() throws ElementoNoEncontradoException {
        Usuario usuario = this.usuarioService.getUsuario(1L);
        Assertions.assertNotNull(usuario.getPosts());
    }

    @Test
    void getUsuarioConIDNoEncontradoDevuelveException() {
        Assertions.assertThrows(
                ElementoNoEncontradoException.class,
                () -> usuarioService.getUsuario(10L)
        );
    }

    @Test
    void deleteUsuarioConIDNoEncontradoDevuelveException(){
        Assertions.assertThrows(
                ElementoNoEncontradoException.class,
                () -> usuarioService.deleteUsuario(10L)
        );
    }

    @Test
    void deleteUsuarioConIDEncontradoNoLanzaException() {
        try {
            usuarioService.deleteUsuario(1L);
        }catch (ElementoNoEncontradoException e){
            fail(e.getMessage());
        }
    }
}
