package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        binding.btnHigher.setOnClickListener {
            onHigherClick()
        }
        binding.btnEquals.setOnClickListener{
            onEqualClick()
        }
        binding.btnLower.setOnClickListener {
            onLowerClick()
        }
        updateUI()
    }

    private fun updateUI(){
        binding.tvLastThrow.text = getString(R.string.throwValue,lastThrow)
    }

    private fun rollDice(){
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick(){
        rollDice()
        if(currentThrow > lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onEqualClick(){
        rollDice()
        if(currentThrow == lastThrow) {
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onLowerClick(){
        rollDice()
        if(currentThrow < lastThrow){
            onAnswerCorrect()
        } else {
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this, "Correct", Toast.LENGTH_LONG).show()
    }

    private fun onAnswerIncorrect(){
        Toast.makeText(this, "Incorrect", Toast.LENGTH_LONG).show()
    }
}