package com.example.last.Service.ForReply;

import com.example.last.Dto.ForReply.ReplyGetDto;
import com.example.last.Entity.Reply;
import com.example.last.Repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyGetService {

    private final ReplyRepository repository;

    public ReplyGetDto GetReply(long id) {
        Reply reply = repository.getReferenceById(id);
        ReplyGetDto replyGetDto = new ReplyGetDto(reply);
        return replyGetDto;
    }


    public List<Reply> GetReplylist(long id) {
        return repository.findByPostid(id);
    }
}
