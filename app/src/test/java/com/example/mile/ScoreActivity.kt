package com.example.mile.ui



import android.content.Intent

import android.os.Bundle

import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import com.example.mile.ui.databinding.ActivityScoreBinding



class ScoreActivity : AppCompatActivity() {


    private lateinit var binding: ActivityScoreBinding

    private val TAG = "ScoreActivity"


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityScoreBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val score = intent.getIntExtra("SCORE", 0)

        val total = intent.getIntExtra("TOTAL", 0)



        Log.d(TAG, "Score Screen loaded. Final: $score/$total")



        binding.tvScore.text = "Your Score: $score/$total"


        val percentage = score.toFloat() / total.toFloat()

        binding.tvFeedback.text = when {

            percentage >= 0.8 -> "Master Hacker! You can spot real tips from myths."

            percentage >= 0.5 -> "Great job! You know some tricks."

            else -> "Stay Safe Online! Keep practising to spot myths."

        }



        binding.btnReview.setOnClickListener {

            Log.d(TAG, "Review button clicked")

        }



        binding.btnRestart.setOnClickListener {

            Log.d(TAG, "Restart button clicked")

            val intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

            finish()
        }
    }
}





