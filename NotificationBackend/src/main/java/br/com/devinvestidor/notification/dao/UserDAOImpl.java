package br.com.devinvestidor.notification.dao;

import br.com.devinvestidor.notification.entity.Category;
import br.com.devinvestidor.notification.entity.User;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl extends AbstractDAO<User> implements UserDAO {

    @Override
    public List<User> listByCategory(Category category) {
        StringBuilder hql = new StringBuilder();
        hql.append(" SELECT u");
        hql.append(" FROM User u");
        hql.append(" JOIN u.categoryList c");
        hql.append(" WHERE c = :category");

        TypedQuery<User> query = entityManager.createQuery(hql.toString(), User.class);
        query.setParameter("category", category);

        return query.getResultList();
    }
}
