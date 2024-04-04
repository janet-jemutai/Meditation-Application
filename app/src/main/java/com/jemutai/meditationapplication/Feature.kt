package com.jemutai.meditationapplication

import android.icu.text.CaseMap.Title
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color
import java.sql.RowId

data class Feature(
    val  title: String,
    @DrawableRes val  iconId: Int,
    val  lightColor: Color,
    val darkColor: Color,

)
