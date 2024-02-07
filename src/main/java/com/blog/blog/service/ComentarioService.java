package com.blog.blog.service;

import com.blog.blog.exception.ComentarioNoEncontradoException;
import com.blog.blog.exception.PostNoEncontradoException;
import com.blog.blog.model.Comentario;
import com.blog.blog.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComentarioService {
    @Autowired
    private ComentarioRepository comentarioRepository;


    public void guardarComentario(Comentario comentario) {
        comentarioRepository.save(comentario);
    }

    public Comentario getComentario(Long id) throws ComentarioNoEncontradoException {
        Comentario comentario = comentarioRepository.findById(id).orElseThrow( () -> new ComentarioNoEncontradoException(id));

        if(!comentario.isActivo()){
            throw new ComentarioNoEncontradoException(id);
        }

        return comentario;

    }

    public void deleteComentario(Long id) throws ComentarioNoEncontradoException {

        Comentario comentario = comentarioRepository.findById(id).orElseThrow(() -> new ComentarioNoEncontradoException(id));

        if(!comentario.isActivo()){
            throw new ComentarioNoEncontradoException(id);
        }

        comentario.setActivo(false);
        comentarioRepository.save(comentario);

    }
}
