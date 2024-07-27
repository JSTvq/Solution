package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.constants.SqlQuery;
import com.kir138.lesson4.task1.model.Team;
import com.kir138.lesson4.task1.sqlConnect.PgConnect;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class PgTeamRepository implements CrudRepository<Team, Long> {

    private final Connection connection = PgConnect.getConnection();

    @Override
    public List<Team> findAll() {
        List<Team> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlQuery.SELECT_FROM_TEAMS.getQuery())) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                Team team = Team.builder()
                    .id(id)
                    .name(name)
                    .department(department)
                    .build();
                list.add(team);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Optional<Team> findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.FIND_TEAM.getQuery())) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long teamId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                Team team = Team.builder()
                    .id(teamId)
                    .name(name)
                    .department(department)
                    .build();
                return Optional.of(team);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public List<Team> deleteById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.DELETE_TEAM.getQuery())) {
            preparedStatement.setLong(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected == 0) {
                throw new RuntimeException("No team found with id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return findAll();
    }

    @Override
    public List<Team> save(Team team) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.INSERT_TEAM.getQuery())) {
            //preparedStatement.setLong(1, team.getId());
            preparedStatement.setString(1, team.getName());
            preparedStatement.setString(2, team.getDepartment());

            preparedStatement.executeUpdate();
            return findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
