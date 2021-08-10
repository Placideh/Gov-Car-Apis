package com.placideh.govcar.resource;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	@GetMapping("")
	public ResponseEntity<List<Car>>getAllRegisteredCar() {
		List<Car>cars=repository.findAll();
		return new ResponseEntity<>(cars,HttpStatus.OK);
	}
	@PutMapping("/update")
	public ResponseEntity<Map<String,String>> updateCar(@RequestBody Map<String,Object> car){
		String plateNo=(String)car.get("plateNo");
		Car carTobeUpdated=repository.findByPlateNo(plateNo);
		Map<String,String> map=new HashMap<>();
		if(carTobeUpdated!=null) {
			Integer id=carTobeUpdated.getId();
			String institution=(String)car.get("institution");
			LocalDate date=LocalDate.parse(car.get("manufacturedDate").toString());
			Long cost=Long.parseLong(car.get("cost").toString());
			repository.updateCar(plateNo, institution, date, cost, id);
			map.put("success","vehicle updated");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}else {
			map.put("failed","car not found");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping("/deleteplate/{plateNo}")
	public ResponseEntity<Map<String,String>> removeCar(@PathVariable("plateNo") String plateNo){
		Car carTobeUpdated=repository.findByPlateNo(plateNo);
		Map<String,String> map=new HashMap<>();
		if(carTobeUpdated!=null) {
			Integer id=carTobeUpdated.getId();
			repository.deleteById(id);
			map.put("success","vehicle removed");
			return new ResponseEntity<>(map,HttpStatus.OK);
		}else {
			map.put("failed","car not found");
			return new ResponseEntity<>(map,HttpStatus.NOT_FOUND);
		}
		
	}
	
}
