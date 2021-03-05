package com.example.mpandroidchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupClickListener()
        setupPieChart()
    }

    private fun setupClickListener(){
       btnContinue.setOnClickListener {
           SecondScreen.newInstance(this, 4000f, 6000F)
       }
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
        mainPieChart.description.isEnabled = false
        mainPieChart.legend.isEnabled = false
        mainPieChart.renderer.paintRender.setShadowLayer(10f, 0f, 24f, ContextCompat.getColor(applicationContext, android.R.color.darker_gray)
        )
    }

    private fun getPieData(): PieData {
        val pieDataSet = PieDataSet(getPieDataSet(), "")
        pieDataSet.setDrawValues(false)
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS.toList())
        pieDataSet.sliceSpace = 3f
        return PieData(pieDataSet)
    }

    private fun getPieDataSet(): ArrayList<PieEntry> {
        val pieChartEntries = arrayListOf<PieEntry>()
        pieChartEntries.add(PieEntry(8000F, "Renda Fixa"))
        pieChartEntries.add(PieEntry(8000F, "Renda Variável"))
        pieChartEntries.add(PieEntry(8000F, "Fundos"))
        pieChartEntries.add(PieEntry(8000F, "Previdência Privada"))
        return pieChartEntries
    }


}