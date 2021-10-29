package ru.titov.test.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Status {
    private int code;
    private String description;
}
