package com.hfad.android.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hfad.android.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        binding.userNameTxt.text = userName

        val totalQuestion = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        var correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        binding.scoreTxt.text = "Your Score is $totalQuestion out of $correctAnswers"

        binding.finishBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}