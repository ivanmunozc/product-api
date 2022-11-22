package com.co.solsys.controller;

import com.co.solsys.model.Account;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import java.util.List;

public interface IAccountController {
    ResponseEntity<Account> save(Account account);
    ResponseEntity<Account> findById(int id);
    ResponseEntity<List<Account>> findAll();
    ResponseEntity<Account> update(int id, Account account);
    ResponseEntity<String> delete(int id);
    ResponseEntity<String> deleteAll();
}
