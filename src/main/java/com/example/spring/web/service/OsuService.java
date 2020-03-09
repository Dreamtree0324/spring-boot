package com.example.spring.web.service;

import com.example.spring.domain.dto.osu.OsuProfileDto;
import com.example.spring.domain.dto.posts.PostsMainResponseDto;
import com.example.spring.domain.dto.posts.PostsSaveRequestDto;
import com.example.spring.domain.osu.OsuProfilesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OsuService {

    private OsuProfilesRepository osuProfilesRepository;

    @Transactional
    public Long osuDBSave(OsuProfileDto dto){
        return osuProfilesRepository.save(dto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public OsuProfileDto findByUserName(String userName){
        return findByUserName(userName);
    }
}
