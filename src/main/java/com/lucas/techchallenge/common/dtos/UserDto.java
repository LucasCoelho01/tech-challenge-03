package com.lucas.techchallenge.common.dtos;

public class UserDto {
    private String userName;
    private String cpf;
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserDto() {}

    public UserDto(String userName, String cpf, String email) {
        this.userName = userName;
        this.cpf = cpf;
        this.email = email;
    }
}
