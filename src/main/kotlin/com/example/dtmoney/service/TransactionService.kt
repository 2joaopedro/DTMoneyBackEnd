package com.example.dtmoney.service

import com.example.dtmoney.model.Transaction
import com.example.dtmoney.repository.TransactionRepository
import org.springframework.stereotype.Service

@Service
class TransactionService(private val  transactionRepository: TransactionRepository) {

    fun getAllTransaction(): List<Transaction> {
        return transactionRepository.findAll();
    }

    fun getTransactionById(transactionId: Long): Transaction {
        return transactionRepository.getById(transactionId);
    }

    fun createTransaction(transaction: Transaction): Transaction {
        return transactionRepository.save(transaction);
    }

    fun updateTransactionById(transactionId: Long, transaction: Transaction): Transaction {
        if (transactionRepository.existsById(transactionId)) {
            return transactionRepository.save(transaction.copy(id = transactionId))
        } else {
            throw TransactionNotFoundException("Essa Transação não existe")
        }
    }


    fun deleteTransactionById(transactionId: Long) {
        if (transactionRepository.existsById(transactionId)) {
            return transactionRepository.deleteById(transactionId)
        } else {
            throw TransactionNotFoundException("Essa Transação não existe")
        }
    }
}

class TransactionNotFoundException(message: String) : Throwable(message)