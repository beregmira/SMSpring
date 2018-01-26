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

    @Column
    private String tags;

    @Column
    private Long userid;

    public Article() {
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

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}