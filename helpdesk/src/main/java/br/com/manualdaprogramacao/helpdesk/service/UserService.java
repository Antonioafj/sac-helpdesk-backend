package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.mapper.UserMapper;
import br.com.manualdaprogramacao.helpdesk.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper mapper;

    public User createUser( User newUser) {
        UserEntity entity = mapper.toEntity(newUser);
        userRepository.save(entity);
        return mapper.toDomain(entity);
    }

}
