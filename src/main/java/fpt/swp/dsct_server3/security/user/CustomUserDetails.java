package fpt.swp.dsct_server3.security.user;

import fpt.swp.dsct_server3.entity.Account;
import fpt.swp.dsct_server3.entity.Contract;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor
@Data
public class CustomUserDetails implements UserDetails, Serializable {
    private Account account;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(account.getRole().getName()));
        if (account.getEmployee() != null) {
            for (Contract contract : account.getEmployee().getContracts()) {
                if (contract.getStatus().equalsIgnoreCase("Active")) {
                    authorities.add(new SimpleGrantedAuthority(contract.getJobPosition().getName()));
                    authorities.add(new SimpleGrantedAuthority(contract.getDepartment().getName()));
                    break;
                }
            }
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
