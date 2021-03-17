package com.example.neelima.location.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.neelima.location.entities.Location;
import com.example.neelima.location.service.LocationService;

@Controller
public class LocationController {
	@Autowired
	LocationService service;
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "CreateLocation";//jsp class name
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location")Location location,ModelMap modelmap) {
		//ModeAttribute for map request and model map for map response
		Location saveLocation1 = service.saveLocation(location);
		String message = "Location saved with id  "+ saveLocation1.getId();
		modelmap.addAttribute("msg", message);
		//need to add msg key in jsp file
		return "CreateLocation";//jsp class name
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap modelmap) {
		//ModeAttribute for map request and model map for map response
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("location", locations);
		return "displayLocation";//jsp class name
	}
	
	@RequestMapping("deleteLocation")
	public String deletLocation(@RequestParam("id") int id, ModelMap modelmap) {
		//ModeAttribute for map request and model map for map response
		Location location = service.getLocationById(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("location", locations);
		return "displayLocation";//jsp class name
	}

	@RequestMapping("/showUpdate")
	public String showupdate(@RequestParam("id") int id, ModelMap modelmap) {
		//ModeAttribute for map request and model map for map response
		Location location = service.getLocationById(id);
		modelmap.addAttribute("location", location);
		return "editLocation";//jsp class name
	}
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location")Location location,ModelMap modelmap) {
		Location saveLocation1 = service.updateLocation(location);
		List<Location> locations = service.getAllLocations();
		modelmap.addAttribute("location", locations);
		//need to add msg key in jsp file
		return "displayLocation";//jsp class name
	}
}
