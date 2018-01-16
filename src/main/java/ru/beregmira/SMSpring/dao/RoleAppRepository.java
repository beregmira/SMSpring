package ru.beregmira.SMSpring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.UserApp;


@Repository
public interface RoleAppRepository extends CrudRepository<UserApp, Long> {
}
