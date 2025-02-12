package com.example.dinnerdecider

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Use mutableList for adding/removing items
    private val foodList: MutableList<String> = mutableListOf("Pizza", "Burger", "Nuggets", "French Fries", "MilkShake")

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to your views
        val decideBtn: Button = findViewById(R.id.decideBtn)
        val addFoodBtn: Button = findViewById(R.id.sampleBtn)
        val selectedFoodTxt: TextView = findViewById(R.id.selectFoodTxt)
        val addFoodTxt: EditText = findViewById(R.id.edtFoodTxt)

        // Decide button action
        decideBtn.setOnClickListener {
            val randomFood = Random.nextInt(foodList.size)
            selectedFoodTxt.text = foodList[randomFood]
        }

        // Add food button action
        addFoodBtn.setOnClickListener {
            val newFood = addFoodTxt.text.toString()
            if (newFood.isNotEmpty()) {
                foodList.add(newFood)
                addFoodTxt.text.clear()
                // For debugging purposes, printing foodList
                println(foodList)
            } else {
                Toast.makeText(this, "Please enter a food item", Toast.LENGTH_SHORT).show()
            }
        }
    }
}