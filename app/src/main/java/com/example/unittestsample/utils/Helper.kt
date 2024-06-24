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

    fun checkPassword(pass : String) : Boolean{
        if(pass.isNotEmpty() && pass.length > 6 && pass.length < 15){
            return true
        }
        else {
            return false
        }
    }

    fun reverseString(input : String) : String{

        if(input.isEmpty()){
            return ""
        }
        else {

            var charArr = input.toCharArray()
            for(i in 0 until (charArr.size/2)){
                var temp = charArr[i]
                charArr[i] = charArr[charArr.size - 1 -i]
                charArr[charArr.size - 1 -i] = temp
            }

            return String(charArr)
        }
    }
}