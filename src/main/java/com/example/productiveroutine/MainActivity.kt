package com.example.productiveroutine

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_reading.*
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting system date and time

        val date = System.currentTimeMillis()

        val sdf = SimpleDateFormat("MMM dd, yyyy h:mm a")
        val dateString: String = sdf.format(date)
        dateView.setText(dateString)

       fitnessButton.setOnClickListener {
           val intent = Intent(this, fitness::class.java)
           startActivity(intent)
       }

        foodButton.setOnClickListener {
            val intent = Intent(this, Food::class.java)
            startActivity(intent)
        }

        readingButton.setOnClickListener {
            val intent = Intent(this, Reading::class.java)
            startActivity(intent)
        }

    }
}