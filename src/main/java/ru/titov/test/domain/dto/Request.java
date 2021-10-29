package ru.titov.test.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
    private String surename;
    private String name;
    private String patronymic;
    private String phone;
    private String email;
    private char[] password;
    private char[] confirmPassword;
}
