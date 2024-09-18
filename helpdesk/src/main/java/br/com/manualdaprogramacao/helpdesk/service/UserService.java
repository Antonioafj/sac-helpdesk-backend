package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.exception.BusinessException;
import br.com.manualdaprogramacao.helpdesk.mapper.UserMapper;
import br.com.manualdaprogramacao.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    public User createUser( User newUser) {

        Optional<UserEntity> existentUser = userRepository.findByUsername(newUser.getUsername());

        if (existentUser.isPresent()){
            throw new BusinessException("This username is already in use in the system");
        }

        UserEntity entity = mapper.toEntity(newUser);
        entity.setCreateAt(new Date());
        entity = userRepository.save(entity);
        return mapper.toDomain(entity);
    }

}
