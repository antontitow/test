package ru.titov.test.domain.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Titov A.R. 29.10.2021
 * Request - dto object
 */
@Data
@Builder
public class Request {
    @NotNull(message = "Не указана фамилия")
    @Pattern(regexp = "^([^\\d]+)$", message = "Фамилия не должна содержать цифры")
    private String surename;

    @NotNull(message = "Имя не указано")
    @Pattern(regexp = "^([^\\d]+)$", message = "Имя не должно содержать цифры")
    private String name;

    @Pattern(regexp = "^([^\\d]+)$", message = "Отчество не должно содержать цифры")
    private String patronymic;

    @Pattern(regexp = "^([^\\p{Lower}\\p{Upper}]+)$", message = "Телефон не должен содержать буквы")
    private String phone;

    @Pattern(regexp = ".+@.+", message = "Имейл должен содержать @")
    private String email;

    private char[] password;

    private char[] confirmPassword;
}
