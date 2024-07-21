package br.com.devinvestidor.notification.dto;

import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
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

    public NotificationDTO getEntityWithUserList(List<User> userList) {
        this.userList = userList;
        return this;
    }
}
