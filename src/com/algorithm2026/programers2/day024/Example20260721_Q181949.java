package com.algorithm2026.programers2.day024;

import java.util.*;

public class Example20260721_Q181949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder result = new StringBuilder();

        for(int i=0; i<a.length(); i++){

            char c=a.charAt(i);

            if(Character.isUpperCase(c)){
                result.append(Character.toLowerCase(c));
            } else if(Character.isLowerCase(c)){
                result.append(Character.toUpperCase(c));
            } else {
                result.append(c);
            }

        }
        sc.close();
        System.out.println(result);
    }
}
