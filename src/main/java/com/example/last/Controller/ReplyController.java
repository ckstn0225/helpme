package com.example.last.Controller;


import com.example.last.Dto.ForReply.ReplyDto;
import com.example.last.Dto.ForReply.ReplyGetDto;
import com.example.last.Dto.ForReply.ReplyPutDto;
import com.example.last.Entity.Reply;
import com.example.last.Service.ForReply.ReplyGetService;
import com.example.last.Service.ForReply.ReplyPutService;
import com.example.last.Service.ForReply.ReplyService;
import com.example.last.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    private final ReplyGetService replyGetService;
    private final ReplyPutService replyPutService;


//    댓글 달기
    @PostMapping("/reply/{id}")
    @ResponseBody
    public String reply(@PathVariable long id, @RequestBody ReplyDto replyDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return replyService.Reply(id,replyDto,userDetails);
    }

//    댓글id로 조회
    @GetMapping("/reply/{id}")
    @ResponseBody
    public ReplyGetDto Getreply(@PathVariable long id){
        return replyGetService.GetReply(id);
    }

//    댓글 게시글에있는거 전체조회
    @GetMapping("reply/post/{id}")
    @ResponseBody
    public List<Reply> GetListreply(@PathVariable long id) {
        return replyGetService.GetReplylist(id);
    }
// 댓글 수정
    @PutMapping("/reply/{id}")
    public String Putreply(@PathVariable long id, @RequestBody ReplyPutDto replyDto,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return replyPutService.putReply(id,replyDto,userDetails);
    }
//    댓글 삭제

    @DeleteMapping("/reply/{id}")
    public String Delete(@PathVariable long id,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return replyService.Delete(id,userDetails);
    }
}
