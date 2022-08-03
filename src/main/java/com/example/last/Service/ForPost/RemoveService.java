package com.example.last.Service.ForPost;

import com.example.last.Entity.Reply;
import com.example.last.Repository.PostRepository;
import com.example.last.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class RemoveService {

    private final PostRepository postRepository;

    private final ReplyRepository replyRepository;

    @Transactional
    public String DeletePost(Long id){
        postRepository.deleteById(id);
        List<Reply> reply = replyRepository.findByPostid(id);
        for (int i = 0; i < reply.size(); i++) {
            replyRepository.deleteById(reply.get(i).getReplyid());
        }
        return "ID: ["+id+"]의 삭제 완료";
    }
}
