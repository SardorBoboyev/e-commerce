package uz.pdp.e_commerce.service.user;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.UserEntity;
import uz.pdp.e_commerce.domain.projection.JwtInfo;
import uz.pdp.e_commerce.domain.request.LoginRequest;
import uz.pdp.e_commerce.domain.projection.UserInfo;
import uz.pdp.e_commerce.domain.request.UserRequest;
import uz.pdp.e_commerce.service.jwtService.JwtService;


@Service
public class AuthService {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;


    public UserInfo registerUser(UserRequest userRequest) {
        UserEntity user = UserEntity.builder()
                .fullName(userRequest.getFullName())
                .username(userRequest.getUsername())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .role(userRequest.getRole())
                .build();
        return modelMapper.map(user, UserInfo.class);
    }


    public JwtInfo login(LoginRequest loginRequest) {
        UserEntity user = userServiceImpl.findByUsername(loginRequest.getUsername());
        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            return new JwtInfo(jwtService.generateToken(user));
        }
        throw new UsernameNotFoundException("Invalid username or password");
    }

}
