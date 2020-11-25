package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.example.android.diceroller.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    lateinit var diceImage: ImageView
    lateinit var rollButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        diceImage = binding.diceImage
        rollButton = binding.rollButton

        rollButton.text = "Let's Roll"

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {

        val drawableResource = when (Random.nextInt(6) + 1) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
    }
}