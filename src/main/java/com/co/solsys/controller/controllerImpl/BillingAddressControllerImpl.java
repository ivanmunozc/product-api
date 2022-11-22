package com.co.solsys.controller.controllerImpl;

import com.co.solsys.controller.IBillingAddressController;
import com.co.solsys.model.BillingAddress;
import com.co.solsys.service.IBillingAddressService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/billing")
public class BillingAddressControllerImpl implements IBillingAddressController {

    @Autowired
    private IBillingAddressService billingAddressService;

    @Override
    @PostMapping()
    @ApiOperation(value = "Insert billing information in DB", tags = "Billing",
            notes = "First you have to create an address in Billling, then you can create an account in Account and finally create the subscription en Subcription." )
    public ResponseEntity<BillingAddress> save(@Valid @RequestBody BillingAddress billingAddress
    )  {
        return billingAddressService.save(billingAddress);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Get bill from id specific", tags = "Billing" ,
            notes = "First you have to create an address in Billling, then you can create an account in Account and finally create the subscription en Subcription." )
    public ResponseEntity<BillingAddress> findById(@PathVariable int id) {
        return billingAddressService.findById(id);
    }

    @Override
    @GetMapping("/findAll")
    @ApiOperation(value = "Get all bill", tags = "Billing" ,
            notes = "First you have to create an address in Billling, then you can create an account in Account and finally create the subscription en Subcription." )
    public ResponseEntity<List<BillingAddress>> findAll() {
        return billingAddressService.findAll();
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value = "Update specific field", tags = "Billing" ,
            notes = "First you have to create an address in Billling, then you can create an account in Account and finally create the subscription en Subcription." )

    public ResponseEntity<BillingAddress> update(@PathVariable int id, @Valid @RequestBody BillingAddress billingAddress) {

        return billingAddressService.update(id, billingAddress);
    }

    @Override
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete especific ID", tags = "Billing" )
    public ResponseEntity<String> delete(@PathVariable int id) {
        return billingAddressService.delete(id);
    }

    @Override
    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "Delete all ID", tags = "Billing" )
    public ResponseEntity<String> deleteAll() {
        return billingAddressService.deleteAll();
    }

}
