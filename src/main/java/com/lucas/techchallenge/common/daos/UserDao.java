package com.lucas.techchallenge.common.daos;

import com.lucas.techchallenge.core.entities.User;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document
public class UserDao {
    @Id
    private UUID id;
    private String username;
    private String cpf;
    private String email;

    public UserDao() {}

    public UserDao(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.cpf = user.getCpf().toString();
        this.email = user.getEmail().toString();
    }
}
