package com.daniel.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.*

class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var errorActionButton: Button

    init {
        LayoutInflater.from(context).inflate(R.layout.error_view, this, true)
        errorActionButton = findViewById(R.id.error_view_btn_try_again)
    }
}