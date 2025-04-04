package com.dauphine.blogger.services;

import com.dauphine.blogger.models.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> getAll();
    Post getById(UUID id);
    Post create(String title, String text, UUID category_id);
    Post update(UUID id, String title, String text, UUID category_id);
    boolean delete(UUID id);
}
