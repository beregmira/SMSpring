package ru.beregmira.SMSpring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "article")
public class Article implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column(length = 1000000)
    @Lob
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;

    public String getUserName() {
        return userApp.getName();
    }

    public Article(String title, String content, UserApp userApp) {
        this.title = title;
        this.content = content;
        this.userApp = userApp;
    }

    public Article() {

    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

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
