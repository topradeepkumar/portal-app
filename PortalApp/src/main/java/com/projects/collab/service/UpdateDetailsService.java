package com.projects.collab.service;

import com.projects.collab.dal.PortalRepository;
import com.projects.collab.entity.PortalUser;
import com.projects.collab.mapper.DatabaseToReponseMapper;
import com.projects.collab.pojo.RegistrationUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UpdateDetailsService {

    @Autowired
    private PortalRepository repository;

    public boolean updateUserDetails(RegistrationUser user) {
        boolean result = true;
        try{
            java.util.Optional<PortalUser> adminUser =  repository.findById(user.getAdminUserId());
            if(adminUser.isPresent()) {
                PortalUser portalUserAdmin = adminUser.get();
                if(portalUserAdmin.getAdmin()) {
                    PortalUser userEntity = DatabaseToReponseMapper.mapRegistrationUserToPortalUser(user);
                    repository.save(userEntity);
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } catch(Exception exception) {
            exception.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean deleteUserDetails(RegistrationUser user) {
        boolean result = true;
        try{
            java.util.Optional<PortalUser> adminUser =  repository.findById(user.getAdminUserId());
            if(adminUser.isPresent()) {
                PortalUser portalUserAdmin = adminUser.get();
                if(portalUserAdmin.getAdmin()) {
                    PortalUser userEntity = DatabaseToReponseMapper.mapRegistrationUserToPortalUser(user);
                    repository.deleteById(userEntity.getPhonenumber());
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } catch(Exception exception) {
            exception.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean updateUserToAdmin(RegistrationUser user) {
        boolean result = true;
        try{
            java.util.Optional<PortalUser> adminUser =  repository.findById(user.getAdminUserId());
            if(adminUser.isPresent()) {
                PortalUser portalUserAdmin = adminUser.get();
                if(Objects.isNull(portalUserAdmin.getAdmin()) || !portalUserAdmin.getAdmin()) {
                    portalUserAdmin.setAdmin(Boolean.TRUE);
                    repository.save(portalUserAdmin);
                } else {
                    result = false;
                }
            } else {
                result = false;
            }
        } catch(Exception exception) {
            exception.printStackTrace();
            result = false;
        }
        return result;
    }
}
