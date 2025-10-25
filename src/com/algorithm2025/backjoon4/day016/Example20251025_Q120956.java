package com.algorithm2025.backjoon4.day016;

public class Example20251025_Q120956 { //코딩테스트 연습 코딩테스트 입문  옹알이 (1)
    public int Example20251025_Q120956(String[] babbling) {
        int answer = 0;
        //조카는 아직 "aya", "ye", "woo", "ma"

        if(babbling.length>=1&&babbling.length<=100) {
            for(int i=0; i<babbling.length; i++) {
                if(babbling[i].length()>=1&&babbling[i].length()<=15) {
                    babbling[i]=babbling[i].replaceFirst("aya","1");
                    babbling[i]=babbling[i].replaceFirst("ye","1");
                    babbling[i]=babbling[i].replaceFirst("woo","1");
                    babbling[i]=babbling[i].replaceFirst("ma","1");
                    babbling[i]=babbling[i].replace("1","");
                    if(babbling[i].isEmpty()) {
                        answer+=1;
                    }
                }
            }
        }
        return answer;
    }
}
