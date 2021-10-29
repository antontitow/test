package ru.titov.test.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.titov.test.domain.dto.Request;

@Service
public class RequestValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Request.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Request request = (Request) target;
        if (request.getEmail() == null && request.getPhone() == null) {
            errors.rejectValue("phone", "phoneNotNull", "Поле обязательно, если нет почты");
            errors.rejectValue("email", "emailNotNull", "Поле обязательно, если нет телефона");
        }
    }
}
