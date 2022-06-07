package com.vaccine.register.error;

public class PersonNotRegisteredException extends RuntimeException {

    public PersonNotRegisteredException(String msg) {
        super(msg);
    }
}
