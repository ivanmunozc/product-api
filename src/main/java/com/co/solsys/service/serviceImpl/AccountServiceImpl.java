package com.co.solsys.service.serviceImpl;

import com.co.solsys.model.Account;
import com.co.solsys.model.BillingAddress;
import com.co.solsys.repository.IAccountRepository;
import com.co.solsys.repository.IBillingAddressRepository;
import com.co.solsys.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;
    @Autowired
    private IBillingAddressRepository billingAddressRepository;

    @Override
    public ResponseEntity<Account> save(Account account) {
        Optional<BillingAddress> billingAddress = billingAddressRepository.findById(account.getBillingAddress().getId());
        if (billingAddress.isPresent())
        return ResponseEntity.ok(accountRepository.save(account));
        if (!Optional.ofNullable(account).isPresent() ||
                null == account.getBalance() ||
                null == account.getStatus()
        ) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Account> findById(int id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent())
            return ResponseEntity.ok(optional.get());
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountRepository.findAll();
        if (!accounts.isEmpty())
            return ResponseEntity.ok(accounts);
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Account> update(int id, Account account) {
        Account accountDb = accountRepository.findById(id).orElse(null);
        if (Optional.ofNullable(accountDb).isPresent()) {
            accountDb.setBalance(account.getBalance());
            accountDb.setStatus(account.getStatus());
            return ResponseEntity.ok(accountRepository.save(accountDb));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (optional.isPresent()) {
            accountRepository.delete(optional.get());
            return ResponseEntity.ok("record deleted successfully!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> deleteAll() {
        List<Account> accounts = accountRepository.findAll();
        if (!accounts.isEmpty()) {
            accountRepository.deleteAll();
            return ResponseEntity.ok("records deleted successfully!!!");
        }
        return ResponseEntity.notFound().build();
    }

}