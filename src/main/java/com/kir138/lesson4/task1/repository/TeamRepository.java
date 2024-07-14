package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.Team;
import lombok.RequiredArgsConstructor;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

//findById, findByName, save(User user), deleteById(Long id),
// update (Логика апдейта должны быть в методе save)
// List<User> findAll()
@RequiredArgsConstructor
public class TeamRepository implements CrudRepository<Team, String> {

    private final Path path;

    @Override
    public List<Team> findAll() {
        return List.of();
    }

    @Override
    public Optional<Team> findById(String id) {
        return Optional.empty();
    }

    @Override
    public void save(Team team) {

    }

    @Override
    public void deleteById(String id) {

    }
}
