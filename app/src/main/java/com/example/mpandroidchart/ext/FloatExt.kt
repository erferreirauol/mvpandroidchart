package com.example.mpandroidchart.ext

import java.text.NumberFormat
import java.util.*

fun Float.toMoneyText(): String {
    val format: NumberFormat = NumberFormat.getCurrencyInstance(Locale.getDefault())
    format.currency = Currency.getInstance("BRL")
    return format.format(this)
}