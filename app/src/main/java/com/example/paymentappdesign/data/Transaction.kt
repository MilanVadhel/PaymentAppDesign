package com.example.paymentappdesign.data

data class TransactionDue(
    val transactionTime: String,
    val transactionList: ArrayList<Transaction>
)

data class Transaction(
    val profileImage: String,
    val userName: String,
    val transactionDate: String,
    val transactionAmount: String
)
