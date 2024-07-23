package com.kir138.lesson4.task1.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    BACKEND_DEV("Backend Dev", 123),
    FRONTEND_DEV("Frontend Dev", 321),
    FULLSTACK_DEV("Fullstack Dev", 222);

    private final String description;
    private final int example;

}
