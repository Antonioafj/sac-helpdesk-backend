package br.com.manualdaprogramacao.helpdesk.mapper;

import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.dto.CreateUserDto;
import br.com.manualdaprogramacao.helpdesk.dto.UserDto;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T18:15:50-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toDomain(UserEntity entity) {
        if ( entity == null ) {
            return null;
        }

        User user = new User();

        user.setId( entity.getId() );
        user.setUsername( entity.getUsername() );
        user.setPassword( entity.getPassword() );
        user.setName( entity.getName() );
        user.setEmail( entity.getEmail() );
        user.setCreateAt( entity.getCreateAt() );

        return user;
    }

    @Override
    public UserDto toDto(User domain) {
        if ( domain == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( domain.getId() );
        userDto.setUsername( domain.getUsername() );
        userDto.setName( domain.getName() );
        userDto.setEmail( domain.getEmail() );
        userDto.setCreateAt( domain.getCreateAt() );

        return userDto;
    }

    @Override
    public UserEntity toEntity(User domain) {
        if ( domain == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( domain.getId() );
        userEntity.setUsername( domain.getUsername() );
        userEntity.setPassword( domain.getPassword() );
        userEntity.setName( domain.getName() );
        userEntity.setEmail( domain.getEmail() );
        userEntity.setCreateAt( domain.getCreateAt() );

        return userEntity;
    }

    @Override
    public User toDomain(CreateUserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUsername( dto.getUsername() );
        user.setPassword( dto.getPassword() );
        user.setName( dto.getName() );
        user.setEmail( dto.getEmail() );

        return user;
    }
}
