package com.blog.blog.service;

import com.blog.blog.exception.UsuarioNoEncontradoException;
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
    public Usuario getUsuario(Long id) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow( () -> new UsuarioNoEncontradoException(id));
        if(!usuario.isActivo()){
            throw new UsuarioNoEncontradoException(id);
        }

        return usuario;
    }
    public void deleteUsuario(Long id) throws UsuarioNoEncontradoException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new UsuarioNoEncontradoException(id));

        if(!usuario.isActivo()){
            throw new UsuarioNoEncontradoException(id);
        }

        usuario.setActivo(false);
        usuarioRepository.save(usuario);
    }
}
