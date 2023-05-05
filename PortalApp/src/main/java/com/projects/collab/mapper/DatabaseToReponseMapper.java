package com.projects.collab.mapper;

import com.projects.collab.entity.PortalUser;
import com.projects.collab.pojo.Address;
import com.projects.collab.pojo.RegistrationUser;
import com.projects.collab.pojo.UserResponse;

public class DatabaseToReponseMapper {

    public static UserResponse mapToUserResponse(PortalUser portalUser) {
        UserResponse userResponse = new UserResponse();
        userResponse.setPhonenumber(portalUser.getPhonenumber());
        userResponse.setAadhaar(portalUser.getAadhaar());
        userResponse.setFirstname(portalUser.getFirstname());
        userResponse.setMiddlename(portalUser.getMiddlename());
        userResponse.setLastname(portalUser.getLastname());
        Address address = new Address();
        address.setAddressline1(portalUser.getAddress().getAddressline1());
        address.setAddressline2(portalUser.getAddress().getAddressline2());
        address.setVillage(portalUser.getAddress().getVillage());
        address.setMandal(portalUser.getAddress().getMandal());
        address.setDistrict(portalUser.getAddress().getDistrict());
        address.setCity(portalUser.getAddress().getCity());
        address.setState(portalUser.getAddress().getState());
        address.setPostalcode(portalUser.getAddress().getPostalcode());
        userResponse.setAddress(address);
        return userResponse;
    }

    public static PortalUser mapRegistrationUserToPortalUser(RegistrationUser user) {
        PortalUser userEntity = new PortalUser();
        userEntity.setAadhaar(user.getAadhaar());
        userEntity.setPhonenumber(user.getPhonenumber());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setMiddlename(user.getMiddlename());
        userEntity.setLastname(user.getLastname());
        com.projects.collab.entity.Address addressEntity = new com.projects.collab.entity.Address();
        addressEntity.setAddressline2(user.getAddress().getAddressline1());
        addressEntity.setAddressline2(user.getAddress().getAddressline2());
        addressEntity.setVillage(user.getAddress().getVillage());
        addressEntity.setMandal(user.getAddress().getMandal());
        addressEntity.setDistrict(user.getAddress().getDistrict());
        addressEntity.setCity(user.getAddress().getCity());
        addressEntity.setState(user.getAddress().getState());
        addressEntity.setPostalcode(user.getAddress().getPostalcode());
        userEntity.setAddress(addressEntity);
        return userEntity;
    }
}
