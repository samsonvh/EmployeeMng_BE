package fpt.swp.dsct_server3.controller;

import fpt.swp.dsct_server3.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping
    public ResponseEntity<?> findAll(){
        return new ResponseEntity<>(accountRepository.findAll(), HttpStatus.OK);
    }
}
