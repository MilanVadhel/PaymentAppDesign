package com.example.paymentappdesign.ui.sentmoney

import androidx.core.content.ContextCompat
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.CreditCard
import com.example.paymentappdesign.databinding.ItemCreditcardBinding
import com.example.paymentappdesign.ui.base.BaseDataBindingAdapter

class CreditCardAdapter : BaseDataBindingAdapter<CreditCard, ItemCreditcardBinding>() {

    override val layoutId: Int
        get() = R.layout.item_creditcard

    override fun onBindViewHolder(item: CreditCard, itemBinding: ItemCreditcardBinding) {
        with(item) {
            itemBinding.creditcard = item
            itemBinding.clCard.background =
                ContextCompat.getDrawable(itemBinding.root.context, item.cardBackground)
        }
    }
}