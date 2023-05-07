package com.projects.collab.service;

import com.projects.collab.dal.PortalRepository;
import com.projects.collab.entity.PortalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private PortalRepository repository;

    public Iterable<PortalUser> findAllAdmins() {
        Iterable<PortalUser> findings = repository.findAll();
        List<PortalUser> result = new ArrayList<>();
        for(PortalUser user : findings) {
            if(Objects.nonNull(user.getAdmin()) && user.getAdmin()) {
                result.add(user);
            }
        }
        return result;
    }

    public Iterable<PortalUser> findNonAdmins() {
        Iterable<PortalUser> findings = repository.findAll();
        List<PortalUser> result = new ArrayList<>();
        for(PortalUser user : findings) {
            if(Objects.isNull(user.getAdmin()) || !user.getAdmin()) {
                result.add(user);
            }
        }
        return result;
    }

    public Optional<PortalUser> findById(String phonenumber) {
        return repository.findById(phonenumber);
    }
}
