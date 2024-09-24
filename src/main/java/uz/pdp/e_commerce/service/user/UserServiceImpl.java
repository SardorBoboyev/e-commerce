package uz.pdp.e_commerce.service.user;

import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.UserEntity;
import uz.pdp.e_commerce.domain.exception.BaseException;
import uz.pdp.e_commerce.domain.projection.UserInfo;
import uz.pdp.e_commerce.domain.request.UserRequest;
import uz.pdp.e_commerce.repository.UserRepository;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;


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
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
