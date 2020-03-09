package com.example.spring.web;

import com.example.spring.domain.dto.osu.OsuProfileDto;
import com.example.spring.web.service.OsuService;
import com.example.spring.web.service.PostsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class WebController {

    private PostsService postsService;
    private OsuService osuService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "main";
    }

    @GetMapping("/osu")
    public String osu(Model model){
        return "osu";
    }
}
