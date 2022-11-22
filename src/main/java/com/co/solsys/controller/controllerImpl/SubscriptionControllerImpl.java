package com.co.solsys.controller.controllerImpl;

import com.co.solsys.controller.ISubscriptionController;
import com.co.solsys.model.Subscription;
import com.co.solsys.service.ISubscriptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/subscription")
public class SubscriptionControllerImpl implements ISubscriptionController {

    @Autowired
    private ISubscriptionService subscriptionService;

    @Override
    @PostMapping
    @ApiOperation(value = "Insert information in DB", tags = "Suscription")
    public ResponseEntity<Subscription> save(@Valid @RequestBody Subscription subscription) {
        System.out.println("account: " + subscription.getAccount());
        return subscriptionService.save(subscription);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Get suscription from id specific", tags = "Suscription")
    public ResponseEntity<Subscription> findById(@PathVariable int id) {
        return subscriptionService.findById(id);
    }

    @Override
    @GetMapping("/findAll")
    @ApiOperation(value = "Get all suscription", tags = "Suscription")
    public ResponseEntity<List<Subscription>> findAll() {
        return subscriptionService.findAll();
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value = "Update specific suscription", tags = "Suscription")
    public ResponseEntity<Subscription> update(@PathVariable int id, @Valid @RequestBody Subscription subscription) {
        return subscriptionService.update(id, subscription);
    }

    @Override
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete specific suscription by ID", tags = "Suscription")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return subscriptionService.delete(id);
    }

    @Override
    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "Delete all specific", tags = "Suscription")
    public ResponseEntity<String> deleteAll() {
        return subscriptionService.deleteAll();
    }
}
