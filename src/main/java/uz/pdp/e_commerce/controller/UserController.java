package uz.pdp.e_commerce.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.e_commerce.domain.projection.UserInfo;
import uz.pdp.e_commerce.domain.request.UserRequest;
import uz.pdp.e_commerce.service.user.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {



    private final UserServiceImpl userServiceImpl;

    @PostMapping
    public UserInfo createUser(@RequestBody UserRequest user) {
        return userServiceImpl.save(user);
    }

    @PutMapping("/id")
    public UserInfo updateUser(@RequestParam("id") Long id, @RequestBody UserRequest user) {
        return userServiceImpl.update(id, user);
    }

    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userServiceImpl.findAll();
    }

    @DeleteMapping("/id")
    public void deleteUser(@RequestParam("id") Long id) {
        userServiceImpl.deleteById(id);
    }
}
