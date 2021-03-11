package com.example.mpandroidchart.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.mpandroidchart.databinding.ItemProductBinding
import com.example.mpandroidchart.ext.setDrawableColor
import com.example.mpandroidchart.model.Product

class ListProductsAdapter(
    private val listener: ProductItemListener
) : RecyclerView.Adapter<InvestmentViewHolder>() {

    private val productsList = ArrayList<Product>()
    private var catalogProduct: String? = null

    fun setItems(items: ArrayList<Product>) {
        this.productsList.clear()
        this.productsList.addAll(items)
        notifyDataSetChanged()
    }

    fun setCatalogProductSelected(catalog: String? = null) {
        this.catalogProduct = catalog
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestmentViewHolder {
        val binding: ItemProductBinding = ItemProductBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return InvestmentViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = productsList.size

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: InvestmentViewHolder, position: Int) =
        holder.bind(productsList[position], catalogProduct)
}

class InvestmentViewHolder(
    private val itemBinding: ItemProductBinding,
    private val listener: ProductItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var product: Product

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun bind(item: Product, catalog: String?) = with(itemBinding) {
        product = item
        focusItemListByProductSelected(item, catalog)
        appCompatImageViewCircleId.setDrawableColor(item.color)
        appCompatTextViewTitleProduct.text = item.label
        appCompatImageViewValueProduct.text = item.value
    }

    private fun focusItemListByProductSelected(item: Product, catalog: String?) {
        if (catalog == null) {
            toFocusItemList()
        } else {
            if (catalog == item.catalog) {
                toFocusItemList()
            } else {
                deFocusItemList()
            }
        }
    }

    private fun toFocusItemList() = with(itemBinding) {
        appCompatImageViewCircleId.alpha = 1f
        appCompatTextViewTitleProduct.alpha = 1f
        appCompatImageViewValueProduct.alpha = 1f
    }

    private fun deFocusItemList() = with(itemBinding) {
        appCompatImageViewCircleId.alpha = 0.5f
        appCompatTextViewTitleProduct.alpha = 0.5f
        appCompatImageViewValueProduct.alpha = 0.5f
    }

    override fun onClick(v: View?) {
        listener.onClickedProduct(product)
    }
}