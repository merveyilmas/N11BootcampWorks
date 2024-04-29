package com.merveyilmaz.productservice.exceptions;

import com.merveyilmaz.productservice.general.BaseErrorMessage;
import com.merveyilmaz.productservice.general.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ItemNotFoundException extends BusinessException {
    public ItemNotFoundException(BaseErrorMessage baseErrorMessage) {
        super(baseErrorMessage);
    }
}
