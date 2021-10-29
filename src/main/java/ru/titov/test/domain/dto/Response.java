package ru.titov.test.domain.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author Titov A.R. 29.10.2021
 * Response - dto object
 */
@Data
@Builder
public class Response {
    String status = "OK";
    List<Error> errors;
}
