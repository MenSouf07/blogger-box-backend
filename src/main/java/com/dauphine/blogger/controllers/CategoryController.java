package com.dauphine.blogger.controllers;

import com.dauphine.blogger.dtos.CategoryRequest;
import com.dauphine.blogger.models.Category;
import com.dauphine.blogger.services.CategoryService;

import io.swagger.v3.oas.annotations.Operation;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("v1/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }

    @GetMapping
    @Operation(
        summary = "Get all categories",
        description = "retrieve all categories or filter like name"
    )
    public List<Category> getAll(@RequestParam(required = false) String name){
        List<Category> categories = name == null || name.isBlank()
                                    ? service.getAll()
                                    : service.getAllLikeName(name);
        return categories;
    }

    @GetMapping("{id}")
    public Category getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PostMapping
    public Category create(@RequestBody CategoryRequest categoryRequest) {
        return service.create(categoryRequest.getName());
    }

    @PutMapping("{id}")
    public Category update( @PathVariable UUID id,
                            @RequestBody CategoryRequest categoryRequest) {
        return service.update(id,categoryRequest.getName());
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable UUID id) {
        return service.delete(id);
    }

}
