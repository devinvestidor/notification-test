package br.com.devinvestidor.notification.dao;

import br.com.devinvestidor.notification.entity.Log;
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
        return super.findAll();
    }
}
