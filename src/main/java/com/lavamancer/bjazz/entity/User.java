package com.lavamancer.bjazz.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class User {

    @Id                                                     // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // autoincrement
    private Long id;
    private String username;
    private String email;
    @JsonIgnore                                             // este campo es ignorado al devolver la respuesta
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "sender")                         // hacemos una relacion bidireccional con la tabla message
    private List<Message> senderMessages = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "receiver")
    private List<Message> receiverMessages = new ArrayList<>();

}
