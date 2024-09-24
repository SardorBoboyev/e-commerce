package uz.pdp.e_commerce.domain.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.pdp.e_commerce.domain.enumerators.UserRole;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private String fullName;
    private String username;
    private UserRole role;
    private String password;
}
