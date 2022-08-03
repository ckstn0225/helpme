package com.example.last.Service.ForReply;

import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Entity.Post;
import com.example.last.Entity.Reply;
import com.example.last.Repository.PostRepository;
import com.example.last.Repository.ReplyRepository;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private final ReplyRepository repository;

    private final PostRepository postRepository;

    public ReplyService(ReplyRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }


    public String Reply(long id, ReplyDto replyDto){
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        Reply reply = new Reply(id,replyDto);
        repository.save(reply);
        return reply.getReplyid()+"성공!";
    }

    public String Delete(long id) {
        repository.deleteById(id);
        return "삭제완료";
    }
}
