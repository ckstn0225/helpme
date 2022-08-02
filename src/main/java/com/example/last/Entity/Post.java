package com.example.last.Entity;

import com.example.last.Dto.ForPost.UpdateDto;
import com.example.last.Dto.ForPost.WriteDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post extends Timestamped{
    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long postid;

    @Column(nullable = false)
    private String title;
    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;


    public Post(WriteDto writeDto) {
        this.title = writeDto.getTitle();
        this.username = writeDto.getUsername();
        this.contents = writeDto.getContents();
    }

    public void update(UpdateDto requestDto) {
        this.title = requestDto.getTitle();
        this.contents = requestDto.getContents();
    }
}
