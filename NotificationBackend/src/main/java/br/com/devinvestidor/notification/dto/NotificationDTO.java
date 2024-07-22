package br.com.devinvestidor.notification.dto;

import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationDTO {
    private Category category;
    private String message;
    private List<User> userList;

    public boolean hasNotCategory() {
        return !hasCategory();
    }
    private boolean hasCategory() {
        return category != null && category.getId() != null;
    }

    public boolean hasNotMessage() {
        return StringUtils.isBlank(message);
    }

    public NotificationDTO getEntityWithUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }
}
