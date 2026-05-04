package com.example.mile.ui



import android.content.Intent

import android.os.Bundle

import android.util.Log

import androidx.appcompat.app.AppCompatActivity

import com.example.mile.ui.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {



        private lateinit var binding: ActivityMainBinding

        private val TAG = "MainActivity"



        override fun onCreate(savedInstanceState: Bundle?) {

                super.onCreate(savedInstanceState)

                binding = ActivityMainBinding.inflate(layoutInflater)

                setContentView(binding.root)



                Log.d(TAG, "Welcome Screen loaded")



                binding.btnStart.setOnClickListener {

                        Log.i(TAG, "Start button clicked")

                        val intent = Intent(this, FlashcardActivity::class.java)

                        startActivity(intent)

                }

        }

}
