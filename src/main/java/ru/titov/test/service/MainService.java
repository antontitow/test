package ru.titov.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import ru.titov.test.domain.dto.Error;
import ru.titov.test.domain.dto.Request;
import ru.titov.test.domain.dto.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Titov A.R. 29.10.2021
 * MainService
 * Validate credentials
 */
@Service
public class MainService {
    final RequestValidator requestValidator;

    @Autowired
    public MainService(RequestValidator requestValidator) {
        this.requestValidator = requestValidator;
    }

    /**
     * Check all rules
     *
     * @param request
     * @return result and list of errors
     */
    public ResponseEntity<Response> validateCredential(Request request, BindingResult bindingResult) {
        String status = "OK";
        requestValidator.validate(request, bindingResult);
        List<Error> errorList = new ArrayList<>(10);
        List<ObjectError> objectErrorList = bindingResult.getAllErrors();
        if (!objectErrorList.isEmpty()) {
            status = null;
            objectErrorList.stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                errorList.add(Error.builder().field(fieldError.getField()).description(fieldError.getDefaultMessage()).build());
            });
        }

        return new ResponseEntity<Response>(Response.builder().status(status).errors(errorList).build(), HttpStatus.ACCEPTED);
    }
}
