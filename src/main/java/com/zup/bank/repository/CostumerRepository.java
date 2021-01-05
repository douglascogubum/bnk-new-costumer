package com.zup.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zup.bank.model.Costumer;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer, Long> {
}