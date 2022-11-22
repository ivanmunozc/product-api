package com.co.solsys.controller;

import com.co.solsys.model.Subscription;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ISubscriptionController {

    ResponseEntity<Subscription> save(Subscription subscription);
    ResponseEntity<Subscription> findById(int id);
    ResponseEntity<List<Subscription>> findAll();
    ResponseEntity<Subscription> update(int id, Subscription subscription);
    ResponseEntity<String> delete(int id);
    ResponseEntity<String> deleteAll();
}
