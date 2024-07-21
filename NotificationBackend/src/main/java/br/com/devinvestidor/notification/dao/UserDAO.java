package br.com.devinvestidor.notification.dao;


import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.User;

import java.util.List;

public interface UserDAO {
    List<User> listByCategory(Category category);
}
