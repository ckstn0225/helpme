package com.example.last.Controller;

import com.example.last.Dto.ForPost.DetailDto;
import com.example.last.Dto.ForPost.ListDto;
import com.example.last.Dto.ForPost.UpdateDto;
import com.example.last.Dto.ForPost.WriteDto;
import com.example.last.Repository.PostRepository;
import com.example.last.Service.ForPost.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {

    private final WriteService writeService;
    private final ListService listService;
    private final DetailSevice detailSevice;
    private final PutService putService;
    private final RemoveService removeService;


    public PostController(WriteService writeService, PostRepository postRepository, ListService listService, DetailSevice detailSevice, PutService putService, RemoveService removeService) {
        this.writeService = writeService;
        this.listService = listService;
        this.detailSevice = detailSevice;
        this.putService = putService;
        this.removeService = removeService;
    }
//  글작성
    @PostMapping("/post")
    @ResponseBody
    public String posting(@RequestBody WriteDto writeDto){

       return writeService.Write(writeDto);
    }
//    글목록조회
    @GetMapping("/post")
    @ResponseBody
    private List<ListDto> List() {
        return listService.ListGet();
    }
//    글상세조회
    @GetMapping("/post/{id}")
    @ResponseBody
    private DetailDto detail(@PathVariable long id){
        return detailSevice.detailDto(id);
    }
//    글 수정
    @PutMapping("/post/{id}")
    @ResponseBody
    private String update(@PathVariable long id, @RequestBody UpdateDto updateDto){
        return putService.Update(id, updateDto);
    }
//    글 삭제
    @DeleteMapping("/post/{id}")
    @ResponseBody
    private String remove(@PathVariable long id){
        return removeService.DeletePost(id);
    }
}
