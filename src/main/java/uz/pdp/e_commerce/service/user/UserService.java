package uz.pdp.e_commerce.service.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.UserEntity;
import uz.pdp.e_commerce.domain.projection.UserInfo;
import uz.pdp.e_commerce.domain.request.UserRequest;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {

    UserEntity findByUsername(String username);

    UserInfo save(UserRequest user);

    UserInfo update(Long id, UserRequest user);

    UserEntity findById(Long id);

    void deleteById(Long id);

    List<UserInfo> findAll();

    List<UserInfo> searchUser(String text);

}
