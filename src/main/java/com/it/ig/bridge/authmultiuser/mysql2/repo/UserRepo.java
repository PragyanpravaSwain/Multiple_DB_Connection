package com.it.ig.bridge.authmultiuser.mysql2.repo;

import com.it.ig.bridge.authmultiuser.mysql2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
