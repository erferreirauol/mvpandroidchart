package com.example.mpandroidchart.model

import android.graphics.Color

data class Product(
    var label: String = "",
    var percentage: Float = 0f,
    var value: String = "",
    var catalog: String = "",
    var color: String = ""
) {
    val listOfProducts: ArrayList<Product>
        get() {
            return arrayListOf(
                Product(
                    label = "Renda Fixa",
                    percentage = 10.0f,
                    value = "R$ 10.000,00",
                    catalog = "FIXED_INCOME",
                    color = "#32649C"
                ),
                Product(
                    label = "Fundos",
                    percentage = 30.0f,
                    value = "R$ 30.000,00",
                    catalog = "FUNDS",
                    color = "#00B99B"
                ),
                Product(
                    label = "Renda variável",
                    percentage = 60.0f,
                    value = "R$ 60.000,00",
                    catalog = "STOCK",
                    color = "#AFC84F"
                )
            )
        }

    val colors: List<Int>
        get() {
            val colorsHex: List<String> = listOfProducts.map { it.color }
            val colorsInt = arrayListOf<Int>()
            colorsHex.forEach {
                colorsInt.add(Color.parseColor(it))
            }
            return colorsInt
        }
}
