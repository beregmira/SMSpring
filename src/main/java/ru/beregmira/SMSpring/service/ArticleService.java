package ru.beregmira.SMSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beregmira.SMSpring.dao.ArticleRepository;
import ru.beregmira.SMSpring.model.Article;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository repository;

    public void save(Article article) {
        repository.save(article);
    }

    public List<Article> getAll() {
        return repository.findAll();
    }

    public Article getSingleArticle(long id){
        return repository.findOne(id);
    }
}
