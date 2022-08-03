package com.example.last.Service.ForReply;


import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Dto.ForReply.ReplyGetDto;
import com.example.last.Dto.ForReply.ReplyPutDto;
import com.example.last.Entity.Post;
import com.example.last.Entity.Reply;
import com.example.last.Repository.ReplyRepository;
import com.example.last.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyPutService {


    private final ReplyRepository repository;

    public String putReply(long id, ReplyPutDto replyDto, UserDetailsImpl userDetails) {
        Reply reply = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        if (!reply.getUsername().equals(userDetails.getUsername())){
            return "본인 댓글만 수정가능합니다.";
        }
        reply.update(replyDto);
        repository.save(reply);
        return reply.getPostid()+"번 게시글에"+reply.getReplyid()+"번 댓글 수정";
    }
}
