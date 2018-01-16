package ru.beregmira.SMSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.beregmira.SMSpring.dao.RoleAppRepository;

@Service
public class RoleAppService {
    @Autowired
    private RoleAppRepository repository;
    }
