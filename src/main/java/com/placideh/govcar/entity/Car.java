package com.placideh.govcar.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gov_car_table")
public class Car {
@SequenceGenerator(
		 name="car_sequence",
		 sequenceName = "car_sequence",
		 allocationSize = 1
		)	
@GeneratedValue(
		strategy = GenerationType.AUTO,
		  generator = "car_sequence"
		)
@Id
private Integer id;
 private String plateNo;
 private String institution;
 private LocalDate manufacturedDate;
 private Long cost;
}
