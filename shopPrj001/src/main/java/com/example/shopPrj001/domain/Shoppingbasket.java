package com.example.shopPrj001.domain;

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
public class Shoppingbasket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long sbno;
	
	@NotNull
	private Long sbamount;
	@NotNull
	private Long sbprice;
	
	@ManyToOne
    @JoinColumn(name = "pno")
    private Product product;
	
	@ManyToOne
    @JoinColumn(name = "memid")
    private Member member;
}
