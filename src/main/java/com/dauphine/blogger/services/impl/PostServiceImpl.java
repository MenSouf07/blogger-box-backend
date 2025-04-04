package com.dauphine.blogger.services.impl;

import org.springframework.stereotype.Service;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.services.PostService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final List<Post> posts;

    public PostServiceImpl() {
        this.posts = new ArrayList<>();
        posts.add(new Post("Hello Blog", "Welcome to my new blog!", new Category(UUID.randomUUID(), "my 1st category")));
        posts.add(new Post("Second Post", "This is my second post with more content.", new Category(UUID.randomUUID(), "my 2nd category")));
        posts.add(new Post("Tech Talk", "Let's discuss Java and Spring Boot!", new Category(UUID.randomUUID(), "my 3th category")));
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public Post getById(UUID id) {
        return posts.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Post create(String title, String content, Category category) {
        Post post = new Post(title, content, category);
        posts.add(post);
        return post;
    }

    @Override
    public Post update(UUID id, String title, String content, Category category) {
        Post post = posts.stream()
                        .filter(p -> id.equals(p.getId()))
                        .findFirst()
                        .orElse(null);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
            post.setCategory(category);
        }
        return post;
    }

    @Override
    public boolean delete(UUID id) {
        return posts.removeIf(p -> p.getId().equals(id));
    }
}
