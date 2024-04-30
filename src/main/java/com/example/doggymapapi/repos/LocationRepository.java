package com.example.doggymapapi.repos;

import com.example.doggymapapi.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LocationRepository extends JpaRepository<Location,Long> {
    Location findByName(String name);
}
