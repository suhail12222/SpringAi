package com.suhail.learn_spring.Ai.Eceptions;

public class UserNotFoundException extends   RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
