package com.example.doggymapapi.controllers;

import com.example.doggymapapi.models.Location;
import com.example.doggymapapi.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("location-list")
    public String findAll(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "location-list";
    }

    @GetMapping("Map")
    public String findAllForMap(Model model) {
        List<Location> locations = locationService.findAll();
        model.addAttribute("locations", locations);
        return "site/Map";
    }

    @GetMapping("/create")
    public String createLocationForm(Location location) {
        return "location-create";
    }

    @PostMapping("/create")
    public String createLocation(Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/update/{id}")
    public String updateLocationForm(@PathVariable Long id, Model model) {
        Location location = locationService.findById(id);
        model.addAttribute("location", location);
        return "location-update";
    }

    @PostMapping("/update")
    public String updateLocation(Location location) {
        locationService.saveLocation(location);
        return "redirect:/locations";
    }

    @GetMapping("/delete/{id}")
    public String deleteLocation(@PathVariable Long id) {
        locationService.deleteById(id);
        return "redirect:/locations";
    }
}
