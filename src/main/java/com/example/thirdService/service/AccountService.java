package com.example.thirdService.service;

import com.example.thirdService.model.Account;
import com.example.thirdService.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepo repo;

    public List<Account> list() {
        return repo.findAll();
    }

    public Account byId(Long id) {
        return repo.findById(id).orElse(new Account());
    }

    public Account save(Account note) {
        return repo.save(note);
    }

    public void delete(Long id) {
        repo.findById(id).ifPresent(repo::delete);
    }

}
