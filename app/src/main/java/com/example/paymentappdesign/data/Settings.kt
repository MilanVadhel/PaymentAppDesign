package com.example.paymentappdesign.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.paymentappdesign.R

enum class Settings(@DrawableRes val settingImage : Int, @StringRes val settingName : Int) {
    PROFILE_INFORMATION(R.drawable.ic_information,R.string.profile_information),
    PASSWORD(R.drawable.ic_password,R.string.password),
    EMAIL(R.drawable.ic_email,R.string.email),
    PHONE_NUMBER(R.drawable.ic_phone,R.string.phone_number),
    NOTIFICATIONS(R.drawable.ic_notifications,R.string.notifications),
    CURRENCY(R.drawable.ic_currency,R.string.currency),
    LANGUAGE(R.drawable.ic_language,R.string.language),
    ACCOUNT(R.drawable.ic_account,R.string.account),
    PRIVACY_POLICY(R.drawable.ic_privacy_policy,R.string.privacy_policy),
    TERMS_OF_USE(R.drawable.ic_terms_of_use,R.string.terms_of_use)
}