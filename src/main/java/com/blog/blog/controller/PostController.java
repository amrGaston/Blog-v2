package com.blog.blog.controller;

import com.blog.blog.controller.models.PostResponseModel;
import com.blog.blog.exception.ApiResponse;
import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.exception.RequestConErrorException;
import com.blog.blog.model.Post;
import com.blog.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping(path = "/create")
    public ResponseEntity<ApiResponse> guardarPost(@Validated @RequestBody Post post, BindingResult bindingResult) throws RequestConErrorException {
        if (bindingResult.hasErrors()){
            //throw new RequestConErrorException();
            return new ResponseEntity<>(new ApiResponse(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
        }

        try {
            this.postService.guardarPost(post);
        }catch ( Exception e){
            throw new RequestConErrorException();
        }
        return new ResponseEntity<>(new ApiResponse("Post creado", HttpStatus.CREATED),HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}")
    public PostResponseModel getPost(@PathVariable("id") Long id) throws ElementoNoEncontradoException {
        return new PostResponseModel(this.postService.getPost(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable("id") Long id) throws ElementoNoEncontradoException {
        this.postService.deletePost(id);
    }

}
