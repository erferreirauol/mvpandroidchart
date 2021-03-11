package com.example.mpandroidchart.adapter

import android.graphics.Color
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.mpandroidchart.databinding.ItemInvestmentBinding
import com.example.mpandroidchart.model.ProductInfo

class InvestmentItemAdapter(
) : RecyclerView.Adapter<InvestmentViewHolder>() {

    private val productList = ArrayList<ProductInfo>()
    private var itemColor: String? = null

    fun setItems(items: ArrayList<ProductInfo>, color: String) {
        this.productList.clear()
        this.productList.addAll(items)
        itemColor = color
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InvestmentViewHolder {
        val binding: ItemInvestmentBinding = ItemInvestmentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return InvestmentViewHolder(binding)
    }

    override fun getItemCount(): Int = productList.size

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: InvestmentViewHolder, position: Int) =
        holder.bind(productList[position], itemColor)
}

class InvestmentViewHolder(
    private val itemBinding: ItemInvestmentBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun bind(item: ProductInfo, itemColor: String?) = with(itemBinding) {
        itemInvestmentTvTitle.text = item.title
        itemInvestmentTvDescription.text = item.subtitle
        grossValueLabel.text = item.grossValue.label
        grossValueValue.text = item.grossValue.value
        item.details.first().let {
            rentabilityLabel.text = it.label
            rentabilityValue.text = it.value
        }
        fgcIcon.isVisible = item.hasFgc
        footerButton.text = item.button.text
        footerButton.isEnabled = item.button.enabled
        starterView.setBackgroundColor(Color.parseColor(itemColor ?: "#000000"))
    }

}