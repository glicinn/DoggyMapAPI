package com.example.doggymapapi.repos;

import com.example.doggymapapi.models.News;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewsRepository extends JpaRepository<News,Long> {
    News findByName(String name);
}
