package com.example.windowshopper

class WindowShopperViewModel{

    fun calculateNumberOfHours(hourlyWage: Double,itemPrice:Double):Double{

        //item price / hourly wage

        return itemPrice / hourlyWage
    }
}