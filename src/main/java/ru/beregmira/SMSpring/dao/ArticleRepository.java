package ru.beregmira.SMSpring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.Article;


@Repository
public interface ArticleRepository extends CrudRepository<Article, Long> {
}
