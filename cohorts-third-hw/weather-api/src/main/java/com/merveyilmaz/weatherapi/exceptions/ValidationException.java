package com.merveyilmaz.weatherapi.exceptions;

import com.merveyilmaz.weatherapi.general.BaseErrorMessage;
import com.merveyilmaz.weatherapi.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PROCESSING)
public class ValidationException extends BusinessException {

    public ValidationException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
