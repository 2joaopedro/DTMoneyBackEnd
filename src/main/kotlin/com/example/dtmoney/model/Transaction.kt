package com.example.dtmoney.model

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "\"transaction\"")
data class Transaction(
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    val id: Long,

    @Column(name = "descricao", nullable = false)
    val descricao: String,

    @Column(name = "preco", nullable = false)
        val preco : Double,

    @Column(name = "categoria", nullable = false)
    val categoria: String,

    @Column(name = "data", nullable = false)
    val data: LocalDate,

    @Column(name = "status", nullable = false)
    val status: String,
)
