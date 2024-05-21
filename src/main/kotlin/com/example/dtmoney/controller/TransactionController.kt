package com.example.dtmoney.controller

import com.example.dtmoney.model.Transaction
import com.example.dtmoney.service.TransactionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class TransactionController(private val transactionService: TransactionService) {

    @GetMapping("/transaction")
    fun getAllTransaction(): List<Transaction> {
        return transactionService.getAllTransaction()
    }

    @GetMapping("/transaction/{id}")
    fun getTransactionById(@PathVariable("id") transactionId: Long): Transaction {
        return transactionService.getTransactionById(transactionId)
    }

    @PostMapping("/transaction")
    fun createTransaction(@RequestBody payload: Transaction): Transaction {
        return  transactionService.createTransaction(payload)
    }

    @PutMapping("/transaction/{id}")
    fun updateTransactionById(@PathVariable("id") transactionId: Long, @RequestBody payload: Transaction): Transaction {
        return transactionService.updateTransactionById(transactionId, payload)
    }

    @DeleteMapping("/transaction/{id}")
    fun deleteTransactionById(@PathVariable("id") transactionId: Long): Unit {
        transactionService.deleteTransactionById(transactionId)
    }
}