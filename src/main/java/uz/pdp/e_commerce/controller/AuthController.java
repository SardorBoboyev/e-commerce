package uz.pdp.e_commerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.e_commerce.domain.projection.JwtInfo;
import uz.pdp.e_commerce.domain.projection.UserInfo;
import uz.pdp.e_commerce.domain.request.LoginRequest;
import uz.pdp.e_commerce.domain.request.UserRequest;
import uz.pdp.e_commerce.service.user.AuthService;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {


    private final AuthService authService;


    @PostMapping("/login")
    private JwtInfo login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register")
    private UserInfo register(@RequestBody UserRequest userRequest) {
        return authService.registerUser(userRequest);
    }

}
