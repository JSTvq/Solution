package com.kir138.lesson4.task1.service;

import com.kir138.lesson4.task1.model.Team;
import com.kir138.lesson4.task1.repository.TeamRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class TeamService implements CrudService<Team, Long> {
    private final TeamRepository teamRepository;

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Optional<Team> findById(Long id) {
        return Optional.ofNullable(teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team with id %s not found".formatted(id))));
    }

    public Team findByName(String name) {
        return teamRepository.findByName(name)
            .orElseThrow(() -> new RuntimeException("User with name %s not found".formatted(name)));
    }

    @Override
    public List<Team> save(Team team) {
        teamRepository.save(team);
        return findAll();
    }

    @Override
    public List<Team> deleteById(Long id) {
        teamRepository.deleteById(id);
        return findAll();
    }
}
