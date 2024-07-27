package com.kir138.lesson4.task1.service;

import com.kir138.lesson4.task1.model.Team;
import com.kir138.lesson4.task1.repository.PgTeamRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PgTeamService implements CrudService<Team, Long> {
    public final PgTeamRepository pgTeamRepository;

    @Override
    public List<Team> findAll() {
        return pgTeamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(pgTeamRepository.findById(id))
            .orElseThrow(() -> new RuntimeException("Team with id %s not found".formatted(id)));
    }

    @Override
    public List<Team> save(Team team) {
        pgTeamRepository.save(team);
        return findAll();
    }

    @Override
    public List<Team> deleteById(Long id) {
        pgTeamRepository.deleteById(id);
        return findAll();
    }
}
