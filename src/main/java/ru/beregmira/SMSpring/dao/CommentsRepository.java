package ru.beregmira.SMSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.Comment;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {
}