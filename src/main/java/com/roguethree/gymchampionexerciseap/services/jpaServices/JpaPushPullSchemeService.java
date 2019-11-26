package com.roguethree.gymchampionexerciseap.services.jpaServices;

import com.roguethree.gymchampionexerciseap.model.PushPullScheme;
import com.roguethree.gymchampionexerciseap.repository.PushPullSchemeRepository;
import com.roguethree.gymchampionexerciseap.services.PushPullSchemeService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JpaPushPullSchemeService implements PushPullSchemeService {

    private final PushPullSchemeRepository ppRepository;

    public JpaPushPullSchemeService(PushPullSchemeRepository ppRepository) {
        this.ppRepository = ppRepository;
    }

    @Override
    public Stream<PushPullScheme> findAll() {
        return ppRepository.findAll().stream();
    }

    @Override
    public Optional<PushPullScheme> findById(Long id) {
        return ppRepository.findById(id);
    }

    @Override
    public Optional<PushPullScheme> findByName(String name) {
        return ppRepository.findByPpSchemeName(name);
    }
}
