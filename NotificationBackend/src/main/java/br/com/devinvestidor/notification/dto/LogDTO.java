package br.com.devinvestidor.notification.dto;

import br.com.devinvestidor.notification.entity.Log;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LogDTO {
    private Date dateSent;
    private String descCategory;
    private String descChannel;
    private String nameUser;
    private String descStatus;

    public LogDTO convertToDTO(Log log) {
        setDateSent(log.getDateSent());
        setDescCategory(log.getCategory().getDescription());
        setDescChannel(log.getChannel().getDescription());
        setNameUser(log.getUser().getName());
        setDescStatus(log.getStatusNotification().getDescription());

        return this;
    }
}

