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
    @NotNull(message = "Поле обязательно")
    @Pattern(regexp = "^([^\\d]+)$", message = "Обычная строка, в которую нельзя ввести цифры")
    private String surename;

    @NotNull(message = "Поле обязательно")
    @Pattern(regexp = "^([^\\d]+)$", message = "Обычная строка, в которую нельзя ввести цифры")
    private String name;

    @Pattern(regexp = "^([^\\d]+)$", message = "Обычная строка, в которую нельзя ввести цифры")
    private String patronymic;

    @Pattern(regexp = "^([^\\p{Lower}\\p{Upper}]+)$", message = "Обычная строка, в которую нельзя ввести буквы")
    private String phone;

    @Pattern(regexp = ".+@.+", message = "Должно содержать @")
    private String email;

    private char[] password;

    private char[] confirmPassword;
}
