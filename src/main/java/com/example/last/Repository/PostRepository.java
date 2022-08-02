package com.example.last.Repository;

import com.example.last.Dto.ForPost.ListDto;
import com.example.last.Entity.Auther;
import com.example.last.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


}
