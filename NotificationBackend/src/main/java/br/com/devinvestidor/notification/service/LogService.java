package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dto.LogDTO;
import br.com.devinvestidor.notification.entity.Log;

import java.util.List;

public interface LogService {
    void save(Log log);
    List<LogDTO> listAll();
}
