package com.example.plateforme.repositories;

import com.example.plateforme.entites.SocialChannel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialChannelRepository extends JpaRepository<SocialChannel, Long> {
    List<SocialChannel> findByUserId(Long userId);
}
