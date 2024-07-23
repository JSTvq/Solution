//package com.kir138.lesson4.task1.repository;
//
//import com.kir138.lesson4.task1.model.Team;
//import lombok.RequiredArgsConstructor;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//public class PgTeamRepository implements CrudRepository<Team, Long> {
//
//    @Override
//    public List<Team> findAll() {
//        List<Team> list = new ArrayList<>();
//        try (Connection connection = getConnection();
//             Statement statement = connection.createStatement();
//             ResultSet resultSet = statement.executeQuery("SELECT * FROM teams")) {
//
//            while (resultSet.next()) {
//                Long id = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String department = resultSet.getString("department");
//                list.add(new Team(id, name, department));
//            }
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return list;
//    }
//
//    @Override
//    public Optional<Team> findById(Long id) {
//        String findTeam = "SELECT * FROM teams where id = ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(findTeam)) {
//            preparedStatement.setLong(1, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                Long teamId = resultSet.getLong("id");
//                String name = resultSet.getString("name");
//                String department = resultSet.getString("department");
//                Team team = new Team(teamId, name, department);
//                return Optional.of(team);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return Optional.empty();
//    }
//
//    @Override
//    public void save(Team team) {
//        String insertUser = "INSERT INTO teams (id, name, department) "
//            + "VALUES (?, ?, ?)";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(insertUser)) {
//            preparedStatement.setLong(1, team.getId());
//            preparedStatement.setString(2, team.getName());
//            preparedStatement.setString(3, team.getDepartment());
//
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        String deleteTeam = "DELETE FROM teams WHERE id = ?";
//        try (Connection connection = getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(deleteTeam)) {
//            preparedStatement.setLong(1, id);
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected == 0) {
//                throw new RuntimeException("No team found with id: " + id);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//    }
//}
