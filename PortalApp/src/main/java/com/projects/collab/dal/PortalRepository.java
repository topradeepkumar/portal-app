package com.projects.collab.dal;

import com.projects.collab.entity.PortalUser;
import org.springframework.data.repository.CrudRepository;

public interface PortalRepository extends CrudRepository<PortalUser, String> {
}
