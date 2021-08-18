package com.example.paymentappdesign.ui.sentmoney

import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.TransactionDue
import com.example.paymentappdesign.databinding.ItemTransactionDueTimeBinding
import com.example.paymentappdesign.ui.base.BaseDataBindingAdapter

class TransactionDueAdapter : BaseDataBindingAdapter<TransactionDue,ItemTransactionDueTimeBinding>() {

    private val transactionAdapter by lazy {
        TransactionAdapter()
    }

    override val layoutId: Int
        get() = R.layout.item_transaction_due_time

    override fun onBindViewHolder(
        item: TransactionDue,
        itemBinding: ItemTransactionDueTimeBinding
    ) {
        itemBinding.transactiondue = item
        itemBinding.rvTransaction.adapter = transactionAdapter
        transactionAdapter.setItems(item.transactionList,true)
    }

}