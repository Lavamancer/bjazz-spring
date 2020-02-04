package com.lavamancer.bjazz.entity;

import lombok.Data;
import javax.persistence.*;
import java.time.ZonedDateTime;

@Data
@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
//    private DateTime date;

    private ZonedDateTime createdAt;

    @ManyToOne
    private User sender;
    @ManyToOne
    private User receiver;

}
