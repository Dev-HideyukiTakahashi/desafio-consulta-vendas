package com.devsuperior.dsmeta.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.dto.SellerMinDTO;
import com.devsuperior.dsmeta.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

  @Query("SELECT new com.devsuperior.dsmeta.dto.SaleMinDTO(obj) "
      + "FROM Sale obj JOIN obj.seller s "
      + "WHERE obj.date BETWEEN :initialDate AND :finalDate AND UPPER(s.name) LIKE UPPER(CONCAT('%', :name, '%'))")
  Page<SaleMinDTO> reportByDatesAndName(LocalDate initialDate, LocalDate finalDate, String name, Pageable pageable);

  @Query("SELECT new com.devsuperior.dsmeta.dto.SellerMinDTO(s.name, SUM(obj.amount)) "
      + "FROM Sale obj JOIN obj.seller s "
      + "WHERE obj.date BETWEEN :initialDate AND :finalDate "
      + "GROUP BY s.name")
  List<SellerMinDTO> summaryByDates(LocalDate initialDate, LocalDate finalDate);
}
