package br.com.manualdaprogramacao.helpdesk.controller;

import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.dto.CreateUserDto;
import br.com.manualdaprogramacao.helpdesk.dto.UserDto;
import br.com.manualdaprogramacao.helpdesk.mapper.UserMapper;
import br.com.manualdaprogramacao.helpdesk.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/users")
public class UserController {

        private final UserService userService;


        private final UserMapper mapper;

        @PostMapping
        public ResponseEntity<UserDto> create(@RequestBody CreateUserDto request){
                User domain = mapper.toDomain(request);
                UserDto createdUser = mapper.toDto(userService.createUser(domain));
                 return ResponseEntity.ok(createdUser);
    }
}
