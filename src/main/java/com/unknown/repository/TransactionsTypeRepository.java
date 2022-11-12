package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.TransactionTypeEntity;

public interface TransactionsTypeRepository extends JpaRepository<TransactionTypeEntity, Integer> {

}
