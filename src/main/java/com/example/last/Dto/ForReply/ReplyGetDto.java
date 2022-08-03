package com.example.last.Dto.ForReply;


import com.example.last.Entity.Reply;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyGetDto {
    long id;
    long postid;
    String contents;
    String username;
    LocalDateTime createAt;
    LocalDateTime modifiedAt;

    public ReplyGetDto(Reply reply) {
        this.id = reply.getPostid();
        this.postid = reply.getPostid();
        this.contents = reply.getContents();
        this.username = reply.getUsername();
        this.createAt = reply.getCreatedAt();
        this.modifiedAt = reply.getModifiedAt();


    }
}
