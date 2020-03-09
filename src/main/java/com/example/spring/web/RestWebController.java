package com.example.spring.web;

import com.example.spring.domain.dto.osu.OsuProfileDto;
import com.example.spring.domain.dto.posts.PostsSaveRequestDto;
import com.example.spring.domain.posts.PostsRepository;
import com.example.spring.web.service.OsuService;
import com.example.spring.web.service.PostsService;
import lombok.AllArgsConstructor;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

@RestController
@AllArgsConstructor
public class RestWebController {

    private PostsService postsService;
    private OsuService osuService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello, World";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto){
        return postsService.save(dto);
    }

    @RequestMapping(value="/osuProfile", method= {RequestMethod.GET, RequestMethod.POST})
    public String osuName(@RequestBody String username){

        StringBuffer result = new StringBuffer();
        try{
            String urlstr = "https://osu.ppy.sh/api/get_user?u="+ username +"&m=3&k=224149061918fc3b8d628b27c2982820ec43c06c";
            URL url = new URL(urlstr);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");

            BufferedReader br = new BufferedReader((new InputStreamReader(urlConnection.getInputStream(),"UTF-8")));

            String returnLine;

            while((returnLine = br.readLine()) != null){
                result.append(returnLine);
                System.out.println(br.readLine());
            }
            urlConnection.disconnect();
        } catch (Exception e){
            e.printStackTrace();
        }


        return result.toString();
    }

    @PostMapping("/osuSearch")
    public Long osuSearchResult(@RequestBody OsuProfileDto dto){
        return osuService.osuDBSave(dto);
    }
}
