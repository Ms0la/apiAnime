package com.example.apiAnime.controller;

import com.example.apiAnime.domain.model.Anime;
import com.example.apiAnime.repository.AnimeRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animes")
public class AnimeController {

    private final AnimeRepository animeRepository;
    AnimeController(AnimeRepository animeRepository){
        this.animeRepository = animeRepository;
    }
    @GetMapping("/")
    public List<Anime> findAllMovies(){
        return animeRepository.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnime(@PathVariable UUID id){
        Anime anime = animeRepository.findById(id).orElse(null);
        if(anime==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(anime);
    }
    /*@GetMapping("/java")
    public String talycual2(){
        return "D O L O R";
    }
    @PostMapping("/")
    public Anime createMovie(@RequestBody Anime movie){return animeRepository.save(movie);}*/

}
