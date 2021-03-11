package com.example.mpandroidchart.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColorInt
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mpandroidchart.model.Constants.FIXED_INCOME
import com.example.mpandroidchart.R
import com.example.mpandroidchart.adapter.InvestmentItemAdapter
import com.example.mpandroidchart.databinding.ActivitySecondScreenBinding
import com.example.mpandroidchart.datasource.CatalogResponse
import com.example.mpandroidchart.model.Catalog
import com.example.mpandroidchart.model.CatalogInfo
import com.example.mpandroidchart.model.ProductInfo
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlin.math.roundToInt

class SecondScreenActivity : AppCompatActivity() {

    private val adapter by lazy { InvestmentItemAdapter() }
    private lateinit var binding: ActivitySecondScreenBinding
    private val catalogResponse = CatalogResponse.catalogInfo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupScreen()
        setupPieChart()
        setupProductList()
    }

    private fun setupScreen() {
        binding.secondScreenTvTitle.text = catalogResponse.catalog.title
        binding.secondScreenFirstHeaderLabelTv.text =
            catalogResponse.catalog.investedValue.labelValue.label
        binding.secondScreenFirstHeaderValuelTv.text =
            catalogResponse.catalog.investedValue.labelValue.value
        binding.secondScreenSecondHeaderLabelTv.text = catalogResponse.catalog.netIncome.label
        binding.secondScreenSecondHeadeValuelTv.text = catalogResponse.catalog.netIncome.value
        binding.secondScreenProductsTv.text =
            String.format("%s(%d)", catalogResponse.wallet.title, catalogResponse.wallet.quantity)
    }

    private fun setupPieChart() {
        setupPieChartConfigs()
    }

    private fun setupPieChartConfigs() {
        binding.pieChartSecondGraphic.apply {
            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            setDrawEntryLabels(false)
            holeRadius = 85f
            setCenterTextSize(24F)
            description.isEnabled = false
            legend.isEnabled = false
            setTouchEnabled(false)
            setEntry(
                catalogResponse.catalog.percentage,
                Color.parseColor(catalogResponse.catalog.color)
            )
        }
    }

    private fun setupProductList() {
        adapter.setItems(
            catalogResponse.wallet.products as ArrayList<ProductInfo>,
            catalogResponse.catalog.color
        )
        binding.productsRv.layoutManager = LinearLayoutManager(this)
        binding.productsRv.adapter = adapter
    }


    companion object {
        private const val ARG_CATALOG_TYPE = "CATALOG_TYPE"

        fun newInstance(context: Context, catalogType: String) {
            val intent = Intent(context, SecondScreenActivity::class.java).apply {
                putExtra(ARG_CATALOG_TYPE, catalogType)
            }
            context.startActivity(intent)
        }
    }
}
