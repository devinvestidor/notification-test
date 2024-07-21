package br.com.devinvestidor.notification.dao;

import br.com.devinvestidor.notification.entity.Log;

import java.util.List;

public interface LogDAO {
    void save(Log log);
    List<Log> listAll();
}
