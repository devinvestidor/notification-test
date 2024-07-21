package br.com.devinvestidor.notification.service;

import br.com.devinvestidor.notification.dao.LogDAO;
import br.com.devinvestidor.notification.dto.LogDTO;
import br.com.devinvestidor.notification.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDAO logDAO;


    @Transactional
    @Override
    public void save(Log log) {
        logDAO.save(log);
    }

    @Override
    public List<LogDTO> listAll() {
        List<Log> listLog = logDAO.listAll();
        return listLog.stream().map(this::convertToDTO).collect(Collectors.toList());
    }
    private LogDTO convertToDTO(Log log) {
        return new LogDTO().convertToDTO(log);
    }

}
