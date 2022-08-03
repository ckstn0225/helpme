package com.example.last.Entity;


import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Dto.ForReply.ReplyPutDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reply extends Timestamped{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long replyid;

    @Column(nullable = false)
    private Long postid;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;






    public Reply(long id ,ReplyDto replyDto) {
        this.postid = id;
        this.contents = replyDto.getContents();
        this.username = replyDto.getUsername();
    }



    public void update(ReplyPutDto requestDto) {
        this.contents = requestDto.getContents();
        this.setModifiedAt(requestDto.getModifiedAt());
    }
}
