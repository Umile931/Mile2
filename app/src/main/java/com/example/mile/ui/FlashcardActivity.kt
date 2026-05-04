package com.example.mile.ui

    import android.content.Intent

            import android.os.Bundle

            import android.util.Log

            import android.view.View

            import androidx.appcompat.app.AppCompatActivity

            import com.example.mile.ui.databinding.ActivityFlashcardBinding
    import kotlin.jvm.java


data class Question(val statement: String, val isHack: Boolean, val explanation: String)



    class FlashcardActivity : AppCompatActivity() {


        private lateinit var binding: ActivityFlashcardBinding

        private val TAG = "FlashcardActivity"


        // You need 5+ questions for marks - add your own

        private val questions = listOf(

            Question(
                "Putting your phone in rice fixes water damage",
                false,
                "Wrong! Rice does little. Power off and take it to a pro is the real hack."
            ),

            Question(
                "Using keyboard shortcuts like Ctrl+C saves time",
                true,
                "Correct! That's a real time-saver!"
            ),

            Question(
                "Microwaving a sponge disinfects it",
                true,
                "Correct! 2 mins on high kills 99% of bacteria."
            ),

            Question(
                "Carrots improve your night vision",
                false,
                "Wrong! That's a WW2 myth. They help eye health but won't give you night vision."
            ),

            Question(
                "Closing background apps saves battery",
                false,
                "Wrong! Modern Android manages this. Force-closing can use MORE battery."
            )

        )


        private var currentQuestionIndex = 0

        private var score = 0


        override fun onCreate(savedInstanceState: Bundle?) {

            super.onCreate(savedInstanceState)

            binding = ActivityFlashcardBinding.inflate(layoutInflater)

            setContentView(binding.root)



            Log.d(TAG, "Flashcard Screen loaded with ${questions.size} questions")

            loadQuestion()



            binding.btnHack.setOnClickListener { checkAnswer(true) }

            binding.btnMyth.setOnClickListener { checkAnswer(false) }

            binding.btnNext.setOnClickListener { nextQuestion() }

        }


        private fun loadQuestion() {

            val question = questions[currentQuestionIndex]

            binding.tvQuestion.text = question.statement

            binding.tvFeedback.text = ""

            binding.btnNext.visibility = View.GONE

            binding.btnHack.isEnabled = true

            binding.btnMyth.isEnabled = true

            Log.d(TAG, "Loaded question ${currentQuestionIndex + 1}: ${question.statement}")

        }


        private fun checkAnswer(userSaidHack: Boolean) {

            val question = questions[currentQuestionIndex]

            val isCorrect = userSaidHack == question.isHack



            if (isCorrect) {

                score++

                Log.i(TAG, "Correct answer. Score: $score")

            } else {

                Log.i(TAG, "Incorrect answer. Score: $score")

            }



            binding.tvFeedback.text = question.explanation

            binding.btnNext.visibility = View.VISIBLE

            binding.btnHack.isEnabled = false

            binding.btnMyth.isEnabled = false

        }


        private fun nextQuestion() {

            currentQuestionIndex++

            if (currentQuestionIndex < questions.size) {

                loadQuestion()

            } else {

            }
        }
    }

// Student: Umile, ST10524342

// IMAD5112 Assignment 2 - Life Hack or Urban Myth Flashcard App


