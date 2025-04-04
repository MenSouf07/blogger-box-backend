package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAll();
    List<Post> getAllByValue(String value);
    Post getById(UUID id);
    Post create(String title, String text, Category category);
    Post update(UUID id, String title, String text, Category category);
    boolean delete(UUID id);
}
