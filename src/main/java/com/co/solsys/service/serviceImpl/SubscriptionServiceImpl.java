package com.co.solsys.service.serviceImpl;

import com.co.solsys.model.Account;
import com.co.solsys.model.Subscription;
import com.co.solsys.repository.IAccountRepository;
import com.co.solsys.repository.ISubscriptionRepository;
import com.co.solsys.service.ISubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionServiceImpl implements ISubscriptionService {

    @Autowired
    private ISubscriptionRepository subscriptionRepository;

    @Override
    public ResponseEntity<Subscription> save(Subscription subscription) {
        return ResponseEntity.ok(subscriptionRepository.save(subscription));
    }

    @Override
    public ResponseEntity<Subscription> findById(int id) {
        Optional<Subscription> optional = subscriptionRepository.findById(id);
        if (optional.isPresent())
            return ResponseEntity.ok(optional.get());
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<List<Subscription>> findAll() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        if (!subscriptions.isEmpty())
            return ResponseEntity.ok(subscriptions);
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<Subscription> update(int id, Subscription subscription) {
        Subscription subscriptionDb = subscriptionRepository.findById(id).orElse(null);
        if (Optional.ofNullable(subscriptionDb).isPresent()) {
            subscriptionDb.setPhoneNumber(subscription.getPhoneNumber());
            subscriptionDb.setStatus(subscription.getStatus());
            subscriptionDb.setPricePlan(subscription.getPricePlan());
            subscriptionDb.setAccount(subscription.getAccount());
            return ResponseEntity.ok(subscriptionRepository.save(subscriptionDb));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> delete(int id) {
        Optional<Subscription> optional = subscriptionRepository.findById(id);
        if (optional.isPresent()) {
            subscriptionRepository.delete(optional.get());
            return ResponseEntity.ok("record deleted successfully!!!");
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<String> deleteAll() {
        List<Subscription> subscriptions = subscriptionRepository.findAll();
        if (!subscriptions.isEmpty()) {
            subscriptionRepository.deleteAll();
            return ResponseEntity.ok("records deleted successfully!!!");
        }
        return ResponseEntity.notFound().build();
    }
}
