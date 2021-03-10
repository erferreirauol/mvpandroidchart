package com.example.mpandroidchart.adapter

import com.example.mpandroidchart.model.Product

interface ProductItemListener {
    fun onClickedProduct(product: Product)
}