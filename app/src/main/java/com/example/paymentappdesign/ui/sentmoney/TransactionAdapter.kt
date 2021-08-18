package com.example.paymentappdesign.ui.sentmoney

import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.Transaction
import com.example.paymentappdesign.data.TransactionDue
import com.example.paymentappdesign.databinding.ItemTransactionBinding
import com.example.paymentappdesign.databinding.ItemTransactionDueTimeBinding
import com.example.paymentappdesign.ui.base.BaseDataBindingAdapter

class TransactionAdapter : BaseDataBindingAdapter<Transaction,ItemTransactionBinding>() {

    override val layoutId: Int
        get() = R.layout.item_transaction

    override fun onBindViewHolder(
        item: Transaction,
        itemBinding: ItemTransactionBinding
    ) {
        itemBinding.transaction = item
    }

}