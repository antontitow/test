package ru.titov.test.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import ru.titov.test.domain.dto.Response;

import java.util.List;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Response> onNotValidEmail(MethodArgumentNotValidException MNV, WebRequest request) {
        Response response = null;
        List<ObjectError> listobjectError = MNV.getAllErrors();
        ObjectError objectError = listobjectError.get(listobjectError.size() - 1);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
