package com.blog.blog.service;

import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Usuario;
import com.blog.blog.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public void guardarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }
    public Usuario getUsuario(Long id) throws ElementoNoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow( () -> new ElementoNoEncontradoException("Usuario no encontrado con ID: "+ id));
        if(!usuario.isActivo()){
            throw new ElementoNoEncontradoException("Usuario no encontrado con ID: "+ id);
        }

        return usuario;
    }
    public void deleteUsuario(Long id) throws ElementoNoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ElementoNoEncontradoException("Usuario no encontrado con ID: "+ id));

        if(!usuario.isActivo()){
            throw new ElementoNoEncontradoException("Usuario no encontrado con ID: "+ id);
        }

        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }
}
