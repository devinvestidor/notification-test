package br.com.devinvestidor.notification.dao;

import br.com.devinvestidor.notification.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl extends AbstractDAO<Category> implements CategoryDAO {
    @Override
    public List<Category> listAll() {
        return super.listAll();
    }
}
