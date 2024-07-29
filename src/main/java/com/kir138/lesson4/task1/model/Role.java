package com.kir138.lesson4.task1.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    BACKEND_DEV("Backend Dev"),
    FRONTEND_DEV("Frontend Dev"),
    FULLSTACK_DEV("Fullstack Dev");

    private final String description;
    //private final int example;

}
