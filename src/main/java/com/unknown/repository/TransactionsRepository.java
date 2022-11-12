package com.unknown.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unknown.entity.TransactionEntity;

public interface TransactionsRepository extends JpaRepository<TransactionEntity, Integer> {
}
