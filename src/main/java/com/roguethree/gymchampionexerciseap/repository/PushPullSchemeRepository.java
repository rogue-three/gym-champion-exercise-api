package com.roguethree.gymchampionexerciseap.repository;

import com.roguethree.gymchampionexerciseap.model.PushPullScheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PushPullSchemeRepository extends JpaRepository<PushPullScheme, Long> {

    Optional<PushPullScheme> findByPpSchemeName(String name);
}
