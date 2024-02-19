package com.blog.blog.service;

import com.blog.blog.exception.ElementoNoEncontradoException;
import com.blog.blog.model.Post;
import com.blog.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;


    public void guardarPost(Post post) {
        postRepository.save(post);
    }
    public Post getPost(Long id) throws ElementoNoEncontradoException {
        Post post = postRepository.findById(id).orElseThrow( () -> new ElementoNoEncontradoException("Post no encontrado con ID: "+ id));
        if(!post.isActivo()){
            throw new ElementoNoEncontradoException("Post no encontrado con ID: "+ id);
        }

        return post;
    }
    public void deletePost(Long id) throws ElementoNoEncontradoException {
        Post post = postRepository.findById(id).orElseThrow(() -> new ElementoNoEncontradoException("Post no encontrado con ID: "+ id));

        if(!post.isActivo()){
            throw new ElementoNoEncontradoException("Post no encontrado con ID: "+ id);
        }

        post.setActivo(false);
        postRepository.save(post);
    }
}
