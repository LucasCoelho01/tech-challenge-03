package com.lucas.techchallenge.core.entities;

import lombok.Data;

@Data
public class Email {
    private String email;

    public Email(String email) throws Exception {
        boolean isEmailValid = validateEmail(email);

        if (isEmailValid) {
            this.email = email;
        } else {
            throw new Exception("Invalid email!!!!!!!");
        }
    }

    private boolean validateEmail(String email) {
        return true;
    }

    @Override
    public String toString() {
        return this.email;
    }
}
