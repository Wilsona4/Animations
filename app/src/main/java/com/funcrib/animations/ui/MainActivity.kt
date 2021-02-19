package com.funcrib.animations.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.funcrib.animations.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btAnimations.setOnClickListener {
            val intent = Intent(this, ObjectActivity::class.java)
            startActivity(intent)
        }

        btOpenSource.setOnClickListener {
            val intent = Intent(this, GunnersActivity::class.java)
            startActivity(intent)
        }
    }
}