package fpt.swp.dsct_server3.security.authModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest implements Serializable {
    private String username;
    private String password;
}
