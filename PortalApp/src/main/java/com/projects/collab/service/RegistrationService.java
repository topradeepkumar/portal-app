package com.projects.collab.service;

import com.projects.collab.dal.PortalRepository;
import com.projects.collab.entity.PortalUser;
import com.projects.collab.mapper.DatabaseToReponseMapper;
import com.projects.collab.pojo.RegistrationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private PortalRepository repository;

    public boolean register(RegistrationUser user) {
        boolean result = true;
        try{
            PortalUser userEntity = DatabaseToReponseMapper.mapRegistrationUserToPortalUser(user);
            repository.save(userEntity);
        } catch(Exception exception) {
            exception.printStackTrace();
            result = false;
        }
        return result;
    }
}
