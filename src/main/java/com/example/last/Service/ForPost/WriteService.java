package com.example.last.Service.ForPost;

import com.example.last.Dto.ForPost.WriteDto;
import com.example.last.Entity.Post;
import com.example.last.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class WriteService {

    private final PostRepository postrepository;

//    글 작성
    @Transactional
    public String Write(WriteDto writeDto) {
        Post post = new Post(writeDto);
        postrepository.save(post);
        return "저장완료!";
    }
}
