package com.co.solsys.repository;

import com.co.solsys.model.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillingAddressRepository extends JpaRepository<BillingAddress, Integer> {
}
