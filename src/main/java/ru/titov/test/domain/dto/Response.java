package ru.titov.test.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    Status status;
    Request request;
    Error[] errors;
}
