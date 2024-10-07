package com.imansyaefulloh.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.imansyaefulloh.database.entity.Comment;
import com.imansyaefulloh.database.repository.CommentRepository;
import com.imansyaefulloh.database.repository.CommentRepositoryImpl;

import java.util.List;

public class RepositoryTest {

  private CommentRepository commentRepository;

  @BeforeEach
  void setUp() {
    commentRepository = new CommentRepositoryImpl();
  }

  @Test
  void testInsert() {
    Comment comment = new Comment("eko@test.com", "hi");
    commentRepository.insert(comment);

    Assertions.assertNotNull(comment.getId());
    System.out.println(comment.getId());
  }

  @Test
  void testFindById() {
    Comment comment = commentRepository.findById(2302);
    Assertions.assertNotNull(comment);
    System.out.println(comment.getId());
    System.out.println(comment.getEmail());
    System.out.println(comment.getComment());

    Comment notFound = commentRepository.findById(10000000);
    Assertions.assertNull(notFound);
  }

  @Test
  void testFindAll() {
    List<Comment> comments = commentRepository.findAll();
    System.out.println(comments.size());
  }

  @Test
  void testFindByEmail() {
    List<Comment> comments = commentRepository.findAllByEmail("salah@test.com");
    System.out.println(comments.size());
  }
}