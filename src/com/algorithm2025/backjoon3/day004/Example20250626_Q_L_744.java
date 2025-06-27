package com.algorithm2025.backjoon3.day004;

public class Example20250626_Q_L_744 { //번외 letcode 744 Find Smallest Letter Greater Than Target
   public char nextGreatestLetter(char[] letters, char target) {

       for(char c:letters){
           if(c>target){
                return c;
           }
       }
       return letters[0];
   }

}
