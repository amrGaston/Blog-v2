package com.blog.blog.service;

import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Post;
import com.blog.blog.model.Usuario;
import com.blog.blog.repository.PostRepository;
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

public class PostServiceTest {

    @Mock
    private PostRepository postRepository;

    @InjectMocks
    private PostService postService;

    private final Post post = new Post();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        post.setId(1L);
        post.setTitulo("Post 1");
        post.setTexto("Esto es una prueba");
        post.setComentarios(new ArrayList<>());
        post.setUsuario(new Usuario());

        when(this.postRepository.findById(1L)).thenReturn(Optional.of(this.post));
    }
    @Test
    void getPostDevuelveUnPost() throws ElementoNoEncontradoException {
        Assertions.assertNotNull(this.postService.getPost(1L));
    }

    @Test
    void getPostDevuelveUnPostConAtributoID() throws ElementoNoEncontradoException {
        Post post = this.postService.getPost(1L);
        Assertions.assertEquals(1L,post.getId());
    }

    @Test
    void getPostDevuelveUnPostConTitulo() throws ElementoNoEncontradoException {
        Post post = this.postService.getPost(1L);
        Assertions.assertEquals("Post 1",post.getTitulo());
    }
    @Test
    void getPostDevuelveUnPostConTexto() throws ElementoNoEncontradoException {
        Post post = this.postService.getPost(1L);
        Assertions.assertEquals("Esto es una prueba",post.getTexto());
    }

    @Test
    void getPostDevuelveUnPostConComentarios() throws ElementoNoEncontradoException {
        Post post = this.postService.getPost(1L);
        Assertions.assertNotNull(post.getComentarios());
    }

    @Test
    void getPostDevuelveUnPostConUsuario() throws ElementoNoEncontradoException {
        Post post = this.postService.getPost(1L);
        Assertions.assertNotNull(post.getUsuario());
    }

    @Test
    void getPostConIDNoEncontradoDevuelveException() {
        Assertions.assertThrows(
                ElementoNoEncontradoException.class,
                () -> postService.getPost(10L)
        );
    }

    @Test
    void deletePostConIDNoEncontradoDevuelveException(){
        Assertions.assertThrows(
                ElementoNoEncontradoException.class,
                () -> postService.deletePost(10L)
        );
    }

    @Test
    void deletePostConIDEncontradoNoLanzaException() {
        try {
            postService.deletePost(1L);
        }catch (ElementoNoEncontradoException e){
            fail(e.getMessage());
        }
    }
}
