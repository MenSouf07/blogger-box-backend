package com.dauphine.blogger.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dauphine.blogger.models.Post;

public interface PostRepository extends JpaRepository<Post, UUID>{


    @Query("""
            SELECT post
            FROM Post post
            WHERE 
                UPPER(post.title) LIKE UPPER(CONCAT('%', :value, '%'))
                    OR 
                UPPER(post.content) LIKE UPPER(CONCAT('%', :value, '%'))
            """)
    List<Post> findAllByTitleOrContentLike(@Param("value") String value);
}
