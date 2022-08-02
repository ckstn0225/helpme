package com.example.last.Service.ForPost;


import com.example.last.Dto.ForPost.DetailDto;
import com.example.last.Entity.Post;
import com.example.last.Repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.xml.soap.Detail;

@Service
public class DetailSevice {

    private final PostRepository postRepository;


    public DetailSevice(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Transactional
    public DetailDto detailDto(Long id) {
        Post post = postRepository.getReferenceById(id);
        return new DetailDto(post);
    }



}
