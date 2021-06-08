package com.example.productiveroutine

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fitness.*

class fitness : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness)


        //array to count and store checkbox data

        val list: ArrayList<String>
        list = ArrayList()

        //initializing checkbox

        val mCheck = findViewById<Button>(R.id.meditationCheck)
        val jCheck = findViewById<Button>(R.id.joggingCheck)
        val gCheck = findViewById<Button>(R.id.gymCheck)
        val freeCheck = findViewById<Button>(R.id.freehandCheck)
        val jrCheck = findViewById<Button>(R.id.jumpropeCheck)


        //adding checkbox data to declared array

        mCheck.setOnClickListener() {
            if (meditationCheck.isChecked())
                list.add("medition")
            else
                list.remove("medition")

        }
        jCheck.setOnClickListener() {
            if (joggingCheck.isChecked())
                list.add("jogging")
            else
                list.remove("jogging")

        }
        gCheck.setOnClickListener() {
            if (gymCheck.isChecked())
                list.add("gym")
            else
                list.remove("gym")

        }
        freeCheck.setOnClickListener() {
            if (freehandCheck.isChecked())
                list.add("free Hand")
            else
                list.remove("free Hand")

        }
        jrCheck.setOnClickListener() {
            if (jumpropeCheck.isChecked())
                list.add("jump rope")
            else
                list.remove("jump rope")

        }



        //code for performance button.

        performanceButton.setOnClickListener {
            if (list.count() == 1)
                resultText.text = "Not bad. You are on your way to crush it!";
            else if (list.count() == 2 || list.count() == 3)
                resultText.text = "Better. You are almost killing it!";
            else if (list.count() == 5 || list.count() == 4)
                resultText.text = "Amazing! You have nailed it today!";
            else
                resultText.text = "Poor Performance"


        }


        //creating back to home page button

        homeButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }


        //creating menu

       override  fun onCreateOptionsMenu(menu: Menu?): Boolean {
            val inflater = menuInflater
            inflater.inflate(R.menu.menu, menu)

            return true
        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {


            //menu intent to go to selected activity

            when(item.itemId){
                R.id.foodMenu ->{
                    val intent = Intent(this, Food::class.java)
                    startActivity(intent)
                    return  true
                }

                R.id.readingMenu -> {
                    val intent = Intent(this, Reading::class.java)
                    startActivity(intent)
                    return  true

                }
            }
            return super.onOptionsItemSelected(item)
        }
}