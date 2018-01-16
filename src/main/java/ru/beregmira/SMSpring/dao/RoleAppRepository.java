package ru.beregmira.SMSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.beregmira.SMSpring.model.RoleApp;

@Repository
public interface RoleAppRepository extends JpaRepository<RoleApp, Long> {
}
