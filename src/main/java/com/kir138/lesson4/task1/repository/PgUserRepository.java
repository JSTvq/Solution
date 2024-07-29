package com.kir138.lesson4.task1.repository;

import com.kir138.lesson4.task1.constants.SqlQuery;
import com.kir138.lesson4.task1.model.Role;
import com.kir138.lesson4.task1.model.User;
import com.kir138.lesson4.task1.sqlConnect.PgConnect;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PgUserRepository implements CrudRepository<User, Long> {

    private final Connection connection = PgConnect.getConnection();

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(SqlQuery.SELECT_FROM_USERS.getQuery())) {

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                Role role = Role.valueOf(resultSet.getString(("role")));
                Long team_id = resultSet.getLong("team_id");
                list.add(User.builder()
                    .id(id)
                    .name(name)
                    .age(age)
                    .salary(salary)
                    .role(role)
                    .team_id(team_id)
                    .build()
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Optional<User> findById(Long id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.FIND_USER.getQuery())) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Long userId = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Integer age = resultSet.getInt("age");
                BigDecimal salary = resultSet.getBigDecimal("salary");
                Role role = Role.valueOf(resultSet.getString("role"));
                Long team_id = resultSet.getLong("team_id");
                User user = User.builder()
                    .id(userId)
                    .name(name)
                    .age(age)
                    .salary(salary)
                    .role(role)
                    .team_id(team_id)
                    .build();
                return Optional.of(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteById(Long id) {
        Optional<User> userToDelete = findById(id);
        if (userToDelete.isPresent()) {
            try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.DELETE_USER.getQuery())) {
                preparedStatement.setLong(1, id);
                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected == 0) {
                    throw new RuntimeException("No user found with id: " + id);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return userToDelete;
    }

    @Override
    public User save(User user) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SqlQuery.INSERT_USER.getQuery())) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getAge());
            preparedStatement.setBigDecimal(3, user.getSalary());
            preparedStatement.setString(4, String.valueOf(user.getRole()));
            preparedStatement.setLong(5, user.getTeam_id());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
