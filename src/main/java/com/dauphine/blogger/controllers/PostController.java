package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dtos.PostRequest;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Get all posts",
        description = "Retrieve all posts or filter by title/content using the 'value' parameter"
    )
    public List<Post> getAll(@RequestParam(required = false) String value) {
        List<Post> posts = value == null || value.isBlank()
                            ? service.getAll()
                            : service.getAllByValue(value);
        return posts;
    }


    @GetMapping("{id}")
    public Post getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Post create(@RequestBody PostRequest request) {
        return service.create(request.getTitle(), request.getText(), request.getCategory());
    }

    @PutMapping("{id}")
    public Post update(@PathVariable UUID id, @RequestBody PostRequest request) {
        return service.update(id, request.getTitle(), request.getText(), request.getCategory());
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }
}
