package com.example.paymentappdesign.ui.settings

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.paymentappdesign.R
import com.example.paymentappdesign.data.Settings
import com.example.paymentappdesign.databinding.ItemSettingBinding
import com.example.paymentappdesign.ui.base.BaseDataBindingAdapter

class SettingsAdapter : BaseDataBindingAdapter<Settings, ItemSettingBinding>() {

    override val layoutId: Int
        get() = R.layout.item_setting

    override fun onBindViewHolder(item: Settings, itemBinding: ItemSettingBinding) {
        itemBinding.tvSettingName.setText(item.settingName)
        Glide.with(itemBinding.root.context)
            .load(item.settingImage)
            .placeholder(R.drawable.placeholder)
            .into(itemBinding.ivSetting)
    }
}