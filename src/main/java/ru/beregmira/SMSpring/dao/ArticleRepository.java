package ru.beregmira.SMSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    int countByUserid(Long id);
}