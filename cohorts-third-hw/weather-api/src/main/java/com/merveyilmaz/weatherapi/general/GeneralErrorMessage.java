package com.merveyilmaz.weatherapi.general;

public enum GeneralErrorMessage implements BaseErrorMessage{
    ITEM_NOT_FOUND("Item not found!"),
    JSON_PROCCESSING_ERROR("An exception occurred while processing json!"),
    VALIDATION_ERROR("Validation errors found!");


    private final String message;

    GeneralErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
