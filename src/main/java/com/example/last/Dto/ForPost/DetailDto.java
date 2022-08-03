package com.example.last.Dto.ForPost;

import com.example.last.Entity.Post;
import com.example.last.Entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DetailDto {
    Long id;
    String title;
    String contents;
    String username;
    List<Reply> reply;
    LocalDateTime createAt;
    LocalDateTime modifiedAt;

    public DetailDto(Post post,List<Reply> reply) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.username = post.getUsername();
        this.reply = reply;
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }


}