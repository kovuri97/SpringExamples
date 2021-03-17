package com.example.neelima.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.neelima.location.entities.Location;
import com.example.neelima.location.repository.LocationRepository;
@Service
public class LocationServiceImpl implements LocationService{
	@Autowired
	private LocationRepository  repository;

	@Override
	public Location saveLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public Location updateLocation(Location location) {
		return repository.save(location);
	}

	@Override
	public void deleteLocation(Location location) {
		repository.delete(location);
		
	}

	@Override
	public Location getLocationById(int id) {
		// TODO Auto-generated method stub
		Optional<Location> response = repository.findById(id);
		return response.get();
	}

	@Override
	public List<Location> getAllLocations() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
