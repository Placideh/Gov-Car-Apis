package com.placideh.govcar.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.placideh.govcar.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car,Integer> {
	Car findByPlateNo(String plateNo);
	List<Car> findAll();
	@Modifying
	@Transactional
	@Query("UPDATE Car SET plateNo=?1,institution=?2,manufacturedDate=?3,cost=?4 WHERE id=?5")
	void updateCar(String plateNo,String institution,LocalDate manufacturedDate,Long cost ,Integer id);
}
