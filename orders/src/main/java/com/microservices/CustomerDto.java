package com.microservices;

public record CustomerDto(
    Integer id,
    String firstName,
    String lastName,
    String email
) {}
