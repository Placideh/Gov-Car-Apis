package com.placideh.govcar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.placideh.govcar.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
	Car findByPlateNo(String plateNo);
	List<Car> findAll();
}
