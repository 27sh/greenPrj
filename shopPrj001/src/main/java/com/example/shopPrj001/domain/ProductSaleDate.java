package com.example.shopPrj001.domain;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class ProductSaleDate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long psdno;
	
	@NotNull
	private Date psaleDate;
	
	@ManyToOne
    @JoinColumn(name = "pno")
    private Product product;
}
