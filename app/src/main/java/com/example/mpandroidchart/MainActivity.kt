package com.example.mpandroidchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mpandroidchart.Constants.FIXED_INCOME
import com.example.mpandroidchart.Constants.FUNDS
import com.example.mpandroidchart.Constants.PRIVATE_PENSION
import com.example.mpandroidchart.Constants.VARIABLE_INCOME
import com.example.mpandroidchart.databinding.ActivityMainBinding
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.listener.OnChartValueSelectedListener
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListener()
        setupPieChart()
    }

    private fun setupClickListener() = with(binding) {
        mainPieChart.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                showToast((e as PieEntry).label)
            }

            override fun onNothingSelected() {
                showToast()
            }
        })
        btnContinue.setOnClickListener {
            SecondScreenActivity.newInstance(
                context = this@MainActivity,
                totalValue = 4000f,
                investmentValue = 6000F
            )
        }
    }

    private fun setupPieChart() {
        setupPieChartConfigs()
        binding.mainPieChart.data = getPieData()
    }

    private fun setupPieChartConfigs() {
        binding.mainPieChart.apply {
            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            setDrawEntryLabels(false)
            holeRadius = 85f
            description.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun getPieData(): PieData = PieData(PieDataSet(getPieDataSet(), "").apply {
        setDrawValues(false)
        colors = ColorTemplate.JOYFUL_COLORS.toList()
        sliceSpace = 3f
    })

    private fun getPieDataSet(): ArrayList<PieEntry> {
        return arrayListOf<PieEntry>().apply {
            add(PieEntry(8000F, FIXED_INCOME))
            add(PieEntry(8000F, VARIABLE_INCOME))
            add(PieEntry(8000F, FUNDS))
            add(PieEntry(8000F, PRIVATE_PENSION))
        }
    }

    private fun showToast(msg: String? = null) {
        if (msg != null) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, R.string.nothing_selected, Toast.LENGTH_LONG).show()
        }
    }
}