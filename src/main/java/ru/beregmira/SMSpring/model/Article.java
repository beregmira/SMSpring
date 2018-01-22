package ru.beregmira.SMSpring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class Article implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String title;

    @Column(length = 1000000)
    @Lob
    private String content;

    @Column(name = "userapp")
    private UserApp userApp;

    @ManyToOne
    public UserApp getUserApp() {
        return userApp;
    }

    public Article() {
    }

    public Article(UserApp userApp) {
        this.userApp = userApp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }
}
