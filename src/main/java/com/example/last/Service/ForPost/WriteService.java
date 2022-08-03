package com.example.last.Service.ForPost;

import com.example.last.Dto.ForPost.WriteDto;
import com.example.last.Entity.Post;
import com.example.last.Repository.PostRepository;
import com.example.last.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class WriteService {

    private final PostRepository postrepository;

//    글 작성
    @Transactional
    public String Write(WriteDto writeDto, UserDetailsImpl userDetails) {
        Post post = new Post(writeDto,userDetails);
        postrepository.save(post);
        return post.getId()+"저장완료!";
    }
}
