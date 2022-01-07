package com.example.apiAnime.repository;

import com.example.apiAnime.domain.model.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimeRepository extends JpaRepository<Anime, UUID> {
    Anime findByName(String name);
}
