package com.hfad.android.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.hfad.android.quizapp.databinding.ActivityQuizQuestionsBinding

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityQuizQuestionsBinding

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        binding.optionOneTxt.setOnClickListener(this)
        binding.optionTwoTxt.setOnClickListener(this)
        binding.optionThreeTxt.setOnClickListener(this)
        binding.optionFourTxt.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)
    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition -1]

        defaultOptionView()

        if (mCurrentPosition == mQuestionList!!.size){
            binding.submitBtn.text = "FINISH"
        } else {
            binding.submitBtn.text = "SUBMIT"
        }

        binding.progressBar.progress = mCurrentPosition
        binding.progressTxt.text = "$mCurrentPosition" + "/" + binding.progressBar.max

        binding.questionTxt.text = question.question

        binding.imageId.setImageResource(question.image)

        binding.optionOneTxt.text = question.optionOne
        binding.optionTwoTxt.text = question.optionTwo
        binding.optionThreeTxt.text = question.optionThree
        binding.optionFourTxt.text = question.optionFour
    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()

        options.add(0, binding.optionOneTxt)
        options.add(1, binding.optionTwoTxt)
        options.add(2, binding.optionThreeTxt)
        options.add(3, binding.optionFourTxt)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_option_border)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.optionOne_txt -> {
                selectedOptionView(binding.optionOneTxt, 1)
            }
            R.id.optionTwo_txt -> {
                selectedOptionView(binding.optionTwoTxt, 2)
            }
            R.id.optionThree_txt -> {
                selectedOptionView(binding.optionThreeTxt, 3)
            }
            R.id.optionFour_txt -> {
                selectedOptionView(binding.optionFourTxt, 4)
            }
            R.id.submit_btn -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION, mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrentPosition -1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)

                    if (mCurrentPosition == mQuestionList!!.size){
                        binding.submitBtn.text = "FINISH"
                    } else {
                        binding.submitBtn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }

            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.optionOneTxt.background = ContextCompat.getDrawable(this, drawableView)
            }

            2 -> {
                binding.optionTwoTxt.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 -> {
                binding.optionThreeTxt.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 -> {
                binding.optionFourTxt.background = ContextCompat.getDrawable(this, drawableView)
            }
        }
    }

    private fun selectedOptionView(textView: TextView, selectedOptionNumber: Int) {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNumber

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this, R.drawable.selected_option_border)
    }

}