package com.example.last.Dto.ForPost;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateDto {

    String title;
    String contents;
    @LastModifiedDate
    LocalDateTime modifiedAt;

}
