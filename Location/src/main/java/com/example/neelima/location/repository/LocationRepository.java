package com.example.neelima.location.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.neelima.location.entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
