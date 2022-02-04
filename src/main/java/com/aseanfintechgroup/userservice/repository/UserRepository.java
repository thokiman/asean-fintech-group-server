package com.aseanfintechgroup.userservice.repository;

import com.aseanfintechgroup.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

}
