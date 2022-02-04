package com.aseanfintechgroup.userservice.repository;

import com.aseanfintechgroup.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    public Role findByName(String name);
}
