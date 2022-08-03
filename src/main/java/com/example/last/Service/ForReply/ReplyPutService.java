package com.example.last.Service.ForReply;


import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Dto.ForReply.ReplyGetDto;
import com.example.last.Dto.ForReply.ReplyPutDto;
import com.example.last.Entity.Post;
import com.example.last.Entity.Reply;
import com.example.last.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyPutService {


    private final ReplyRepository repository;

    public String putReply(long id, ReplyPutDto replyDto) {
        Reply reply = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        reply.update(replyDto);
        repository.save(reply);
        return "수정완료";
    }
}
