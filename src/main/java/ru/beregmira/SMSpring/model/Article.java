package ru.beregmira.SMSpring.model;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String title;
    @Column(length = 1000000)
    @Lob
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
