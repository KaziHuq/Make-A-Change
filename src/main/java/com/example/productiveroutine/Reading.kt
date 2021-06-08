package com.example.productiveroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import kotlinx.android.synthetic.main.activity_food.*
import kotlinx.android.synthetic.main.activity_reading.*

class Reading : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reading)

        //array to count and store checkbox data
       val list: ArrayList<String>
        list = ArrayList()

        //initializing checkbox

        val twoPage = findViewById<Button>(R.id.twoCheck)
        val threePage = findViewById<Button>(R.id.threeCheck)
        val fourPage = findViewById<Button>(R.id.fourCheck)
        val fivePage = findViewById<Button>(R.id.fiveCheck)


        //adding checkbox data to declared array

        twoPage.setOnClickListener(){
            if(twoCheck.isChecked())
                list.add("two")
            else
                list.remove("two")
        }

        threePage.setOnClickListener(){
            if(threeCheck.isChecked())
                list.add("three")
            else
                list.remove("three")
        }

        fourPage.setOnClickListener(){
            if(fourCheck.isChecked())
                list.add("four")
            else
                list.remove("four")
        }

        fivePage.setOnClickListener(){
            if(fiveCheck.isChecked())
                list.add("five")
            else
                list.remove("five")
        }


        //code for performance button.

        performanceThree.setOnClickListener{
            if(list.count() == 1)
                readingText.text = "Keep it up.";
            else if(list.count() == 2 || list.count() == 3 )
                readingText.text = "Well Done Today";
            else if (list.count() == 4)
                readingText.text = "Excellent";
            else
                readingText.text = "Poor"
        }

        //creating back to home page button

        homeButtonThree.setOnClickListener {
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

            R.id.fitnessMenu -> {
                val intent = Intent(this, Reading::class.java)
                startActivity(intent)
                return  true

            }
        }
        return super.onOptionsItemSelected(item)
    }
}