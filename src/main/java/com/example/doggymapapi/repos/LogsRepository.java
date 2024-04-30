package com.example.doggymapapi.repos;

import com.example.doggymapapi.models.Logs;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LogsRepository extends JpaRepository<Logs,Long> {
//    Logs findByID(Long id);
}
