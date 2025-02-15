package ru.netology



fun main() {
    // Задача №1. Когда собеседник был онлайн
    agoToText(60*60*22)



    //  Задача №2. Разная комиссия
    var card = "Visa"
    maxLimit(card, 89_000, 450_001)


}



fun maxLimit(cardType: String = "Мир", sumToday: Int, sumMonth: Int = 0){
    if (sumToday > 150_000){
        println("Блокировка операции, превышен дневной лимит")
    }else if (sumToday + sumMonth > 600_000){
        println("Блокировка операции, превышен месячный лимит")
    }else{
        if (cardType == "Mastercard"){
            if (sumMonth > 75000){
                println("Коммисия: " + ((sumToday*0.6)/100)+20)
            }else if (sumToday + sumMonth < 75_000){
                println("Коммисия отсутствует")
            }else if (sumMonth < 75000 && sumToday + sumMonth > 75000){
                val endHelp = 75_000 - sumMonth
                val endSum = sumToday - endHelp
                println("Коммисия: " + ((endSum*0.6)/100)+20)
            }

        }else if (cardType == "Visa"){
            if ((sumToday*0.75)/100 < 35){
                println("Коммисия: " + 35)
            }else{
                println("Коммисия: " + (sumToday*0.75)/100)
            }
        }else{
            println("Коммисия отсутствует")
        }
    }

}
fun agoToText(seconds: Int){
    when {
        seconds in 0..60 -> {
            println("был(а) только что")
        }
        seconds in 60..60*60 -> {
            val withOne = mutableListOf<Int>(1, 21, 31, 41, 51)
            val withTwoFreeFour = mutableListOf<Int>(2, 22, 32, 42, 52, 3, 4, 43, 33, 23, 53, 24, 34, 44, 54)
            val withFive = mutableListOf<Int>(5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 25, 35, 45, 55)
            var minute = ""
            if (withOne.contains(seconds/60)){
                minute = "минуту"
            }else if (withTwoFreeFour.contains(seconds/60)){
                minute = "минуты"
            }else if (withFive.contains(seconds/60)){
                minute = "минут"
            }else{
                minute = "минут"
            }
            println("был(а) ${seconds/60} $minute назад")
        }
        seconds in 60*60+1..24*60*60 -> {
            var hour = ""
            val withOne = mutableListOf<Int>(1, 21)
            val withTwo = mutableListOf<Int>(2, 3, 4, 22, 23, 24)

            if (withOne.contains((seconds/60)/60)){
                hour = "час"
            }else if (withTwo.contains((seconds/60)/60)){
                hour = "часа"
            }else if (((seconds/60)/60) in 5..20){
                hour = "часов"
            }
            println("был(а) ${(seconds/60)/60} $hour назад")
        }
        seconds in 24*60*60..(24*60*60)*2 -> {
            println("был(а) вчера")
        }
        seconds in (24*60*60)*2..(24*60*60)*3 -> {
            println("был(а) позавчера")
        }
        seconds > (24*60*60)*3 -> {
            println("был(а) давно")
        }
    }
}