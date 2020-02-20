package com.example.spring.web;

import com.example.spring.domain.dto.posts.PostsSaveRequestDto;
import com.example.spring.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RestWebController {

    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}
