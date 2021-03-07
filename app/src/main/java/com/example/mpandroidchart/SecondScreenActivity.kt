package com.example.mpandroidchart

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mpandroidchart.Constants.FIXED_INCOME
import com.example.mpandroidchart.databinding.ActivitySecondScreenBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    private val investmentValue by lazy {
        intent.getFloatExtra(ARG_INVESTMENT_VALUE, 0F)
    }

    private val otherInvestmentValue by lazy {
        intent.getFloatExtra(ARG_OTHER_INVESTMENTS, 0F)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupPieChart()
    }

    private fun setupPieChart() {
        setupPieChartConfigs()
        binding.pieChartSecondGraphic.data = getPieData()
    }

    private fun setupPieChartConfigs() {
        binding.pieChartSecondGraphic.apply {
            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            setDrawEntryLabels(false)
            holeRadius = 85f
            centerText = setUpCenterText()
            setCenterTextSize(24F)
            description.isEnabled = false
            legend.isEnabled = false
            setTouchEnabled(false)
        }
    }

    private fun setUpCenterText(): CharSequence {
        val percentageValue = (investmentValue / (investmentValue + otherInvestmentValue)) * 100
        return String.format("%.0f%%", percentageValue)
    }

    private fun getPieData(): PieData {
        val pieDataSet = PieDataSet(getPieDataSet(), "").apply {
            setDrawValues(false)
            colors = listOf(
                ContextCompat.getColor(applicationContext, R.color.teal_700),
                ContextCompat.getColor(applicationContext, R.color.cinza_claro)
            )
            sliceSpace = 3f
        }
        return PieData(pieDataSet)
    }

    private fun getPieDataSet(): ArrayList<PieEntry> {
        return arrayListOf<PieEntry>().apply {
            add(PieEntry(investmentValue, FIXED_INCOME))
            add(PieEntry(otherInvestmentValue, ARG_OTHER_INVESTMENTS))
        }
    }

    companion object {
        private const val ARG_OTHER_INVESTMENTS = "outros investimentos"
        private const val ARG_INVESTMENT_VALUE = "investment value"

        fun newInstance(context: Context, totalValue: Float, investmentValue: Float) {
            val intent = Intent(context, SecondScreenActivity::class.java).apply {
                putExtra(ARG_OTHER_INVESTMENTS, totalValue)
                putExtra(ARG_INVESTMENT_VALUE, investmentValue)
            }
            context.startActivity(intent)
        }
    }
}
