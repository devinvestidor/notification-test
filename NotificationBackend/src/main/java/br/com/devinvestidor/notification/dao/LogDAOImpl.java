package br.com.devinvestidor.notification.dao;

import br.com.devinvestidor.notification.entity.Log;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LogDAOImpl extends AbstractDAO<Log> implements LogDAO {

    @Override
    public void save(Log log) {
        persist(log);
    }

    @Override
    public List<Log> listAll() {
        StringBuilder hql = new StringBuilder();
        hql.append(" SELECT l");
        hql.append(" FROM Log l");
        hql.append(" ORDER BY l.dateSent DESC");

        TypedQuery<Log> query = entityManager.createQuery(hql.toString(), Log.class);
        return query.getResultList();
    }
}
