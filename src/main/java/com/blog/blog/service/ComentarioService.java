package com.blog.blog.service;

import com.blog.blog.exception.ElementoNoEncontradoException;
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

    public Comentario getComentario(Long id) throws ElementoNoEncontradoException {
        Comentario comentario = comentarioRepository.findById(id).orElseThrow( () -> new ElementoNoEncontradoException("Comentario no encontrado con ID: "+ id));

        if(!comentario.isActivo()){
            throw new ElementoNoEncontradoException("Comentario no encontrado con ID: "+ id);
        }

        return comentario;

    }

    public void deleteComentario(Long id) throws ElementoNoEncontradoException {

        Comentario comentario = comentarioRepository.findById(id).orElseThrow(() -> new ElementoNoEncontradoException("Comentario no encontrado con ID: "+ id));

        if(!comentario.isActivo()){
            throw new ElementoNoEncontradoException("Comentario no encontrado con ID: "+ id);
        }

        comentario.setActivo(false);
        comentarioRepository.save(comentario);

    }
}
