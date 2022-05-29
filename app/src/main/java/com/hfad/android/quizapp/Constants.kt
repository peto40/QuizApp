package com.hfad.android.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val question = "What country does this flag belong to?"

        val questionList = ArrayList<Question>()

        val que1 = Question(
            1,
            question,
            R.drawable.argentina,
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            1
        )
        questionList.add(que1)

        val que2 = Question(
            2,
            question,
            R.drawable.armenia,
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            2
        )
        questionList.add(que2)

        val que3 = Question(
            3,
            question,
            R.drawable.australia,
            "Argentina",
            "Armenia",
            "Australia",
            "Austria",
            3
        )
        questionList.add(que3)

        val que4 = Question(
            4,
            question,
            R.drawable.albania,
            "Argentina",
            "Albania",
            "Australia",
            "Austria",
            2
        )
        questionList.add(que4)

        val que5 = Question(
            5,
            question,
            R.drawable.barbados,
            "Barbados",
            "Albania",
            "Australia",
            "Austria",
            1
        )
        questionList.add(que5)

        val que6 = Question(
            6,
            question,
            R.drawable.bangladesh,
            "Argentina",
            "Barbados",
            "Australia",
            "Bangladesh",
            4
        )
        questionList.add(que6)

        val que7 = Question(
            7,
            question,
            R.drawable.belize,
            "Belize",
            "Armenia",
            "Bangladesh",
            "Austria",
            1
        )
        questionList.add(que7)

        val que8 = Question(
            8,
            question,
            R.drawable.brazil,
            "Argentina",
            "Armenia",
            "Brazil",
            "Belize",
            3
        )
        questionList.add(que8)

        val que9 = Question(
            9,
            question,
            R.drawable.canada,
            "Argentina",
            "Brazil",
            "Canada",
            "Austria",
            3
        )
        questionList.add(que9)

        val que10 = Question(
            10,
            question,
            R.drawable.china,
            "China",
            "Armenia",
            "Australia",
            "Bangladesh",
            1
        )
        questionList.add(que10)

        return questionList

    }
}