package com.example.paymentappdesign.ui.sendmoney

import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.Recipient
import com.example.paymentappdesign.databinding.ItemRecipientBinding
import com.example.paymentappdesign.ui.base.BaseDataBindingAdapter

class RecipientAdapter() : BaseDataBindingAdapter<Recipient, ItemRecipientBinding>() {

    override val layoutId: Int
        get() = R.layout.item_recipient

    override fun onBindViewHolder(item: Recipient, itemBinding: ItemRecipientBinding) {
        with(itemBinding) {
            tvUserName.text = item.userName
            Glide.with(itemBinding.root.context)
                .load(item.profileImage)
                .into(ivVisa)

            if (item.isSelected) {
                cvRecipient.setCardBackgroundColor(
                    ContextCompat.getColorStateList(
                        itemBinding.root.context,
                        R.color.color_background_purple
                    )
                )
                tvUserName.setTextColor(
                    ContextCompat.getColorStateList(
                        itemBinding.root.context,
                        R.color.color_text_white
                    )
                )
            }
        }
    }
}