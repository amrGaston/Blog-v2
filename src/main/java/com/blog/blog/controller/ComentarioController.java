package com.blog.blog.controller;

import com.blog.blog.controller.models.ComentarioResponseModel;
import com.blog.blog.exception.*;
import com.blog.blog.model.Comentario;
import com.blog.blog.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse> guardarComentario(@Validated @RequestBody Comentario comentario, BindingResult bindingResult) throws RequestConErrorException {
        if (bindingResult.hasErrors()){
            throw new RequestConErrorException();
        }

        this.comentarioService.guardarComentario(comentario);
        return new ResponseEntity<>(new ApiResponse("Comentario creado",HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ComentarioResponseModel getComentario(@PathVariable("id") Long id) throws ComentarioNoEncontradoException {
        return new ComentarioResponseModel(this.comentarioService.getComentario(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComentario(@PathVariable("id") Long id) throws ComentarioNoEncontradoException {
         this.comentarioService.deleteComentario(id);
    }


}
