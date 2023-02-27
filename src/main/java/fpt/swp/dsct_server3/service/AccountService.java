package fpt.swp.dsct_server3.service;

import fpt.swp.dsct_server3.entity.Account;

public interface AccountService {
    Account findByUsername(String username);
}
