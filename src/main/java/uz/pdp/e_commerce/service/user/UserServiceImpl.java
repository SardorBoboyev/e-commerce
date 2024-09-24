package uz.pdp.e_commerce.service.user;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.pdp.e_commerce.domain.entity.UserEntity;
import uz.pdp.e_commerce.domain.exception.BaseException;
import uz.pdp.e_commerce.domain.projection.BasketInfo;
import uz.pdp.e_commerce.domain.projection.UserInfo;
import uz.pdp.e_commerce.domain.request.UserRequest;
import uz.pdp.e_commerce.repository.BasketRepository;
import uz.pdp.e_commerce.repository.UserRepository;
import uz.pdp.e_commerce.service.basket.BasketService;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;
    private final BasketRepository basketRepository;
    private final BasketService basketService;


    @Override
    public UserEntity findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new BaseException("User not found with username: " + username));
    }

    @Override
    public UserInfo save(UserRequest user) {
        UserEntity userEntity = UserEntity.builder()
                .fullName(user.getFullName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(user.getRole())
                .build();
        basketService.save(userEntity);
        UserEntity entity = userRepository.save(userEntity);
        return modelMapper.map(entity, UserInfo.class);
    }

    @Override
    public UserInfo update(Long id, UserRequest user) {
        UserEntity existsUser = findById(id);
        if (existsUser == null) {
            throw new BaseException("User not found with id: " + id);
        }
        existsUser.setFullName(user.getFullName());
        existsUser.setUsername(user.getUsername());
        if (existsUser.getPassword() != null && !existsUser.getPassword().isEmpty()) {
            existsUser.setPassword(passwordEncoder.encode(user.getPassword()));
        };
        UserEntity newUser = userRepository.save(existsUser);
        return modelMapper.map(newUser, UserInfo.class);
    }


    @Override
    public UserEntity findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BaseException("User not found with id: " + id));
    }

    @Override
    public List<UserInfo> findAll() {
        return userRepository.findAllBy();
    }

    @Override
    public List<UserInfo> searchUser(String text) {
        return userRepository.searchUser(text);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
