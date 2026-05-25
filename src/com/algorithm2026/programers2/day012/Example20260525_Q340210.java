package com.algorithm2026.programers2.day012;

import java.util.*;

public class Example20260525_Q340210 { //PCCP 기출문제 [PCCP 기출문제] 4번 / 수식 복원하기

    private static int NToTen(int base, String num) {
        int number = 0;
        for (int i = 0; i < num.length(); i++) {
            number += Character.getNumericValue(num.charAt(i)) * Math.pow(base, num.length() - 1 - i);
        }
        return number;
    }

    private static String TenToN(int base, int num) {
        if (num == 0) return "0";
        StringBuilder result = new StringBuilder();

        for (int i = 2; i >= 0; i--) {
            int div = num / (int) Math.pow(base, i);
            if (result.length() > 0 || div != 0) {
                result.append(div);
            }
            num %= (int) Math.pow(base, i);
        }
        return result.toString();
    }

    public static String[] solution(String[] expressions) {
        List<String> answer = new ArrayList<>();
        List<String> hint = new ArrayList<>();
        List<Integer> answerFormat = new ArrayList<>();
        int maxFormat = 0;

        for (String e : expressions) {
            String[] parts = e.split(" ");
            String num1 = parts[0], func = parts[1], num2 = parts[2], ans = parts[4];

            maxFormat = Math.max(maxFormat, getMaxDigit(num1));
            maxFormat = Math.max(maxFormat, getMaxDigit(num2));

            if (!ans.equals("X")) {
                hint.add(e);
                maxFormat = Math.max(maxFormat, getMaxDigit(ans));
            } else {
                answer.add(e);
            }
        }

        for (int n = maxFormat + 1; n <= 9; n++) {
            boolean isValid = true;
            for (String h : hint) {
                String[] parts = h.split(" ");
                String num1 = parts[0], func = parts[1], num2 = parts[2], ans = parts[4];
                int num1BaseTen = NToTen(n, num1);
                int num2BaseTen = NToTen(n, num2);
                int ansBaseTen = NToTen(n, ans);

                if (func.equals("+") && (num1BaseTen + num2BaseTen != ansBaseTen)) {
                    isValid = false;
                    break;
                } else if (func.equals("-") && (num1BaseTen - num2BaseTen != ansBaseTen)) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                answerFormat.add(n);
            }
        }

        String[] resultExpressions = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            String[] parts = answer.get(i).split(" ");
            String num1 = parts[0], func = parts[1], num2 = parts[2];
            Set<String> ansSet = new HashSet<>();

            for (int base : answerFormat) {
                int num1BaseTen = NToTen(base, num1);
                int num2BaseTen = NToTen(base, num2);
                String res;

                if (func.equals("+")) {
                    res = TenToN(base, num1BaseTen + num2BaseTen);
                } else { // func equals "-"
                    res = TenToN(base, num1BaseTen - num2BaseTen);
                }
                ansSet.add(res);
            }

            if (ansSet.size() == 1) {
                resultExpressions[i] = num1 + " " + func + " " + num2 + " = " + ansSet.iterator().next();
            } else {
                resultExpressions[i] = num1 + " " + func + " " + num2 + " = ?";
            }
        }

        return resultExpressions;
    }

    private static int getMaxDigit(String num) {
        int maxDigit = 0;
        for (char c : num.toCharArray()) {
            maxDigit = Math.max(maxDigit, Character.getNumericValue(c));
        }
        return maxDigit;
    }
}
