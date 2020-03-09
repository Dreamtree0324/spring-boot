package com.example.spring.domain.dto.osu;

import com.example.spring.domain.osu.OsuProfiles;
import com.example.spring.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OsuProfileDto {
    private Long id;
    private String userId;
    private String userName;
    private String playCount;
    private String ppRank;
    private String ppCountryRank;

    @Builder
    public OsuProfileDto(Long id, String userId, String userName, String playCount, String ppRank, String ppCountryRank){
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.playCount = playCount;
        this.ppRank = ppRank;
        this.ppCountryRank = ppCountryRank;
    }

    public OsuProfiles toEntity(){
        return OsuProfiles.builder()
                .userId(userId)
                .userName(userName)
                .playCount(playCount)
                .ppRank(ppRank)
                .ppCountryRank(ppCountryRank)
                .build();
    }
}
