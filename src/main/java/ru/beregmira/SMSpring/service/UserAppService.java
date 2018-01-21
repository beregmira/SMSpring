package ru.beregmira.SMSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beregmira.SMSpring.dao.UserAppRepository;
import ru.beregmira.SMSpring.model.UserApp;

import java.util.List;

@Service
public class UserAppService {
    @Autowired
    private UserAppRepository repository;

    public void save(UserApp userApp) {
        repository.save(userApp);
    }

    public List<UserApp> getAll() {
        return repository.findAll();
    }

    public UserApp getSingleUser(long id) {
        return repository.findOne(id);
    }

    public UserApp getUserAppByName(String userName) {
        return repository.findUserAppByName(userName);
    }
}
