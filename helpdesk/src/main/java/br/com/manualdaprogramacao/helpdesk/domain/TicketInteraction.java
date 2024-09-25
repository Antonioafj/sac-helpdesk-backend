package br.com.manualdaprogramacao.helpdesk.domain;


import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class TicketInteraction {

    private String message;

    private UUID userId;

    private UUID ticketId;

    private UUID id;

    private TicketEntity ticket;

    private UserEntity sentByUser;

    private UserEntity createdBy;

    private Date createAt;

    private UUID updateBy;

    private Date updateAt;
}























