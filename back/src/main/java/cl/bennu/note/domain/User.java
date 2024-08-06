package cl.bennu.note.domain;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {

    private Long id;
    private String username;
    private String password;
    private boolean active;
    private Timestamp lastLogin;
    private Timestamp lastPassword;

}
