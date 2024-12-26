package com.devsuperior.dsmeta.dto;

import java.time.LocalDate;

import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.entities.Seller;

public class SaleMinDTO {

	private Long id;
	private Double amount;
	private LocalDate date;
	private String sellerName;

	public SaleMinDTO(Long id, Double amount, LocalDate date, Seller seller) {
		this.id = id;
		this.amount = amount;
		this.date = date;
		this.sellerName = seller.getName();
	}

	public SaleMinDTO(Sale entity) {
		id = entity.getId();
		amount = entity.getAmount();
		date = entity.getDate();
		sellerName = entity.getSeller().getName();
	}

	public Long getId() {
		return id;
	}

	public Double getAmount() {
		return amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public String getSellerName() {
		return sellerName;
	}

}
