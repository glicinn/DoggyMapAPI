package com.example.doggymapapi.api;

import com.example.doggymapapi.models.Logs;
import com.example.doggymapapi.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/logs")
public class LogsApiController {

    private final LogsService logsService;

    @Autowired
    public LogsApiController(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping
    public List<Logs> getAllLogs() {
        return logsService.findAll();
    }

    @PostMapping
    public Logs createLogs(@RequestBody Logs logs) {
        return logsService.saveLogs(logs);
    }


    @GetMapping("/{id}")
    public Logs getLogsById(@PathVariable Long id) {
        return logsService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Logs> updateLogs(@PathVariable Long id, @RequestBody Logs updatedLogs) {
        // Проверка существования новости с заданным id
        Logs existingLogs = logsService.findById(id);
        if (existingLogs == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей новости
        existingLogs.setLogTableName(updatedLogs.getLogTableName());
        existingLogs.setLogView(updatedLogs.getLogView());
        existingLogs.setLogInformation(updatedLogs.getLogInformation());

        // Сохранение обновленной новости
        Logs updatedLogsData = logsService.saveLogs(existingLogs);
        return ResponseEntity.ok(updatedLogsData);
    }

    @DeleteMapping("/{id}")
    public void deleteLogs(@PathVariable Long id) {
        logsService .deleteById(id);
    }
}