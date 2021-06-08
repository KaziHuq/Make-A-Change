package com.example.productiveroutine

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_fitness.*
import kotlinx.android.synthetic.main.activity_food.*

class Food : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        //setting up dropdown menu

        val breakfastDescreption = arrayOf("Oatmeal", "Eggs", "Cereal", "Bread", "Butter")
        val lunchDescreption = arrayOf("Rice", "Salad", "Chicken", "Beef", "Avocado", "Broccoli")
        val dinnerDescreption = arrayOf("Rice", "Milk", "Bread", "Chicken")

        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, breakfastDescreption)
        val arrayAdapter2 =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, lunchDescreption)
        val arrayAdapter3 =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, dinnerDescreption)

        //assigning value to dropdown menu

        foodSpinner.adapter = arrayAdapter
        lunchSpinner.adapter = arrayAdapter2
        dinnerSpinner.adapter = arrayAdapter3


        //array to count and store checkbox data

        val list: ArrayList<String>
        list = ArrayList()

        //initializing checkbox

        val breakfast = findViewById<Button>(R.id.breakfastCheck)
        val lunch = findViewById<Button>(R.id.lunchCheck)
        val dinner = findViewById<Button>(R.id.dinnerCheck)


        //adding checkbox data to declared array

        breakfast.setOnClickListener() {
            if (breakfastCheck.isChecked())
                list.add("breakfast")
            else
                list.remove("breakfast")

        }

        lunch.setOnClickListener() {
            if (lunchCheck.isChecked())
                list.add("lunch")
            else
                list.remove("lunch")

        }

        dinner.setOnClickListener() {
            if (dinnerCheck.isChecked())
                list.add("breakfast")
            else
                list.remove("dinner")
        }


        //code for performance button.

        performanceButtonTwo.setOnClickListener {
            if (list.count() == 1)
                foodResult.text = "Not Good. Try to eat all your meal.";
            else if (list.count() == 2)
                foodResult.text = "Better. Try to eat all three meals";
            else if (list.count() == 3)
                foodResult.text = "Amazing. Keep it up!";
            else
                foodResult.text = "Poor"
        }


        //creating back to home page button

        homeButtonTwo.setOnClickListener {
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
            R.id.fitnessMenu ->{
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