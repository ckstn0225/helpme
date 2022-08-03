package com.example.last.Controller;


import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Dto.ForReply.ReplyGetDto;
import com.example.last.Dto.ForReply.ReplyPutDto;
import com.example.last.Entity.Reply;
import com.example.last.Service.ForReply.ReplyGetService;
import com.example.last.Service.ForReply.ReplyPutService;
import com.example.last.Service.ForReply.ReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    private final ReplyGetService replyGetService;
    private final ReplyPutService replyPutService;


    @PostMapping("/reply/{id}")
    @ResponseBody
    public String reply(@PathVariable long id, @RequestBody ReplyDto replyDto){
        return replyService.Reply(id,replyDto);
    }

//    댓글id로 조회
    @GetMapping("/reply/{id}")
    @ResponseBody
    public ReplyGetDto Getreply(@PathVariable long id){
        return replyGetService.GetReply(id);
    }

//    댓글
    @GetMapping("reply/post/{id}")
    @ResponseBody
    public List<Reply> GetListreply(@PathVariable long id) {
        return replyGetService.GetReplylist(id);
    }

    @PutMapping("/reply/{id}")
    public String Putreply(@PathVariable long id, @RequestBody ReplyPutDto replyDto) {
        return replyPutService.putReply(id,replyDto);
    }
    @DeleteMapping("/reply/{id}")
    public String Delete(@PathVariable long id) {
        return replyService.Delete(id);
    }
}
