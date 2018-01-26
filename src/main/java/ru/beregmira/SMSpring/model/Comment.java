package ru.beregmira.SMSpring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "comments")
public class Comment implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 1000000)
    @Lob
    private String content;

    @Column
    private Long userid;

    @Column
    private Long articleid;

}