package com.kir138.lesson4.task1.constants;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SqlQuery {
    SELECT_FROM_USERS("SELECT * FROM users"),
    FIND_USER("SELECT * FROM users WHERE id = ?"),
    DELETE_USER("DELETE FROM users WHERE id = ?"),
    INSERT_USER("INSERT INTO users (id, name, age, salary, role, team_id) "
        + "VALUES (?, ?, ?, ?, ?, ?)");

    private final String query;
}
