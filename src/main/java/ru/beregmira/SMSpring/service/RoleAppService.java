package ru.beregmira.SMSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beregmira.SMSpring.dao.UserAppRepository;
import ru.beregmira.SMSpring.model.UserApp;

import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoleAppService {
    @Autowired
    private UserAppRepository repository;

    public void save(UserApp userApp) {
        repository.save(userApp);
    }

    public List<UserApp> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(repository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .collect(Collectors.toList());

    }
}
