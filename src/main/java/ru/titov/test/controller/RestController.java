package ru.titov.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.titov.test.domain.dto.Request;
import ru.titov.test.domain.dto.Response;
import ru.titov.test.service.MainService;

import javax.validation.Valid;
import java.util.concurrent.ExecutionException;

/**
 * @author Titov 29.10.2021
 * RestController for validation
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {
    MainService mainService;

    @Autowired
    public RestController(MainService mainService) {
        this.mainService = mainService;
    }


    /**
     * @param request
     * @return validation credential
     */
    @PostMapping(consumes = "application/json", produces = "application/json")
    ResponseEntity<Response> entry(@RequestBody @Valid Request request, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        return mainService.validateCredential(request, bindingResult);
    }
}
