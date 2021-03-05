package com.example.mpandroidchart

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.alpha
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlinx.android.synthetic.main.activity_main.*

class SecondScreen : AppCompatActivity() {

    private val investmentValue by lazy { intent.getFloatExtra(ARG_INVESTMENT_VALUE, 0F) }
    private val otherInvestimentValue by lazy { intent.getFloatExtra(ARG_OTHER_INVESTMENTS, 0F) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)
        setupPieChart()
    }

    private fun setupPieChart() {
        setupPieChartConfigs()
        mainPieChart.data = getPieData()
    }

    private fun setupPieChartConfigs() {
        mainPieChart.isDrawHoleEnabled = true
        mainPieChart.setHoleColor(Color.TRANSPARENT)
        mainPieChart.setDrawEntryLabels(false)
        mainPieChart.holeRadius = 85f
        mainPieChart.centerText = setUpCenterText()
        mainPieChart.setCenterTextSize(24F)
        mainPieChart.description.isEnabled = false
        mainPieChart.legend.isEnabled = false
        mainPieChart.renderer.paintRender.setShadowLayer(
            10f, 0f, 24f, ContextCompat.getColor(applicationContext, android.R.color.darker_gray)
        )
    }

    private fun setUpCenterText(): CharSequence? {
         val percentageValue = (investmentValue/(investmentValue + otherInvestimentValue)) * 100
        return String.format("%.0f%%", percentageValue)
    }

    private fun getPieData(): PieData {
        val pieDataSet = PieDataSet(getPieDataSet(), "")
        pieDataSet.setDrawValues(false)
        pieDataSet.colors = listOf(
            ContextCompat.getColor(applicationContext, R.color.teal_700),
            ContextCompat.getColor(applicationContext, R.color.cinza_claro)
        )
        pieDataSet.sliceSpace = 3f
        return PieData(pieDataSet)
    }

    private fun getPieDataSet(): ArrayList<PieEntry> {
        val pieChartEntries = arrayListOf<PieEntry>()
        pieChartEntries.add(PieEntry(intent.getFloatExtra(ARG_INVESTMENT_VALUE, 0F), "Renda Fixa"))
        pieChartEntries.add(
            PieEntry(
                intent.getFloatExtra(ARG_OTHER_INVESTMENTS, 0F),
                "outros investimentos"
            )
        )
        return pieChartEntries
    }


    companion object {
        private val ARG_OTHER_INVESTMENTS = "outros investimentos"
        private val ARG_INVESTMENT_VALUE = "investment value"

        fun newInstance(context: Context, totalValue: Float, investmentValue: Float) {
            val intent = Intent(context, SecondScreen::class.java)
            intent.putExtra(ARG_OTHER_INVESTMENTS, totalValue)
            intent.putExtra(ARG_INVESTMENT_VALUE, investmentValue)
            context.startActivity(intent)
        }
    }
}
