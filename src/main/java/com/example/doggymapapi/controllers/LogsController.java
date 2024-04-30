package com.example.doggymapapi.controllers;

import com.example.doggymapapi.models.Logs;
import com.example.doggymapapi.services.LogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/logs")
public class LogsController {

    private final LogsService logsService;

    @Autowired
    public LogsController(LogsService logsService) {
        this.logsService = logsService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<Logs> logs = logsService.findAll();
        model.addAttribute("logs", logs);
        return "logs-list";
    }

    @GetMapping("/create")
    public String createLogsForm(Logs logs) {
        return "logs-create";
    }

    @PostMapping("/create")
    public String createLogs(Logs logs) {
        logsService.saveLogs(logs);
        return "redirect:/logs";
    }

    @GetMapping("/update/{id}")
    public String updateLogsForm(@PathVariable Long id, Model model) {
        Logs logs = logsService.findById(id);
        model.addAttribute("logs", logs);
        return "logs-update";
    }

    @PostMapping("/update")
    public String updateLogs(Logs logs) {
        logsService.saveLogs(logs);
        return "redirect:/logs";
    }

    @GetMapping("/delete/{id}")
    public String deleteLogs(@PathVariable Long id) {
        logsService.deleteById(id);
        return "redirect:/logs";
    }
}
