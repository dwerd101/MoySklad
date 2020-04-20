package com.moysklad.dao.spring;

import com.moysklad.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserAccount, Integer> {
    UserAccount findByName(String name);
}
