package com.example.doggymapapi.services;

import com.example.doggymapapi.models.Logs;
import com.example.doggymapapi.repos.LogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogsService {
    private final LogsRepository logsRepository;

    @Autowired
    public LogsService(LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    public Logs findById(Long id) {
        return logsRepository.findById(id).orElse(null);
    }

    public List<Logs> findAll() {
        return logsRepository.findAll();
    }

    public Logs saveLogs(Logs logs) {
        return logsRepository.save(logs);
    }

    public void deleteById(Long id) {
        logsRepository.deleteById(id);
    }
}
