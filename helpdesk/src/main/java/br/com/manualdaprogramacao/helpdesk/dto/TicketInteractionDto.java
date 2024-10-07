package br.com.manualdaprogramacao.helpdesk.dto;

;
import br.com.manualdaprogramacao.helpdesk.enums.TicketStatus;
import lombok.Data;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
public class TicketInteractionDto {



    private String message;

    private TicketStatus status;

    private UUID userId;

    private UUID ticketId;

    private UUID id;

    private TicketDto ticket;

    private List<AttachmentDto> attachments;

    private UserDto sentByUser;

    private UserDto createdBy;

    private Date createAt;

    private UUID updatedBy;

    private Date updatedAt;


}























