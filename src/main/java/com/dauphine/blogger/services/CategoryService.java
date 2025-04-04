package com.dauphine.blogger.services;

import java.util.List;
import com.dauphine.blogger.models.Category;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAll();
    
    List<Category> getAllLikeName(String name);

    Category getById(UUID id);

    Category create(String name);

    Category update(UUID id, String name);

    boolean delete(UUID id);
}
