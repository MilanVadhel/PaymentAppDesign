package com.example.paymentappdesign.data

import androidx.annotation.DrawableRes

data class CreditCard(
    val cardNumber: String,
    val cardHolderName : String = "",
    val cardExpiryDate : String = "",
    @DrawableRes val cardBackground : Int = 0,
    val cardBalance : String = "",
    val isSelected : Boolean = false
)
