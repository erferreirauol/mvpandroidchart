package com.example.mpandroidchart.ext

import android.graphics.Color
import android.os.Build
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.DrawableCompat
import com.example.mpandroidchart.R

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun ImageView.setDrawableColor(color: String) {
    val unwrappedDrawable = AppCompatResources.getDrawable(
        context,
        R.drawable.circle_image
    )
    val wrappedDrawable = unwrappedDrawable?.let {
        DrawableCompat.wrap(it)
    }
    this.setImageDrawable(wrappedDrawable)
    this.drawable.setTint(Color.parseColor(color))
}