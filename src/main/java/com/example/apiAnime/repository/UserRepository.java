package com.example.apiAnime.repository;

import com.example.apiAnime.domain.model.User;
import com.example.apiAnime.domain.model.projection.UserProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    User findByUsername(String username);
    UserProjection findProjectionByUsername(String username);
    List<UserProjection> findBy();
}

