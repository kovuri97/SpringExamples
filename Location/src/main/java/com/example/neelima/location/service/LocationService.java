package com.example.neelima.location.service;

import java.util.List;

import com.example.neelima.location.entities.Location;

public interface LocationService {

	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	List<Location> getAllLocations();
	Location getLocationById(int id);
}
