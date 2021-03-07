package com.example.mpandroidchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mpandroidchart.Constants.FIXED_INCOME
import com.example.mpandroidchart.Constants.FUNDS
import com.example.mpandroidchart.Constants.PRIVATE_PENSION
import com.example.mpandroidchart.Constants.VARIABLE_INCOME
import com.example.mpandroidchart.Constants.stringEmpty
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

    private val pieDataSet: List<PieEntry> by lazy {
        arrayListOf<PieEntry>().apply {
            add(PieEntry(8000F, FIXED_INCOME))
            add(PieEntry(8000F, VARIABLE_INCOME))
            add(PieEntry(8000F, FUNDS))
            add(PieEntry(8000F, PRIVATE_PENSION))
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupClickListener()
        setupPieChart()
    }

    private fun setupClickListener() = with(binding) {
        pieChartMainGraphic.setOnChartValueSelectedListener(object : OnChartValueSelectedListener {
            override fun onValueSelected(e: Entry?, h: Highlight?) {
                //TODO update the adapter according to the selected item
                showToast((e as PieEntry).label)
            }

            override fun onNothingSelected() {
                //TODO update the adapter to its original state
                showToast()
            }
        })
        materialButtonContinue.setOnClickListener {
            goToSecondScreen()
        }
    }

    private fun goToSecondScreen() {
        SecondScreenActivity.newInstance(
            context = this@MainActivity,
            totalValue = 4000f,
            investmentValue = 6000F
        )
    }

    private fun setupPieChart() {
        setupPieChartConfigs()
        binding.pieChartMainGraphic.data = getPieData()
    }

    private fun setupPieChartConfigs() {
        binding.pieChartMainGraphic.apply {
            isDrawHoleEnabled = true
            setHoleColor(Color.TRANSPARENT)
            setDrawEntryLabels(false)
            holeRadius = 85f
            description.isEnabled = false
            legend.isEnabled = false
        }
    }

    private fun getPieData(): PieData = PieData(PieDataSet(pieDataSet, stringEmpty).apply {
        setDrawValues(false)
        colors = ColorTemplate.JOYFUL_COLORS.toList()
        sliceSpace = 3f
    })

    private fun showToast(msg: String? = null) {
        msg.also {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        } ?: Toast.makeText(this, R.string.nothing_selected, Toast.LENGTH_SHORT).show()
    }
}
