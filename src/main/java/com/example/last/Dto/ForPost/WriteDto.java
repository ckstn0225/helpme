package com.example.last.Dto.ForPost;

import com.example.last.Entity.Timestamped;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class WriteDto extends Timestamped {
    String title;
    String contents;
    String username;
}
