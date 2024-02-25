package com.blog.blog.service;

import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Comentario;
import com.blog.blog.repository.ComentarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.mockito.Mockito.*;

public class ComentarioServiceTest {

    @Mock
    private ComentarioRepository comentarioRepository;

    @InjectMocks
    private ComentarioService comentarioService;

    private final Comentario comentario = new Comentario();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        comentario.setId(1L);
        comentario.setTexto("Esto es una prueba");

        when(comentarioRepository.findById(1L)).thenReturn(Optional.of(this.comentario));
    }
    @Test
    void getComentarioDevuelveUnComentario() throws ElementoNoEncontradoException {
        Assertions.assertNotNull(comentarioService.getComentario(1L));
    }

    @Test
    void getComentarioDevuelveUnComentarioConAtributoID() throws ElementoNoEncontradoException {
        Comentario comentario = comentarioService.getComentario(1L);
        Assertions.assertEquals(1L,comentario.getId());
    }

    @Test
    void getComentarioDevuelveUnComentarioConTexto() throws ElementoNoEncontradoException {
        Comentario comentario = comentarioService.getComentario(1L);
        Assertions.assertEquals("Esto es una prueba",comentario.getTexto());
    }

    @Test
    void getComentarioConIDNoEncontradoDevuelveException() {
        Assertions.assertThrows(
                ElementoNoEncontradoException.class,
                () -> comentarioService.getComentario(10L)
        );
    }

    @Test
    void deleteComentarioConIDNoEncontradoDevuelveException(){
        Assertions.assertThrows(
                ElementoNoEncontradoException.class,
                () -> comentarioService.deleteComentario(10L)
        );
    }

    @Test
    void deleteComentarioConIDEncontradoNoLanzaException() {
        try {
            comentarioService.deleteComentario(1L);
        }catch (ElementoNoEncontradoException e){
            fail(e.getMessage());
        }
    }
}
