package com.example.paymentappdesign.ui.sendmoney

import androidx.core.content.ContextCompat
import androidx.core.content.contentValuesOf
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.CreditCard
import com.example.paymentappdesign.databinding.ItemSelectCreditCardBinding
import com.example.paymentappdesign.ui.base.BaseDataBindingAdapter

class CreditCardSelectionAdapter :
    BaseDataBindingAdapter<CreditCard, ItemSelectCreditCardBinding>() {
    override val layoutId: Int
        get() = R.layout.item_select_credit_card

    override fun onBindViewHolder(item: CreditCard, itemBinding: ItemSelectCreditCardBinding) {
        with(itemBinding) {
            tvCardBalance.text = item.cardBalance
            tvCardNumber.text = item.cardNumber

            if (item.isSelected) {
                cvCreditCard.setCardBackgroundColor(
                    ContextCompat.getColorStateList(
                        itemBinding.root.context,
                        R.color.color_background_purple
                    )
                )
                tvCardNumber.setTextColor(
                    ContextCompat.getColorStateList(
                        itemBinding.root.context,
                        R.color.color_text_white
                    )
                )

                tvCardBalance.setTextColor(
                    ContextCompat.getColorStateList(
                        itemBinding.root.context,
                        R.color.color_text_white
                    )
                )
            }
        }
    }
}