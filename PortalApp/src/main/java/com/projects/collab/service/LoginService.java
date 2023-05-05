package com.projects.collab.service;

import com.projects.collab.dal.PortalRepository;
import com.projects.collab.entity.PortalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private PortalRepository repository;

    public Iterable<PortalUser> findAll() {
        return repository.findAll();
    }

    public Optional<PortalUser> findById(String phonenumber) {
        return repository.findById(phonenumber);
    }
}
