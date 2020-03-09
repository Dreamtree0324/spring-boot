package com.example.spring.domain.osu;

import com.example.spring.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public interface OsuProfilesRepository extends JpaRepository<OsuProfiles, Long> {
//    @Query("SELECT p " +
//            "FROM OsuProfiles p " +
//            "WHERE p.userName LIKE 'HyeN'")
//    Stream<OsuProfiles> findUserName(String userName);

    @Query("SELECT p " +
            "FROM OsuProfiles p " +
            "ORDER BY p.Id DESC")
    Stream<OsuProfiles> findAllDesc();
}
