package br.com.manualdaprogramacao.helpdesk.mapper;

import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.domain.TicketInteraction;
import br.com.manualdaprogramacao.helpdesk.domain.User;
import br.com.manualdaprogramacao.helpdesk.dto.CreateTicketDto;
import br.com.manualdaprogramacao.helpdesk.dto.CreateTicketInteractionDto;
import br.com.manualdaprogramacao.helpdesk.dto.TicketDto;
import br.com.manualdaprogramacao.helpdesk.dto.UserDto;
import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-25T18:15:50-0400",
    comments = "version: 1.6.0, compiler: javac, environment: Java 17.0.11 (Oracle Corporation)"
)
@Component
public class TicketMapperImpl implements TicketMapper {

    @Override
    public Ticket toDomain(TicketEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setId( entity.getId() );
        ticket.setSupportUser( userEntityToUser( entity.getSupportUser() ) );
        ticket.setSubject( entity.getSubject() );
        ticket.setDescription( entity.getDescription() );
        ticket.setStatus( entity.getStatus() );
        ticket.setCreatedBy( entity.getCreatedBy() );
        ticket.setCreateAt( entity.getCreateAt() );
        ticket.setUpdateBy( entity.getUpdateBy() );
        ticket.setUpdateAt( entity.getUpdateAt() );

        return ticket;
    }

    @Override
    public TicketDto toDto(Ticket domain) {
        if ( domain == null ) {
            return null;
        }

        TicketDto ticketDto = new TicketDto();

        ticketDto.setId( domain.getId() );
        ticketDto.setSupportUser( userToUserDto( domain.getSupportUser() ) );
        ticketDto.setSubject( domain.getSubject() );
        ticketDto.setDescription( domain.getDescription() );
        ticketDto.setStatus( domain.getStatus() );
        ticketDto.setCreatedBy( userEntityToUserDto( domain.getCreatedBy() ) );
        ticketDto.setCreateAt( domain.getCreateAt() );
        ticketDto.setUpdateBy( domain.getUpdateBy() );
        ticketDto.setUpdateAt( domain.getUpdateAt() );

        return ticketDto;
    }

    @Override
    public TicketEntity toEntity(Ticket domain) {
        if ( domain == null ) {
            return null;
        }

        TicketEntity ticketEntity = new TicketEntity();

        ticketEntity.setId( domain.getId() );
        ticketEntity.setSupportUser( userToUserEntity( domain.getSupportUser() ) );
        ticketEntity.setSubject( domain.getSubject() );
        ticketEntity.setDescription( domain.getDescription() );
        ticketEntity.setStatus( domain.getStatus() );
        ticketEntity.setCreatedBy( domain.getCreatedBy() );
        ticketEntity.setCreateAt( domain.getCreateAt() );
        ticketEntity.setUpdateBy( domain.getUpdateBy() );
        ticketEntity.setUpdateAt( domain.getUpdateAt() );

        return ticketEntity;
    }

    @Override
    public Ticket toDomain(CreateTicketDto dto) {
        if ( dto == null ) {
            return null;
        }

        Ticket ticket = new Ticket();

        ticket.setSubject( dto.getSubject() );
        ticket.setDescription( dto.getDescription() );
        ticket.setCreatedByUserId( dto.getCreatedByUserId() );

        return ticket;
    }

    @Override
    public TicketInteraction toDomain(CreateTicketInteractionDto dto) {
        if ( dto == null ) {
            return null;
        }

        TicketInteraction ticketInteraction = new TicketInteraction();

        ticketInteraction.setMessage( dto.getMessage() );
        ticketInteraction.setUserId( dto.getUserId() );

        return ticketInteraction;
    }

    protected User userEntityToUser(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        User user = new User();

        user.setId( userEntity.getId() );
        user.setUsername( userEntity.getUsername() );
        user.setPassword( userEntity.getPassword() );
        user.setName( userEntity.getName() );
        user.setEmail( userEntity.getEmail() );
        user.setCreateAt( userEntity.getCreateAt() );

        return user;
    }

    protected UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( user.getId() );
        userDto.setUsername( user.getUsername() );
        userDto.setName( user.getName() );
        userDto.setEmail( user.getEmail() );
        userDto.setCreateAt( user.getCreateAt() );

        return userDto;
    }

    protected UserDto userEntityToUserDto(UserEntity userEntity) {
        if ( userEntity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( userEntity.getId() );
        userDto.setUsername( userEntity.getUsername() );
        userDto.setName( userEntity.getName() );
        userDto.setEmail( userEntity.getEmail() );
        userDto.setCreateAt( userEntity.getCreateAt() );

        return userDto;
    }

    protected UserEntity userToUserEntity(User user) {
        if ( user == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        userEntity.setId( user.getId() );
        userEntity.setUsername( user.getUsername() );
        userEntity.setPassword( user.getPassword() );
        userEntity.setName( user.getName() );
        userEntity.setEmail( user.getEmail() );
        userEntity.setCreateAt( user.getCreateAt() );

        return userEntity;
    }
}
