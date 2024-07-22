package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.sqlConnect.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PgUserRepository extends Connect implements CrudRepository<User, Long> {

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users")) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                Role role = Role.valueOf(resultSet.getString(("role")));
                int team_id = resultSet.getInt("team_id");
                list.add(new User(id, name, age, salary, role, team_id));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Optional<User> findById(Long id) {
        String findUser = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(findUser)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                int salary = resultSet.getInt("salary");
                Role role = Role.valueOf(resultSet.getString("role"));
                int team_id = resultSet.getInt("team_id");
                User user = new User(userId, name, age, salary, role, team_id);
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {
        String deleteUser = "DELETE FROM users WHERE id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(deleteUser)) {
            preparedStatement.setLong(1, id);
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected == 0) {
                throw new RuntimeException("No user found with id: " + id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void save(User user) {
        String insertUser = "INSERT INTO users (id, name, age, salary, role, team_id) "
            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(insertUser)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getAge());
            preparedStatement.setInt(4, user.getSalary());
            preparedStatement.setString(5, String.valueOf(user.getRole()));
            preparedStatement.setInt(6, user.getTeam_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
