package com.example.last.Service.ForReply;

import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Entity.Post;
import com.example.last.Entity.Reply;
import com.example.last.Repository.PostRepository;
import com.example.last.Repository.ReplyRepository;
import com.example.last.security.UserDetailsImpl;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {

    private final ReplyRepository repository;

    private final PostRepository postRepository;

    public ReplyService(ReplyRepository repository, PostRepository postRepository) {
        this.repository = repository;
        this.postRepository = postRepository;
    }


    public String Reply(long id, ReplyDto replyDto, UserDetailsImpl userDetails){
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        Reply reply = new Reply(id,replyDto,userDetails);
        repository.save(reply);
        return reply.getPostid()+"번 게시글에"+reply.getReplyid()+"번 댓글 작성";
    }

    public String Delete(long id,UserDetailsImpl userDetails) {
        if(!repository.getReferenceById(id).getUsername().equals(userDetails.getUsername())){
            return "본인 댓글만 삭제 가능합니다.";
        }
        repository.deleteById(id);
        return id+"번 삭제완료";
    }
}
