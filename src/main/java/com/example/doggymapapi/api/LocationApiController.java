package com.example.doggymapapi.api;

import com.example.doggymapapi.models.Location;
import com.example.doggymapapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationApiController {

    private final LocationService locationService;

    @Autowired
    public LocationApiController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getAllLocations() {
        return locationService.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return locationService.saveLocation(location);
    }


    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable Long id) {
        return locationService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long id, @RequestBody Location updatedLocation) {
        // Проверка существования пользователя с заданным id
        Location existingLocation = locationService.findById(id);
        if (existingLocation == null) {
            return ResponseEntity.notFound().build();
        }

        // Обновление полей пользователя
        existingLocation.setName(updatedLocation.getName());
        existingLocation.setCityName(updatedLocation.getCityName());
        existingLocation.setXCoordinate(updatedLocation.getXCoordinate());
        existingLocation.setYCoordinate(updatedLocation.getYCoordinate());
        existingLocation.setDescription(updatedLocation.getDescription());
        existingLocation.setLink(updatedLocation.getLink());

        // Сохранение обновленного пользователя
        Location updatedLocationData = locationService.saveLocation(existingLocation);
        return ResponseEntity.ok(updatedLocationData);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
    }
}