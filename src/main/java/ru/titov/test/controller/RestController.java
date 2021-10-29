package ru.titov.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.titov.test.domain.dto.Request;
import ru.titov.test.domain.dto.Response;
import ru.titov.test.service.MainService;

import java.util.concurrent.ExecutionException;

/**
 * @author Titov 29.10.2021
 * Rest controller for validation
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/a")
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
    @PostMapping(value = "/entry", consumes = "application/json", produces = "application/json")
    ResponseEntity<Response> entry(@RequestBody Request request) throws ExecutionException, InterruptedException {
        return mainService.validateCredential(request);
    }
}
