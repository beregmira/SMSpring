package ru.beregmira.SMSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.UserApp;


@Repository
public interface UserAppRepository extends JpaRepository<UserApp, Long> {

}
