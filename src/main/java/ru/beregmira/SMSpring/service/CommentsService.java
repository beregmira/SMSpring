package ru.beregmira.SMSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beregmira.SMSpring.dao.CommentsRepository;
import ru.beregmira.SMSpring.model.Comment;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    UserAppService userAppService;

    @Autowired
    private CommentsRepository repository;

    public void save(Comment comment) {
        repository.save(comment);
    }

    public List<Comment> getAll() {
        return repository.findAll();
    }

    public List<Comment> getAllCommentsByArticleId(Long articleid) {
        return repository.findCommentByArticleid(articleid);
    }

    public Comment getSingleComment(long id) {
        return repository.findOne(id);
    }

    public String getUserAppNameById(Long id) {
        return userAppService.getUserNameById(id);
    }

    public void deleteCommentById(Long id) {
        repository.delete(id);
    }
}
