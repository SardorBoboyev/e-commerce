package uz.pdp.e_commerce.service.basket;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.pdp.e_commerce.domain.entity.BasketEntity;
import uz.pdp.e_commerce.domain.entity.UserEntity;
import uz.pdp.e_commerce.domain.exception.BaseException;
import uz.pdp.e_commerce.domain.projection.BasketInfo;
import uz.pdp.e_commerce.repository.BasketRepository;

@Service
@RequiredArgsConstructor
public class BasketServiceImpl implements BasketService {
    private final PasswordEncoder passwordEncoder;
    private final BasketService basketService;
    private final ModelMapper modelMapper;
    private final BasketRepository basketRepository;

    @Override
    public BasketInfo save(UserEntity user) {
        UserEntity userEntity = UserEntity.builder()
                .fullName(user.getFullName())
                .username(user.getUsername())
//                .password(passwordEncoder.encode(user.getPassword()))
                .build();
        BasketInfo saved = basketService.save(userEntity);
        return modelMapper.map(saved, BasketInfo.class);
    }

    @Override
    public BasketEntity findById(Long id) {
        return basketRepository.findById(id).orElseThrow(() -> new BaseException("basket not found"));
    }
}
