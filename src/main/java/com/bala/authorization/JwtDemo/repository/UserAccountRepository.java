package com.bala.authorization.JwtDemo.repository;

import com.bala.authorization.JwtDemo.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<Account,Integer> {
        Account findByUserName(String username);
}
