package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dao.UserDAO;
import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> listByCategory(Category category) {
        return userDAO.listByCategory(category);
    }
}
