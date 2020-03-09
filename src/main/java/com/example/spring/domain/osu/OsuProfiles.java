package com.example.spring.domain.osu;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class OsuProfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 15, nullable = false)
    private String userId;

    @Column(length = 30, nullable = false)
    private String userName;

    @Column(length = 10, nullable = false)
    private String playCount;

    @Column
    private String ppRank;

    @Column
    private String ppCountryRank;

    @Builder
    public OsuProfiles(String userId, String userName, String playCount, String ppRank, String ppCountryRank ){
        this.userId = userId;
        this.userName = userName;
        this.playCount = playCount;
        this.ppRank = ppRank;
        this.ppCountryRank = ppCountryRank;
    }
}
