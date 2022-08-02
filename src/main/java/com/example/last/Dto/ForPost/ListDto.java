package com.example.last.Dto.ForPost;

import com.example.last.Entity.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ListDto {
    Long id;
    String title;
    String username;
    LocalDateTime createAt;
    LocalDateTime modifiedAt;
}