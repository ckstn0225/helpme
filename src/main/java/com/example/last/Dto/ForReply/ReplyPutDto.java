package com.example.last.Dto.ForReply;

import com.example.last.Entity.Timestamped;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Setter
public class ReplyPutDto extends Timestamped {
    String contents;
    @LastModifiedDate
    LocalDateTime modifiedAt;
}
