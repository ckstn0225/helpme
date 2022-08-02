package com.example.last.Dto.ForPost;

import com.example.last.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailDto {
    Long id;
    String title;
    String contents;
    String username;
    LocalDateTime createAt;
    LocalDateTime modifiedAt;

    public DetailDto(Post post) {
        this.id = post.getPostid();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.username = post.getUsername();
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }
}