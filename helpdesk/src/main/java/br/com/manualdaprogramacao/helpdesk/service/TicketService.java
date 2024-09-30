package br.com.manualdaprogramacao.helpdesk.service;

import br.com.manualdaprogramacao.helpdesk.domain.Attachment;
import br.com.manualdaprogramacao.helpdesk.domain.Ticket;
import br.com.manualdaprogramacao.helpdesk.domain.TicketInteraction;
import br.com.manualdaprogramacao.helpdesk.entity.TicketAttachmentEntity;
import br.com.manualdaprogramacao.helpdesk.entity.TicketEntity;
import br.com.manualdaprogramacao.helpdesk.entity.TicketInteractionEntity;
import br.com.manualdaprogramacao.helpdesk.entity.UserEntity;
import br.com.manualdaprogramacao.helpdesk.enums.TicketStatus;
import br.com.manualdaprogramacao.helpdesk.exception.BusinessException;
import br.com.manualdaprogramacao.helpdesk.exception.ObjectNotFoundException;
import br.com.manualdaprogramacao.helpdesk.mapper.TicketMapper;
import br.com.manualdaprogramacao.helpdesk.repository.TicketAttachmentRepository;
import br.com.manualdaprogramacao.helpdesk.repository.TicketInteractionRepository;
import br.com.manualdaprogramacao.helpdesk.repository.TicketRepository;
import br.com.manualdaprogramacao.helpdesk.repository.UserRepository;
import br.com.manualdaprogramacao.helpdesk.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TicketService {

    private final TicketRepository ticketRepository;

    private final TicketInteractionRepository ticketInteractionRepository;

    private final TicketAttachmentRepository ticketAttachmentRepository;

    private final UserRepository userRepository;

    private final TicketMapper mapper;

    @Value("${helpdesk.attachments-folder}")
    private String attachmentsFolder;

    @Transactional
    public Ticket createTicket(Ticket newTicket) {

        TicketEntity entity = mapper.toEntity(newTicket);
        Optional<UserEntity> createdByUser = userRepository.findById(newTicket.getCreatedByUserId());
        if (createdByUser.isEmpty()) {
            throw new ObjectNotFoundException("User not found whit provided id");
        }
        entity.setCreatedBy(createdByUser.get());
        entity.setStatus(TicketStatus.OPEN);
        entity.setCreateAt(new Date());
        entity = ticketRepository.save(entity);

        if (newTicket.getAttachments() != null && !newTicket.getAttachments().isEmpty()){
            for(Attachment attachment : newTicket.getAttachments()) {
                TicketAttachmentEntity ticketAttachmentEntity = new TicketAttachmentEntity();
                ticketAttachmentEntity.setTicket(entity);
                ticketAttachmentEntity.setCreatedBy(createdByUser.get());
                ticketAttachmentEntity.setCreateAt(new Date());
                ticketAttachmentEntity.setFilename(attachment.getFilename());
                ticketAttachmentEntity = ticketAttachmentRepository.save(ticketAttachmentEntity);

                byte[] attachmentContent = null;
                try{
                    attachmentContent = FileUtils.convertBase64ToByteArray(attachment.getContent());
                    String fileName = ticketAttachmentEntity.getId() + "." + FileUtils.extractFileExtensionFromBase64String(attachment.getContent());

                    FileUtils.saveByteArrayToFile(attachmentContent, new File(attachmentsFolder + fileName));
                } catch (IOException ex) {
                    throw new BusinessException("Error saving" + attachment.getFilename() + " file");
                }
            }
        }

        return mapper.toDomain(entity);
    }

        public Ticket ticketInteract(TicketInteraction domain) {
            TicketEntity ticket = ticketRepository.findById(domain.getTicketId()).orElse(null);

            if (ticket == null) {
                throw new BusinessException("Ticket not found with provided id");
            }

            UserEntity user = userRepository.findById(domain.getUserId()).orElse(null);

            if (user == null) {
                throw new BusinessException("Ticket not found with provided id");
            }

            Date now = new Date();

            TicketStatus status = TicketStatus.IN_PROGRESS;
            if (ticket.getCreatedBy().getId() != user.getId()){
                ticket.setSupportUser(user);
                status = TicketStatus.AWAITING_CUSTOMER_ANSWER;
            }

            TicketInteractionEntity entity = new TicketInteractionEntity();
            entity.setTicket(ticket);
            entity.setMessage(domain.getMessage());
            entity.setCreatedBy(user);
            entity.setSentByUser(user);
            entity.setCreateAt(now);
            entity.setStatus(status);
            ticketInteractionRepository.save(entity);


            ticket.setUpdateAt(now);
            ticket.setUpdateBy(user.getId());
            ticket.setStatus(status);
            ticket = ticketRepository.save(ticket);
            return mapper.toDomain(ticket);
    }
}






















