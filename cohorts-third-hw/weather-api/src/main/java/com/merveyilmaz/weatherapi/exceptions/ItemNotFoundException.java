package com.merveyilmaz.weatherapi.exceptions;

import com.merveyilmaz.weatherapi.general.BaseErrorMessage;
import com.merveyilmaz.weatherapi.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {

    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}

