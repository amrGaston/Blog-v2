package com.blog.blog.service;

import com.blog.blog.exception.ComentarioNoEncontradoException;
import com.blog.blog.model.Comentario;
import com.blog.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Optional;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;


    public Comentario guardarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    public Comentario getComentario(Long id) throws ComentarioNoEncontradoException {
        Optional<Comentario> comentario = comentarioRepository.findById(id);
        if (comentario.isEmpty()){
            throw new ComentarioNoEncontradoException();
        }
        return comentario.get();
    }
}
