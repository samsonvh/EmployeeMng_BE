package fpt.swp.dsct_server3.service.impl;

import fpt.swp.dsct_server3.entity.Account;
import fpt.swp.dsct_server3.repository.AccountRepository;
import fpt.swp.dsct_server3.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {
        return accountRepository.findByUsername(username).get();
    }
}
