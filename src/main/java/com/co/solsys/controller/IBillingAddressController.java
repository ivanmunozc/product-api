package com.co.solsys.controller;

import com.co.solsys.model.BillingAddress;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBillingAddressController {
    ResponseEntity<BillingAddress> save(BillingAddress billingAddress);
    ResponseEntity<BillingAddress> findById(int id);
    ResponseEntity<List<BillingAddress>> findAll();
    ResponseEntity<BillingAddress> update(int id, BillingAddress billingAddress);
    ResponseEntity<String> delete(int id);
    ResponseEntity<String> deleteAll();
}
