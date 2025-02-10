package ru.netology



fun main() {


//  Задача №1. Денежные переводы
    val commission = 0.75
    val minimalCommission = 35
    val amount = 100000
    val result = if ((amount*commission)/100 < minimalCommission) minimalCommission else (amount*commission)/100
    println(result)
    
//  Задача №2. Люди/Человеки
    val likes = 2132
    if (likes.toString()[likes.toString().length-1] == '1' && likes != 11){
        println("Понравилось $likes человеку")
    }else{
        println("Понравилось $likes людям")
    }

//  Задача №3. Меломан
    var money = 10001
    val regularCustomer = true

    if (money in 1001..10000){
        money = money-100
    }else if (money >= 10001){
        money = money-(money*5/100)
    }

    if (regularCustomer){
        println(money-(money*1/100))
    }else{
        println(money)
    }

}
