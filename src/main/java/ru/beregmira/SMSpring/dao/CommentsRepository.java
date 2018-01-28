package ru.beregmira.SMSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.Comment;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {
    List<Comment> findCommentByArticleid(Long articleid);

    int countByUserid(Long id);
}
