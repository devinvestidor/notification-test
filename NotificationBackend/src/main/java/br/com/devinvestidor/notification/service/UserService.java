package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.User;

import java.util.List;

public interface UserService {
    List<User> listByCategory(Category category);
}
