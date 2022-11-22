package com.co.solsys.service.serviceImpl;

import com.co.solsys.model.BillingAddress;
import com.co.solsys.repository.IBillingAddressRepository;
import com.co.solsys.service.IBillingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillingAddressServiceImpl implements IBillingAddressService {

    @Autowired
    private IBillingAddressRepository billingAddressRepository;

    @Override
    public ResponseEntity<BillingAddress> save(BillingAddress billingAddress) {
        if (!Optional.ofNullable(billingAddress).isPresent() ||
                null == billingAddress.getAddress1() ||
                null == billingAddress.getAddress2() ||
                null == billingAddress.getProvidence() ||
                null == billingAddress.getPostalCode()
        ) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(billingAddressRepository.save(billingAddress));
    }

    @Override
    public ResponseEntity<BillingAddress> findById(int id) {
        Optional<BillingAddress> optional = billingAddressRepository.findById(id);
        if (optional.isPresent())
            return ResponseEntity.ok(optional.get());
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<BillingAddress>> findAll() {
        List<BillingAddress> billingAddresses = billingAddressRepository.findAll();
        if (!billingAddresses.isEmpty())
            return ResponseEntity.ok(billingAddresses);
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<BillingAddress> update(int id, BillingAddress billingAddress) {
        BillingAddress billingAddressDb = billingAddressRepository.findById(id).orElse(null);
        if (Optional.ofNullable(billingAddressDb).isPresent()) {

            if (billingAddress.getAddress1() != null)
            billingAddressDb.setAddress1(billingAddress.getAddress1());
            if (billingAddress.getAddress2() != null)
            billingAddressDb.setAddress2(billingAddress.getAddress2());
            if (billingAddress.getPostalCode() != null)
            billingAddressDb.setPostalCode(billingAddress.getPostalCode());
            if (billingAddress.getProvidence() != null)
            billingAddressDb.setProvidence(billingAddress.getProvidence());



            return ResponseEntity.ok(billingAddressRepository.save(billingAddressDb));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        Optional<BillingAddress> optional = billingAddressRepository.findById(id);
        if (optional.isPresent()) {
            billingAddressRepository.delete(optional.get());
            return ResponseEntity.ok("record deleted successfully!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> deleteAll() {
        List<BillingAddress> billingAddresses = billingAddressRepository.findAll();
        if (!billingAddresses.isEmpty()) {
            billingAddressRepository.deleteAll();
            return ResponseEntity.ok("records deleted successfully!!!");
        }
        return ResponseEntity.notFound().build();
    }

}
