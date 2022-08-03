package com.example.last.Service.ForPost;


import com.example.last.Dto.ForPost.DetailDto;
import com.example.last.Entity.Post;
import com.example.last.Repository.PostRepository;
import com.example.last.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class DetailSevice {

    private final PostRepository postRepository;
    private final ReplyRepository repository;



    @Transactional
    public DetailDto detailDto(Long id) {
        DetailDto detailDto = new DetailDto(postRepository.getReferenceById(id),repository.findByPostid(id));

        return detailDto;
    }

}
