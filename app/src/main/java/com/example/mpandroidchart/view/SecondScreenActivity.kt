package com.example.mpandroidchart.view

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.mpandroidchart.model.Constants.FIXED_INCOME
import com.example.mpandroidchart.R
import com.example.mpandroidchart.databinding.ActivitySecondScreenBinding
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlin.math.roundToInt

class SecondScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupPieChart()
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
            setEntry(40.1231F, R.color.teal_700)
        }
    }


    companion object {
        private const val ARG_OTHER_INVESTMENTS = "ARG_OTHER_INVESTMENTS"
        private const val ARG_INVESTMENT_VALUE = "ARG_INVESTMENT_VALUE"

        fun newInstance(context: Context, totalValue: Float, investmentValue: Float) {
            val intent = Intent(context, SecondScreenActivity::class.java).apply {
                putExtra(ARG_OTHER_INVESTMENTS, totalValue)
                putExtra(ARG_INVESTMENT_VALUE, investmentValue)
            }
            context.startActivity(intent)
        }
    }
}
