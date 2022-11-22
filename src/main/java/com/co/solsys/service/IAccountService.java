package com.co.solsys.service;

import com.co.solsys.model.Account;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAccountService {

    ResponseEntity<Account> save(Account account);
    ResponseEntity<Account> findById(int id);
    ResponseEntity<List<Account>> findAll();
    ResponseEntity<Account> update(int id, Account account);
    ResponseEntity<String> delete(int id);
    ResponseEntity<String> deleteAll();
}
