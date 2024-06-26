package com.example.shopPrj001.domain;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pno;
	@NotNull
	private String pname;
	@NotNull
	private String pprice;
	@NotNull
	private Long pamount;
	
	private String pintro;
	
	@ColumnDefault("0")
	private Long psalesRate;
}
