package com.dauphine.blogger.services.impl;

import org.springframework.stereotype.Service;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;
import com.dauphine.blogger.repositories.PostRepository;
import com.dauphine.blogger.services.PostService;

import java.util.List;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository repository;

    public PostServiceImpl(PostRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Post> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Post> getAllByValue(String value) {
        return repository.findAllByTitleOrContentLike(value);
    }

    @Override
    public Post getById(UUID id) {
        return repository.findById(id)
                        .orElse(null);
    }

    @Override
    public Post create(String title, String content, Category category) {
        Post post = new Post(title, content, category);
        return repository.save(post);
    }

    @Override
    public Post update(UUID id, String title, String content, Category category) {
        Post post = getById(id);
        if (post != null) {
            post.setTitle(title);
            post.setContent(content);
            post.setCategory(category);
            return repository.save(post);
        }
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        repository.deleteById(id);
        return true;
    }
}