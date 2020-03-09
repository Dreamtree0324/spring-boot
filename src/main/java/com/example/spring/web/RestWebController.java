package com.example.spring.web;

import com.example.spring.domain.dto.posts.PostsSaveRequestDto;
import com.example.spring.domain.posts.PostsRepository;
import com.example.spring.web.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestWebController {

    private PostsService postsService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }
}
