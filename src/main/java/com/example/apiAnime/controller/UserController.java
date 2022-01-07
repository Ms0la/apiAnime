package com.example.apiAnime.controller;

import com.example.apiAnime.domain.dto.AnimeError;
import com.example.apiAnime.domain.dto.UserRegisterRequest;
import com.example.apiAnime.domain.model.Anime;
import com.example.apiAnime.domain.model.User;
import com.example.apiAnime.domain.model.projection.UserProjection;
import com.example.apiAnime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired private UserRepository userRepository;
    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @GetMapping("/")
    public List<UserProjection> findAllUsers(){
        return userRepository.findBy();
    }

    @PostMapping("/")
    public ResponseEntity<?> register(@RequestBody UserRegisterRequest userRegisterRequest) {

        if (userRepository.findByUsername(userRegisterRequest.username) == null) {
            User user = new User();
            user.username = userRegisterRequest.username;
            user.password = passwordEncoder.encode(userRegisterRequest.password);
            user.enabled = true;
            userRepository.save(user);
            return ResponseEntity.ok().body(userRepository.findProjectionByUsername(user.username)); //M'ha semblat la millor forma d'evitar filtrar dades
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(AnimeError.message("Ja existeix un usuari amb el nom '" + userRegisterRequest.username + "'"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable UUID id){
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            userRepository.delete(user);
            return  ResponseEntity.ok().body(AnimeError.message("S'ha eliminat l'usuari amd id " + "'" + id + "'"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(AnimeError.message("No s'ha trobat l'usuari amb id '" + id + "'"));
    }

    @DeleteMapping("/")
    public ResponseEntity<?> deleteAllUsers(){
        userRepository.deleteAll();
        return ResponseEntity.ok().body(AnimeError.message("S'han esborrat tots els usuaris"));
    }
}
