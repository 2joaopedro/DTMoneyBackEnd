package com.example.dtmoney.repository

import com.example.dtmoney.model.Transaction
import org.springframework.data.jpa.repository.JpaRepository

interface TransactionRepository : JpaRepository<Transaction, Long>