package com.lucas.techchallenge.core.entities;

import com.lucas.techchallenge.common.daos.UserDao;
import com.lucas.techchallenge.common.dtos.UserDto;

import java.util.Objects;
import java.util.UUID;

public class User {
    private UUID id;
    private String username;
    private CPF cpf;
    private Email email;

    public User(UserDto userDto) throws Exception {
        validateUserName(userDto.getUserName());
        this.id = UUID.randomUUID();
        this.username = userDto.getUserName();
        this.cpf = new CPF(userDto.getCpf());
        this.email = new Email(userDto.getEmail());
    }

    public User(UserDao userDao) throws Exception {
        this.id = userDao.getId();
        this.username = userDao.getUsername();
        this.cpf = new CPF(userDao.getCpf());
        this.email = new Email(userDao.getEmail());
    }

    private void validateUserName(String userName) throws Exception {
        boolean nameIsNull = Objects.isNull(userName);
        boolean nameIsEmpty = userName.isEmpty();
        boolean nameHasLessThanThreeLetters = userName.length() < 3;

        if (nameIsNull || nameIsEmpty || nameHasLessThanThreeLetters) {
            throw new Exception("Invalid username!!!!!!!!!");
        }
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public CPF getCpf() {
        return cpf;
    }

    public void setCpf(CPF cpf) {
        this.cpf = cpf;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}
