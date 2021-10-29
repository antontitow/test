package ru.titov.test.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.titov.test.domain.dto.Error;
import ru.titov.test.domain.dto.Request;
import ru.titov.test.domain.dto.Response;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author Titov A.R. 29.10.2021
 * Validate credentials
 */
@Service
public class MainService {
    /**
     * Check all rules
     *
     * @param request
     * @return result and list of errors
     */
    public ResponseEntity<Response> validateCredential(Request request) throws ExecutionException, InterruptedException {
        String emailPattern = "";
        Error[] errors = null;
        Request tmpRequest = null;
        return new ResponseEntity<Response>(CompletableFuture.supplyAsync(() -> {

            return Response.builder().request(request).build();
        }).get(), HttpStatus.ACCEPTED);
//        return new ResponseEntity<Response>(Response.builder().request(request).build(), HttpStatus.ACCEPTED);
    }
}
