package br.com.manualdaprogramacao.helpdesk.domain;


import lombok.Data;

import java.util.UUID;

@Data
public class TicketInteraction {

    private String message;

    private UUID userId;

    private UUID ticketId;

}
