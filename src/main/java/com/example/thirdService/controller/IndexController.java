package com.example.thirdService.controller;

import com.example.thirdService.model.Account;
import com.example.thirdService.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class IndexController {

    @Autowired
    private AccountService service;

    @GetMapping
    public ResponseEntity<List<Account>> notes() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("/{id}")
    private ResponseEntity<Account> byId(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.byId(id));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    private ResponseEntity<Account> save(@RequestBody Account account) {
        return ResponseEntity.ok( service.save(account));
    }

}
