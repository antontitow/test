package ru.titov.test.domain.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author Titov A.R. 29.10.2021
 * Error - dto object
 * Description of error
 */
@Data
@Builder
public class Error {
    private String field;
    private String description;
}
