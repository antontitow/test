package ru.titov.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import ru.titov.test.domain.ContainerRequest;
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
    private final RequestValidator requestValidator;
    private ContainerRequest containerRequest;

    @Autowired
    public MainService(RequestValidator requestValidator, ContainerRequest containerRequest) {
        this.requestValidator = requestValidator;
        this.containerRequest = containerRequest;
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
        List<Error> errorList = new ArrayList<>();
        List<ObjectError> objectErrorList = bindingResult.getAllErrors();
        if (!objectErrorList.isEmpty()) {
            status = null;
            objectErrorList.stream().forEach(error -> {
                FieldError fieldError = (FieldError) error;
                errorList.add(Error.builder().field(fieldError.getField()).description(fieldError.getDefaultMessage()).build());
            });
        }
        Response response = Response.builder().status(status).errors(errorList).build();
        containerRequest.addResult(parseRequest(response));
        System.out.println(containerRequest.getListResults());
        return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED);
    }

    private final String parseRequest(Response response) {
        if (response.getStatus() != null) {
            return "Регистрация успешна";
        } else {
            return response.getErrors().stream().map(Error::getDescription).reduce((s1, s2) -> s1 + ", " + s2).orElse("");
        }
    }

    public ResponseEntity<String[]> getLastRequests() {
        String[] result = containerRequest.getListResults().subList(containerRequest.getListResults().size()-4,containerRequest.getListResults().size()).stream().toArray(String[]::new);
        return new ResponseEntity<String[]>(result, HttpStatus.ACCEPTED);
    }
}
