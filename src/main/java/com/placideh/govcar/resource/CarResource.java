package com.placideh.govcar.resource;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placideh.govcar.entity.Car;
import com.placideh.govcar.repository.CarRepository;

@RestController
@RequestMapping("/govcar/cars")
public class CarResource {
	@Autowired
	private CarRepository repository;
	@PostMapping("/register")
	public ResponseEntity<Map<String,String>> registerCar(@RequestBody Car car){
		repository.save(car);
		Map<String ,String> map=new HashMap<>();
		map.put("success","car registered!");
		return new  ResponseEntity<>(map,HttpStatus.CREATED);
		
	}
	
}
