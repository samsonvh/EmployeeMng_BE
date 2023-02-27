package fpt.swp.dsct_server3.security.authModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse implements Serializable {
    private String type;
    private String accessToken;
    private String refreshToken;
    private String role;
    private String jobPosition;
    private String department;
}
