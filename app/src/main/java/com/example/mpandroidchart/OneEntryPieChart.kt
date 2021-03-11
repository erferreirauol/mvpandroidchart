package com.example.mpandroidchart

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import kotlin.math.roundToInt

class OneEntryPieChart(context: Context?, attrs: AttributeSet?) : PieChart(context, attrs) {

    fun setEntry(percentageValue: Float, color: Int) {
        centerText = String.format("%.0f%%", percentageValue.roundToInt().toFloat())
        data = PieData(getPieDataSet(percentageValue, color))
    }

    private fun getPieDataSet(percentageValue: Float, color: Int): PieDataSet {
        val otherValue = (100 - percentageValue)
        val pieEntries = arrayListOf<PieEntry>().apply {
            add(PieEntry(percentageValue, ARG_FIXED_VALUE))
            add(PieEntry(otherValue, ARG_OTHER_VALUE))
        }
        return PieDataSet(pieEntries, "").apply {
            setDrawValues(false)
            colors = listOf(
                color,
                ContextCompat.getColor(context, R.color.cinza_claro)
            )
            sliceSpace = 3f
        }
    }


    companion object {
        const val ARG_FIXED_VALUE = "fixed_value"
        const val ARG_OTHER_VALUE = "other_value"
    }
}