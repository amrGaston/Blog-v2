package com.blog.blog.controller;

import com.blog.blog.exception.ComentarioNoEncontradoException;
import com.blog.blog.exception.ResponseException;
import com.blog.blog.model.Comentario;
import com.blog.blog.service.ComentarioService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentario")
public class ComentarioController {
    @Autowired
    private ComentarioService comentarioService;

    @PostMapping
    public Comentario guardarComentario(@RequestBody Comentario comentario){
        return this.comentarioService.guardarComentario(comentario);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Comentario> getComentario(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(this.comentarioService.getComentario(id));
    }


}
