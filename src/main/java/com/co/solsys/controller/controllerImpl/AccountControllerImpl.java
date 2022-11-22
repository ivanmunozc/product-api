package com.co.solsys.controller.controllerImpl;

import com.co.solsys.controller.IAccountController;
import com.co.solsys.model.Account;
import com.co.solsys.service.IAccountService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;



import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/account")
public class AccountControllerImpl implements IAccountController {

    @Autowired
    private IAccountService accountService;

    @Override
    @PostMapping()
    @ApiOperation(value = "Insert information in DB", tags = "Account")
    public ResponseEntity<Account> save(@Valid @RequestBody Account account) {
        return accountService.save(account);
    }

    @Override
    @GetMapping("/{id}")
    @ApiOperation(value = "Get account from id specific", tags = "Account")
    public ResponseEntity<Account> findById(@PathVariable int id) {
        return accountService.findById(id);
    }

    @Override
    @GetMapping("/findAll")
    @ApiOperation(value = "Get all account", tags = "Account")
    public ResponseEntity<List<Account>> findAll() {
        return accountService.findAll();
    }

    @Override
    @PutMapping("/{id}")
    @ApiOperation(value = "Update specific account", tags = "Account")
    public ResponseEntity<Account> update(@PathVariable int id, @Valid @RequestBody Account account) {
        return accountService.update(id, account);
    }

    @Override
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete specific account by ID", tags = "Account")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return accountService.delete(id);
    }

    @Override
    @DeleteMapping("/deleteAll")
    @ApiOperation(value = "Delete all account", tags = "Account")
    public ResponseEntity<String> deleteAll() {
        return accountService.deleteAll();
    }
}
