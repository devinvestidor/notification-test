package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dao.CategoryDAO;
import br.com.devinvestidor.notification.dao.LogDAO;
import br.com.devinvestidor.notification.dto.LogDTO;
import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public List<Category> listAll() {
        return categoryDAO.listAll();
    }
}
