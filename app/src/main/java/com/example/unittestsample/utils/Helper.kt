package com.example.unittestsample.utils

class Helper {

    fun checkPalindrome(input : String) : Boolean{

        var isPalindrome = false
        var i = 0
        var j = input.length -1

        while (i <= j){

            if(input[i].equals(input[j])){

                isPalindrome = true
            }
            else{
                isPalindrome = false
                break
            }
            i++
            j--
        }

        return isPalindrome
    }
}