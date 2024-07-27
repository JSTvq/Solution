package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.Team;
import lombok.RequiredArgsConstructor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@RequiredArgsConstructor
public class TeamRepository implements CrudRepository<Team, Long> {

    public Path getFilePath() {
        return Paths.get("C:\\Games\\Команда v1.csv");
    }

    @Override
    public List<Team> findAll() {
        List<Team> listTeam = new ArrayList<>();
        try (Stream<String> lines = Files.lines(getFilePath())) {
            List<String> line = lines.skip(1).toList();

            for (String s : line) {
                String[] values = s.split(";");
                Long id = Long.parseLong(values[0]);
                String name = values[1];
                String department = values[2];
                Team team = Team.builder()
                    .id(id)
                    .name(name)
                    .department(department)
                    .build();
                listTeam.add(team);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return listTeam;
    }

    @Override
    public Optional<Team> findById(Long id) {
        return findAll().stream()
            .filter(team -> team.getId().equals(id))
            .findFirst();
    }

    public Optional<Team> findByName(String name) {
        return findAll().stream()
            .filter(team -> team.getName().equals(name))
            .findFirst();
    }

    @Override
    public List<Team> deleteById(Long id) {
        List<Team> teams = findAll();
        teams.removeIf(team -> team.getId().equals(id));
        saveAllTeams(teams);
        return findAll();
    }

    @Override
    public List<Team> save(Team team) {
        List<Team> teams = findAll();
        teams.removeIf(u1 -> u1.getId().equals(team.getId()));
        teams.add(team);
        saveAllTeams(teams);
        return findAll();
    }

    private void saveAllTeams(List<Team> teams) {
        List<String> list = new ArrayList<>();
        list.add("id;name;department");

        for (Team team : teams) {
            list.add(team.getId() + ";" + team.getName() + ";" +
                team.getDepartment());
        }
        try {
            Files.write(getFilePath(), list, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

