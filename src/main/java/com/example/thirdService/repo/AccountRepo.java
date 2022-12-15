package com.example.thirdService.repo;

import com.example.thirdService.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepo extends JpaRepository<Account, Long> {
}
