package com.co.solsys.service;

import com.co.solsys.model.BillingAddress;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBillingAddressService {

    ResponseEntity<BillingAddress> save(BillingAddress billingAddress);
    ResponseEntity<BillingAddress> findById(int id);
    ResponseEntity<List<BillingAddress>> findAll();
    ResponseEntity<BillingAddress> update(int id, BillingAddress billingAddress);
    ResponseEntity<String> delete(int id);
    ResponseEntity<String> deleteAll();
}
