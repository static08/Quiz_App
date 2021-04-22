package com.example.quizapp

object Constants{
    const val user: String = "userName"
    const val tQuestions: String = "10"
    const val cAns: String ="0"

    fun getQuestions(): ArrayList<questionsContent>{
         val qList = ArrayList<questionsContent>()

        val q1 = questionsContent(id = 1,
            question = "Which country's flag is this ? ",
            image = R.drawable.argentina,
            oOne ="Brazil",
            oTwo = "Australia",
            oThree = "Argentina",
            oFour = "India",
            correct = 3 )

        qList.add(q1)

        val q2 = questionsContent(id = 2,
            question = "Which country's flag is this ?",
            image = R.drawable.brazil,
            oOne ="Russia",
            oTwo = "Brazil",
            oThree = "China",
            oFour = "Sweden",
            correct = 2 )

        qList.add(q2)

        val q3 = questionsContent(id = 3,
            question = "Which country's flag is this ?",
            image = R.drawable.canada,
            oOne ="Canada",
            oTwo = "Bangladesh",
            oThree = "Pakistan",
            oFour = "Australia",
            correct = 1 )
        qList.add(q3)

        val q4 = questionsContent(id = 4,
                question = "Which country's flag is this ?",
                image = R.drawable.france,
                oOne ="USA",
                oTwo = "Germany",
                oThree = "France",
                oFour = "Brazil",
                correct = 3 )
        qList.add(q4)

        val q5 = questionsContent(id = 5,
                question = "Which country's flag is this ?",
                image = R.drawable.germany,
                oOne ="Germany",
                oTwo = "France",
                oThree = "Nepal",
                oFour = "China",
                correct = 1 )
        qList.add(q5)

        val q6 = questionsContent(id = 6,
                question = "Which country's flag is this ?",
                image = R.drawable.india,
                oOne ="Russia",
                oTwo = "India",
                oThree = "Italy",
                oFour = "USA",
                correct = 2 )
        qList.add(q6)

        val q7 = questionsContent(id = 7,
                question = "Which country's flag is this ?",
                image = R.drawable.italy,
                oOne ="Bhutan",
                oTwo = "USA",
                oThree = "France",
                oFour = "Italy",
                correct = 4 )
        qList.add(q7)

        val q8 = questionsContent(id = 8,
                question = "Which country's flag is this ?",
                image = R.drawable.japan,
                oOne ="Afghanistan",
                oTwo = "China",
                oThree = "Japan",
                oFour = "South Korea",
                correct = 3 )
        qList.add(q8)

        val q9 = questionsContent(id = 9,
                question = "Which country's flag is this ?",
                image = R.drawable.usa,
                oOne ="Canada",
                oTwo = "USA",
                oThree = "England",
                oFour = "Egypt",
                correct = 2 )
        qList.add(q9)

        val q10 = questionsContent(id = 10,
                question = "Which country's flag is this ?",
                image = R.drawable.sweden,
                oOne ="Sweden",
                oTwo = "France",
                oThree = "Russia",
                oFour = "England",
                correct = 1 )
        qList.add(q10)

        return qList

    }
}