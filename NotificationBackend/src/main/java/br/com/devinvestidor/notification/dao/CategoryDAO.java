package br.com.devinvestidor.notification.dao;

import br.com.devinvestidor.notification.entity.Category;

import java.util.List;

public interface CategoryDAO {
    List<Category> listAll();
}