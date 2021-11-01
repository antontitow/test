package ru.titov.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
@RequestMapping("/test")
@CrossOrigin(origins = "http://localhost:3000")
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
    @PostMapping(value = "/valid", consumes = "application/json", produces = "application/json")
    ResponseEntity<Response> entry(@RequestBody @Valid Request request, BindingResult bindingResult) throws ExecutionException, InterruptedException {
        return mainService.validateCredential(request, bindingResult);
    }

    @GetMapping(value = "/list")
    ResponseEntity<String[]> getLastRequests() {
        return mainService.getLastRequests();
    }

}
