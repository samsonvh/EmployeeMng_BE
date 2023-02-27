package fpt.swp.dsct_server3.controller;

import fpt.swp.dsct_server3.constant.URLConstant;
import fpt.swp.dsct_server3.entity.Account;
import fpt.swp.dsct_server3.entity.Contract;
import fpt.swp.dsct_server3.security.authModel.LoginRequest;
import fpt.swp.dsct_server3.security.authModel.LoginResponse;
import fpt.swp.dsct_server3.security.jwt.JwtUtils;
import fpt.swp.dsct_server3.service.AccountService;
import fpt.swp.dsct_server3.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    AccountService accountService;

    @Autowired
    ContractService contractService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping(URLConstant.AUTHENTICATE)
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        Account account = accountService.findByUsername(loginRequest.getUsername());
        Contract contract = contractService.findByEmployeeId(account.getEmployee().getId());
        return new ResponseEntity<>(new LoginResponse("Bearer", jwt, null, account.getRole().getName(),contract.getJobPosition().getName(), contract.getDepartment().getName()), HttpStatus.OK);
    }
}
