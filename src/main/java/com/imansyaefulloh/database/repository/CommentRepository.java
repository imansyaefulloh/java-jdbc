package com.imansyaefulloh.database.repository;

import com.imansyaefulloh.database.entity.Comment;

import java.util.List;

public interface CommentRepository {
    void insert(Comment comment);
    Comment findById(Integer id);
    List<Comment> findAll();
    List<Comment> findAllByEmail(String email);
}
