package com.example.last.Service.ForPost;

import com.example.last.Dto.ForPost.UpdateDto;
import com.example.last.Entity.Post;
import com.example.last.Repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PutService {

    private final PostRepository postRepository;


    public PutService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public String Update(Long id, UpdateDto updateDto) {
        Post post1 = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        post1.update(updateDto);
        return "ID: ["+post1.getPostid()+"]의 업데이트 완료!";
    }
}
