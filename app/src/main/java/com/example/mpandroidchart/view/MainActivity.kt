package com.example.mpandroidchart.view

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mpandroidchart.R
import com.example.mpandroidchart.adapter.ListProductsAdapter
import com.example.mpandroidchart.adapter.ProductItemListener
import com.example.mpandroidchart.databinding.ActivityMainBinding
import com.example.mpandroidchart.model.Constants.stringEmpty
import com.example.mpandroidchart.model.Constants.totalInvested
import com.example.mpandroidchart.model.Product
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), ProductItemListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listOfProducts: ArrayList<Product>

    private val adapter: ListProductsAdapter by lazy {
        ListProductsAdapter(this)
    }

    private val pieDataSet: List<PieEntry> by lazy {
        arrayListOf<PieEntry>().apply {
            listOfProducts.forEach {
                add(PieEntry(it.percentage, it.catalog))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListProducts()
        setupClickListener()
        setupPieChart()
        setupListProducts()
    }

    private fun initListProducts() {
        listOfProducts = Product().listOfProducts
        adapter.setItems(listOfProducts)
    }

    private fun setupClickListener() = with(binding) {
        pieChartMainGraphic.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                val entry = (e as PieEntry)
                binding.appCompatTextViewPercentValue.text = String.format(
                    getString(R.string.percent),
                    entry.value.roundToInt().toString()
                )
                adapter.setCatalogProductSelected(entry.label)
            }

            override fun onNothingSelected() {
                binding.appCompatTextViewPercentValue.text = ""
                adapter.setCatalogProductSelected()
            }
        })
    }

    private fun setupPieChart() {
        setupPieChartConfigs()
        binding.pieChartMainGraphic.data = getPieData()
        binding.appCompatTextViewMyInvestiments.text = totalInvested
    }

    private fun setupListProducts() {
        binding.recyclerViewInvestments.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewInvestments.adapter = adapter
    }

    private fun goToSecondScreen() {
        SecondScreenActivity.newInstance(
            context = this@MainActivity,
            totalValue = 4000f,
            investmentValue = 6000F
        )
    }

    private fun setupPieChartConfigs() {
        binding.pieChartMainGraphic.apply {
            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            setDrawEntryLabels(false)
            holeRadius = 92f
            description.isEnabled = false
            legend.isEnabled = false
            isRotationEnabled = false
        }
    }

    private fun getPieData(): PieData = PieData(PieDataSet(pieDataSet, stringEmpty).apply {
        setDrawValues(false)
        colors = Product().colors
        sliceSpace = 3f
    })

    override fun onClickedProduct(product: Product) {
        //TODO passar as informações necessárias para a SecondScreen
        goToSecondScreen()
    }
}
