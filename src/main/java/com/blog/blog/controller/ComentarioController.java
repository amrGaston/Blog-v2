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

import java.util.Objects;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse> guardarComentario(@Validated @RequestBody Comentario comentario, BindingResult bindingResult) throws RequestConErrorException {
        if (bindingResult.hasErrors()){
            //throw new RequestConErrorException();
            return new ResponseEntity<>(new ApiResponse(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
        }

        try {
            this.comentarioService.guardarComentario(comentario);
        }catch ( Exception e){
            throw new RequestConErrorException();
        }

        return new ResponseEntity<>(new ApiResponse("Comentario creado",HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public ComentarioResponseModel getComentario(@PathVariable("id") Long id) throws ElementoNoEncontradoException {
        return new ComentarioResponseModel(this.comentarioService.getComentario(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComentario(@PathVariable("id") Long id) throws ElementoNoEncontradoException {
         this.comentarioService.deleteComentario(id);
    }


}
