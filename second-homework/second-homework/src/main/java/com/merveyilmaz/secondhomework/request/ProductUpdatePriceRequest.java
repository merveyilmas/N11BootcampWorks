package com.merveyilmaz.secondhomework.request;

public record ProductUpdatePriceRequest(Long id, double oldPrice, double newPrice) {

}