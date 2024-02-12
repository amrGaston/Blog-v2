package com.blog.blog.controller;

import com.blog.blog.controller.models.UsuarioResponseModel;
import com.blog.blog.exception.ApiResponse;
import com.blog.blog.exception.RequestConErrorException;
import com.blog.blog.exception.UsuarioNoEncontradoException;
import com.blog.blog.model.Usuario;
import com.blog.blog.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse> guardarUsuario(@Validated @RequestBody Usuario usuario, BindingResult bindingResult) throws RequestConErrorException {
        if (bindingResult.hasErrors()){
            //throw new RequestConErrorException();
            return new ResponseEntity<>(new ApiResponse(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
        }

        this.usuarioService.guardarUsuario(usuario);
        return new ResponseEntity<>(new ApiResponse("Usuario creado", HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public UsuarioResponseModel getUsuario(@PathVariable("id") Long id) throws UsuarioNoEncontradoException {
        return new UsuarioResponseModel(this.usuarioService.getUsuario(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUsuario(@PathVariable("id") Long id) throws UsuarioNoEncontradoException {
        this.usuarioService.deleteUsuario(id);
    }

}
