# 알고리즘 카테고리별 문제 목록

> src 폴더 기준 (총 Java 파일: 1069개)
> 생성일: 2026-07-02

## 요약

9개 카테고리 **모두 존재**합니다.

| 카테고리 | 존재 | 명시적 태그 | 패턴 매칭 합계 |
|---------|:----:|------------:|---------------:|
| 완전 탐색 | O | 2 | 70 |
| DFS/BFS | O | 6 | 80 |
| 동적 계획법 | O | 9 | 78 |
| 탐욕법 | O | 3 | 3 |
| 이진 탐색 | O | 5 | 41 |
| 투 포인터 | O | 0 | 11 |
| 그래프·트리 | O | 20 | 20 |
| 최단 거리 | O | 4 | 16 |
| 누적합 | O | 7 | 13 |

**분류 기준**
- **명시적 태그**: 파일 주석/클래스명에 카테고리 키워드가 직접 명시된 경우
- **패턴 매칭**: 코드 패턴(dfs/bfs, dp 배열, left/right 포인터 등)으로 탐지한 경우

---

## 완전 탐색

### 명시적 태그 (2)

- src/com/algorithm2025\backjoon2\day003\Example20250304_Q389480.java
- src/com/algorithm2025\backjoon4\day023\Example20251124_Q389480.java

### 패턴 매칭 (68)

- src/com/algorithm2023\jababookbackjoon2\Example20240327_q17135.java
- src/com/algorithm2023\jababookbackjoon3\Example20240403_q12100.java
- src/com/algorithm2023\jababookbackjoon3\Example20240405_q16987.java
- src/com/algorithm2023\jababookbackjoon3\Example20240405_q1759.java
- src/com/algorithm2023\jababookbackjoon3\Example20240405_q6603.java
- src/com/algorithm2023\jababookbackjoon3\Example20240406_q15686.java
- src/com/algorithm2023\jababookbackjoon3\Example20240415_q28215.java
- src/com/algorithm2023\jababookbackjoon3\Example20240420_q14502.java
- src/com/algorithm2023\jababookbackjoon3\Example20240420_q17141.java
- src/com/algorithm2023\jababookbackjoon3\Example20240421_q17142.java
- src/com/algorithm2023\jababookbackjoon3\Example20240428_q14502.java
- src/com/algorithm2023\jababookbackjoon3\Example20240521_4.java
- src/com/algorithm2023\jababookbackjoon3\Example20240527_q78.java
- src/com/algorithm2023\jababookbackjoon4\Example20240501_q15666.java
- src/com/algorithm2023\jababookbackjoon4\Example20240528_q12869.java
- src/com/algorithm2023\jababookbackjoon4\Example20240627_q17070.java
- src/com/algorithm2023\jababookbackjoon4\Example20240628_q394.java
- src/com/algorithm2023\jababookbackjoon4\Example20240817_16945.java
- src/com/algorithm2023\jababookbackjoon4\Example20240817_q3967.java
- src/com/algorithm2023\jababookbacojoon5\Example20240901_q12919.java
- src/com/algorithm2023\jababookbacojoon5\Example20240909_q6443.java
- src/com/algorithm2023\jababookbacojoon5\Example20241023_q2044.java
- src/com/algorithm2023\javabook\algoritm1\Example20241104_q7727.java
- src/com/algorithm2023\javabook\progmers02\Sample016.java
- src/com/algorithm2023\javabook\softerr\Example20240405_q9335.java
- src/com/algorithm2023\javabook\softerr\Example20240828_SportsFestival.java
- src/com/algorithm2024\javabookbacjoon6\Example20241106_q19942.java
- src/com/algorithm2024\javabookbacjoon6\Example20241109_q16493.java
- src/com/algorithm2024\letcode1\Example20240413_q79.java
- src/com/algorithm2024\letcode2\Example20240503_q22.java
- src/com/algorithm2024\letcode2\Example20240514_q1219.java
- src/com/algorithm2024\letcode2\Example20240520_q1863.java
- src/com/algorithm2024\letcode2\Example20240526_q1863.java
- src/com/algorithm2024\letcode3\Example20240627_q39.java
- src/com/algorithm2024\letcode5\Example20240802_q1062.java
- src/com/algorithm2024\letcode5\Example20240814_q40.java
- src/com/algorithm2024\letcode5\Example20240816_q1251.java
- src/com/algorithm2024\letcode\Exam20240228_q1.java
- src/com/algorithm2024\letcode\Example20240229_q49.java
- src/com/algorithm2024\letcode\Example20240305_q28075_2.java
- src/com/algorithm2024\programers01\Exam20240226_01.java
- src/com/algorithm2024\programers01\Exam20240226_02.java
- src/com/algorithm2024\programers01\Example20240308_Nqueen.java
- src/com/algorithm2024\programers01\Example20240309_03.java
- src/com/algorithm2024\programers02\Example20240406_1.java
- src/com/algorithm2024\programers02\Example20240415_1.java
- src/com/algorithm2024\programers03\Example20240512_01.java
- src/com/algorithm2024\programers03\Example20240520_q1.java
- src/com/algorithm2024\programers03\Example20240526_01.java
- src/com/algorithm2024\programers04\Example20240707_06.java
- src/com/algorithm2024\programers04\Example20240708_01.java
- src/com/algorithm2024\programers04\Example20240723_05.java
- src/com/algorithm2024\programers04\Example20240724_01.java
- src/com/algorithm2024\programers04\Example20240724_05.java
- src/com/algorithm2024\programers05\Example20240801_05.java
- src/com/algorithm2024\programers06\Example20240929_02.java
- src/com/algorithm2024\programers06\Example20241026_q1.java
- src/com/algorithm2024\programers06\Example20241027_q1.java
- src/com/algorithm2024\programers06\Example20241028_q21775.java
- src/com/algorithm2024\programers07\Example20241101_q1.java
- src/com/algorithm2024\programers07\Example20241214_q1.java
- src/com/algorithm2024\programers07\Example20241219_q1.java
- src/com/algorithm2025\backjoon2\day005\Example20250306_Q388352.java
- src/com/algorithm2025\backjoon2\day011\Example20250322_Q86054.java
- src/com/algorithm2025\backjoon2\day012\Example20250322_Q68647.java
- src/com/algorithm2025\backjoon2\day013\Example20250324_Q68647.java
- src/com/algorithm2025\backjoon4\day002\Example2020830_Q258709.java
- src/com/algorithm2026\programers2\day011\Example20260524_Q258709.java

## DFS/BFS

### 명시적 태그 (6)

- src/com/algorithm2024\programers04\Example20240707_07.java
- src/com/algorithm2024\programers04\Example20240717_03.java
- src/com/algorithm2024\programers04\Example20240723_06.java
- src/com/algorithm2024\programers04\Example20240725_01.java
- src/com/algorithm2025\backjoon3\day002\Example20250621_Q84021.java
- src/com/algorithm2025\backjoon3\day006\Example20250716_Q84021.java

### 패턴 매칭 (74)

- src/com/algorithm2023\jababookbackjoon1\Sample000.java
- src/com/algorithm2023\jababookbackjoon2\Sample007.java
- src/com/algorithm2023\jababookbackjoon3\Example20240402_q14500.java
- src/com/algorithm2023\jababookbackjoon3\Example20240403_q2146.java
- src/com/algorithm2023\jababookbackjoon3\Example20240405_q17086.java
- src/com/algorithm2023\jababookbackjoon3\Example20240405_q2206.java
- src/com/algorithm2023\jababookbackjoon3\Example20240407_q19236.java
- src/com/algorithm2023\jababookbackjoon3\Example20240408_q1937.java
- src/com/algorithm2023\jababookbackjoon3\Example20240419_q2468.java
- src/com/algorithm2023\jababookbackjoon3\Example20240421_q17142.java
- src/com/algorithm2023\jababookbackjoon3\Example20240920_q1939.java
- src/com/algorithm2023\jababookbackjoon3\Example20240923_q1525.java
- src/com/algorithm2023\jababookbackjoon4\Example20240528_q2665.java
- src/com/algorithm2023\jababookbackjoon\Sample011.java
- src/com/algorithm2023\jababookbackjoon\Sample018.java
- src/com/algorithm2023\jababookbackjoon\Sample020.java
- src/com/algorithm2023\jababookbackjoon\Sample028.java
- src/com/algorithm2023\jababookbackjoon\Sample029.java
- src/com/algorithm2023\jababookbackjoon\Sample033.java
- src/com/algorithm2023\jababookbackjoon\Sample036.java
- src/com/algorithm2023\jababookbackjoon\Sample038.java
- src/com/algorithm2023\jababookbacojoon5\Example20240901_q16274.java
- src/com/algorithm2023\jababookbacojoon5\Example20240908_q14442.java
- src/com/algorithm2023\jababookbacojoon5\Example20240908_q17182.java
- src/com/algorithm2023\jababookbacojoon5\Example20241030_q1167.java
- src/com/algorithm2023\jababookbacojoon5\Example20241030_q1967.java
- src/com/algorithm2023\javabook\softerr\Example20240406_q1.java
- src/com/algorithm2024\letcode1\Example20240404_q55.java
- src/com/algorithm2024\letcode1\Example20240423_q1992.java
- src/com/algorithm2024\letcode5\Example20240811_q2305.java
- src/com/algorithm2024\letcode6\Example20240831_q1905.java
- src/com/algorithm2024\letcode6\Example20240831_q947.java
- src/com/algorithm2024\letcode6\Example20240921_q386.java
- src/com/algorithm2024\letcode6\Example20241023_q10451.java
- src/com/algorithm2024\letcode6\Example20241026_q1593.java
- src/com/algorithm2024\letcode6\Example20241027_q1593.java
- src/com/algorithm2024\letcode\Exam20240228_q200.java
- src/com/algorithm2024\programers01\Example20240327.java
- src/com/algorithm2024\programers02\Example20240410_q1559.java
- src/com/algorithm2024\programers02\Example20240411_q11559.java
- src/com/algorithm2024\programers02\Example20240416_1.java
- src/com/algorithm2024\programers02\Example20240421_1.java
- src/com/algorithm2024\programers03\Example20240529_01.java
- src/com/algorithm2024\programers03\Example20240613_01.java
- src/com/algorithm2024\programers03\Sample20240627_01.java
- src/com/algorithm2024\programers03\Sample20240627_02.java
- src/com/algorithm2024\programers04\Example20240701_05.java
- src/com/algorithm2024\programers04\Example20240703_05.java
- src/com/algorithm2024\programers04\Example20240705_03.java
- src/com/algorithm2024\programers04\Example20240705_04.java
- src/com/algorithm2024\programers04\Example20240721_02.java
- src/com/algorithm2024\programers04\Example20240723_07.java
- src/com/algorithm2024\programers04\Example20240724_02.java
- src/com/algorithm2024\programers05\Example20240801_04.java
- src/com/algorithm2024\programers06\Example20240829_TreasureHunt.java
- src/com/algorithm2024\programers06\Example20241016_q2.java
- src/com/algorithm2024\programers06\Example20241018_q01.java
- src/com/algorithm2024\programers07\Example20241101_q2.java
- src/com/algorithm2024\programers07\Example20241203_Q1.java
- src/com/algorithm2024\programers07\Example202412_15.java
- src/com/algorithm2025\backjoon2\day010\Example20250317_Q1305.java
- src/com/algorithm2025\backjoon2\day021\Example20250518_Q72416.java
- src/com/algorithm2025\backjoon3\day006\Example20250716_Q68937.java
- src/com/algorithm2025\backjoon3\day011\Example20250729_q67260.java
- src/com/algorithm2025\backjoon3\day012\Example20250801_Q1.java
- src/com/algorithm2025\backjoon3\day016\Example20250806_Q76503.java
- src/com/algorithm2025\backjoon4\day009\Example20250927_Q17676.java
- src/com/algorithm2025\backjoon4\day015\Example20251024_Q258711.java
- src/com/algorithm2025\backjoon4\day019\Example20251115_Q258711.java
- src/com/algorithm2025\backjoon4\day027\Example20251206_Q92342.java
- src/com/algorithm2025\backjoon5\zero\day002\Example20251230_Q2.java
- src/com/algorithm2026\programers\day003\Example20260115_Q1.java
- src/com/algorithm2026\programers\day011\Example20260127_Q1.java
- src/com/algorithm2026\programers\day019\Example20260309_Q1.java

## 동적 계획법

### 명시적 태그 (9)

- src/com/algorithm2024\programers01\Exam20240223_01.java
- src/com/algorithm2024\programers03\Example20240529_02.java
- src/com/algorithm2024\programers03\Example20240529_02_1.java
- src/com/algorithm2024\programers04\Example20240704_02.java
- src/com/algorithm2024\programers07\Example20241214_q1.java
- src/com/algorithm2025\backjoon2\day011\Example20250322_Q86054.java
- src/com/algorithm2025\backjoon3\day008\Example20250724_Q1843.java
- src/com/algorithm2025\backjoon4\day007\Example20250918_Q1843.java
- src/com/algorithm2026\programers\day018\Example20260302_Q1.java

### 패턴 매칭 (69)

- src/com/algorithm2023\jababookbackjoon2\Exam20240311_q2169.java
- src/com/algorithm2023\jababookbackjoon2\Example20240311_q17484_1.java
- src/com/algorithm2023\jababookbackjoon2\Example20240311_q17485.java
- src/com/algorithm2023\jababookbackjoon2\Example20240317_q17485.java
- src/com/algorithm2023\jababookbackjoon2\Example20240317_q1784_1.java
- src/com/algorithm2023\jababookbackjoon2\Example20240317_q2169.java
- src/com/algorithm2023\jababookbackjoon2\Example20240325_q117222.java
- src/com/algorithm2023\jababookbackjoon2\Example20240325_q21562.java
- src/com/algorithm2023\jababookbackjoon2\Example20240331_q16236.java
- src/com/algorithm2023\jababookbackjoon2\Example_20240310_q2133.java
- src/com/algorithm2023\jababookbackjoon3\Example20240403_q11066.java
- src/com/algorithm2023\jababookbackjoon3\Example20240405_q17086.java
- src/com/algorithm2023\jababookbackjoon3\Example20240406_q2565.java
- src/com/algorithm2023\jababookbackjoon3\Example20240408_q17485.java
- src/com/algorithm2023\jababookbackjoon3\Example20240408_q1937.java
- src/com/algorithm2023\jababookbackjoon3\Example20240420_q17141.java
- src/com/algorithm2023\jababookbackjoon4\Example20240528_q10709.java
- src/com/algorithm2023\jababookbackjoon4\Example20240528_q12869.java
- src/com/algorithm2023\jababookbackjoon4\Example20240528_q2665.java
- src/com/algorithm2023\jababookbackjoon\Sample039.java
- src/com/algorithm2023\jababookbackjoon\Sample040.java
- src/com/algorithm2023\jababookbacojoon5\Example20240907_review.java
- src/com/algorithm2023\jababookbacojoon5\Example20241029_q4485.java
- src/com/algorithm2023\jababookbacojoon5\Example20241030_q2665.java
- src/com/algorithm2023\javabook\algoritm1\Example20240420_1.java
- src/com/algorithm2023\javabook\algoritm1\Example20240530_1.java
- src/com/algorithm2023\javabook\algoritm1\Example20241024_q2.java
- src/com/algorithm2023\javabook\datastructure\Example20240428_06.java
- src/com/algorithm2023\javabook\softerr\Example20240325_q6293.java
- src/com/algorithm2024\letcode1\Example20240430_q1143.java
- src/com/algorithm2024\letcode1\Example20240430_q300.java
- src/com/algorithm2024\letcode2\Example20240506_q62.java
- src/com/algorithm2024\letcode5\Example20240828_q1514.java
- src/com/algorithm2024\letcode\Exam0228_q2.java
- src/com/algorithm2024\letcode\Exam20240228_q70.java
- src/com/algorithm2024\letcode\Exam20240302_q787.java
- src/com/algorithm2024\letcode\Exam20240924_q787.java
- src/com/algorithm2024\programers01\Exam20240310_01.java
- src/com/algorithm2024\programers01\Example20240309_02.java
- src/com/algorithm2024\programers03\Example20240512_01.java
- src/com/algorithm2024\programers03\Example20240529_05.java
- src/com/algorithm2024\programers03\Example20240529_06.java
- src/com/algorithm2024\programers04\Example20240702_01.java
- src/com/algorithm2024\programers04\Example20240703_04.java
- src/com/algorithm2024\programers04\Example20240703_05.java
- src/com/algorithm2024\programers04\Example20240706_02.java
- src/com/algorithm2024\programers04\Example20240718_01.java
- src/com/algorithm2024\programers04\Example20240723_01.java
- src/com/algorithm2024\programers04\Example20240723_03.java
- src/com/algorithm2024\programers05\Example20240801_01.java
- src/com/algorithm2024\programers06\Example20240910_GraphOptimization.java
- src/com/algorithm2024\programers06\Example20240929_01.java
- src/com/algorithm2024\programers07\Example202411093_q2684.java
- src/com/algorithm2024\programers07\Example20241204_q1.java
- src/com/algorithm2024\programers07\Example20241219_q1.java
- src/com/algorithm2025\backjoon2\day003\Example20250304_Q389480.java
- src/com/algorithm2025\backjoon2\day010\Example20250317_Q1834.java
- src/com/algorithm2025\backjoon2\day012\Example20250322_Q68647.java
- src/com/algorithm2025\backjoon2\day013\Example20250324_Q68647.java
- src/com/algorithm2025\backjoon2\day015\Example20250424_Q214290.java
- src/com/algorithm2025\backjoon2\day016\Example20250510_Q214289.java
- src/com/algorithm2025\backjoon2\day016\Example20250510_Q214289_2.java
- src/com/algorithm2025\backjoon3\day017\Example20250807_Q1.java
- src/com/algorithm2025\backjoon3\day018\Example20250814_Q118668.java
- src/com/algorithm2025\backjoon3\day019\Example20250822_Q1.java
- src/com/algorithm2025\backjoon4\day023\Example20251124_Q389480.java
- src/com/algorithm2025\backjoon5\zero\day001\Example20251221_Q1.java
- src/com/algorithm2026\programers\day002\Example20260108_Q1.java
- src/com/algorithm2026\programers\day005\Example20260117_Q2.java

## 탐욕법

### 명시적 태그 (3)

- src/com/algorithm2024\programers04\Example20240704_04.java
- src/com/algorithm2025\backjoon4\day011\Example20251001_Q42860.java
- src/com/algorithm2025\backjoon4\day012\Example20251019_Q42860.java

## 이진 탐색

### 명시적 태그 (5)

- src/com/algorithm2024\letcode7\Example20241201_q1.java
- src/com/algorithm2024\programers04\Example20240723_01.java
- src/com/algorithm2024\programers04\Example20240724_01.java
- src/com/algorithm2024\programers07\Example20241203_Q1.java
- src/com/algorithm2025\backjoon2\day010\Example20250317_Q1305.java

### 패턴 매칭 (36)

- src/com/algorithm2023\jababookbackjoon3\Example20240406_q1477.java
- src/com/algorithm2023\jababookbackjoon3\Example20240418_q2303.java
- src/com/algorithm2023\jababookbackjoon3\Example20240920_q1939.java
- src/com/algorithm2023\jababookbackjoon4\Example20240507_q13702.java
- src/com/algorithm2023\jababookbackjoon4\Example20240528_q1940.java
- src/com/algorithm2023\jababookbackjoon4\Example2024_q13397.java
- src/com/algorithm2023\jababookbackjoon\Sample030.java
- src/com/algorithm2023\jababookbacojoon5\Example20240906_q14627.java
- src/com/algorithm2024\letcode2\Example20240504_q881.java
- src/com/algorithm2024\letcode2\Example20240505_q162.java
- src/com/algorithm2024\letcode3\Example20240602_q344.java
- src/com/algorithm2024\letcode3\Example20240618_q826.java
- src/com/algorithm2024\letcode3\Example20240620_q1552.java
- src/com/algorithm2024\letcode4\Example20240714_q9.java
- src/com/algorithm2024\letcode4\Example20240731_q35.java
- src/com/algorithm2024\letcode5\Example20240802_q17951.java
- src/com/algorithm2024\letcode5\Example20240812_q703.java
- src/com/algorithm2024\letcode5\Example20240814_q719.java
- src/com/algorithm2024\letcode5\Example20240822_q2295.java
- src/com/algorithm2024\letcode5\Example20240824_q564.java
- src/com/algorithm2024\letcode\Example20240303_q5.java
- src/com/algorithm2024\letcode\Example20240311_q33.java
- src/com/algorithm2024\letcode\Example20240311_q34.java
- src/com/algorithm2024\letcode\Example20240317_q33.java
- src/com/algorithm2024\letcode\Example20240317_q34.java
- src/com/algorithm2024\programers04\Example20240701_q6.java
- src/com/algorithm2024\programers04\Example20240703_02.java
- src/com/algorithm2024\programers04\Example20240707_01.java
- src/com/algorithm2024\programers04\Example20240723_05.java
- src/com/algorithm2024\programers06\Example20240830_MinimumSkillFinder.java
- src/com/algorithm2024\programers06\Example20240911_PuzzleGameChallenge.java
- src/com/algorithm2024\programers06\Example20241021_q1.java
- src/com/algorithm2025\backjoon3\day004\Example20250626_Q_L_704.java
- src/com/algorithm2025\backjoon4\day002\Example2020830_Q258709.java
- src/com/algorithm2026\programers2\day004\Example20260505_Q60060.java
- src/com/algorithm2026\programers2\day011\Example20260524_Q258709.java

## 투 포인터

### 패턴 매칭 (11)

- src/com/algorithm2023\jababookbackjoon4\Example20240528_q1940.java
- src/com/algorithm2024\letcode4\Example20240712_q1190.java
- src/com/algorithm2024\letcode5\Example20240814_q719.java
- src/com/algorithm2024\letcode6\Example20241025_q1190.java
- src/com/algorithm2024\letcode\Example20240303_q5.java
- src/com/algorithm2024\programers04\Example20240703_02.java
- src/com/algorithm2024\programers04\Example20240707_01.java
- src/com/algorithm2024\programers04\Example20240723_05.java
- src/com/algorithm2025\backjoon4\day002\Example2020830_Q258709.java
- src/com/algorithm2026\programers2\day004\Example20260505_Q60060.java
- src/com/algorithm2026\programers2\day011\Example20260524_Q258709.java

## 그래프·트리

### 명시적 태그 (20)

- src/com/algorithm2023\jababookbackjoon2\Sample002.java
- src/com/algorithm2023\javabook\algoritm1\Example20240420_6.java
- src/com/algorithm2024\letcode7\Example20241201_q1.java
- src/com/algorithm2024\programers01\exam2040124.java
- src/com/algorithm2024\programers02\Example20240401_4.java
- src/com/algorithm2024\programers03\Sample20240627_01.java
- src/com/algorithm2024\programers04\Example20240701_05.java
- src/com/algorithm2024\programers04\Example20240707_07.java
- src/com/algorithm2024\programers04\Example20240708_02.java
- src/com/algorithm2024\programers05\Example20240801_02.java
- src/com/algorithm2024\programers07\Example20241203_Q1.java
- src/com/algorithm2025\backjoon2\day005\Example20250306_Q388354.java
- src/com/algorithm2025\backjoon2\day010\Example20250317_Q1305.java
- src/com/algorithm2025\backjoon2\day012\Example20250323_Q49190.java
- src/com/algorithm2025\backjoon3\day006\Example20250716_Q68937.java
- src/com/algorithm2025\backjoon3\day009\Example20250727_Q388354.java
- src/com/algorithm2025\backjoon4\day009\Example20250927_Q17676.java
- src/com/algorithm2025\backjoon4\day015\Example20251024_Q258711.java
- src/com/algorithm2025\backjoon4\day019\Example20251115_Q258711.java
- src/com/algorithm2025\backjoon4\day029\Example20251215_Q49191.java

## 최단 거리

### 명시적 태그 (4)

- src/com/algorithm2023\jababookbackjoon1\Sample018.java
- src/com/algorithm2025\backjoon2\day020\Example20250517_Q81304.java
- src/com/algorithm2025\backjoon3\day018\Example20250814_Q118668.java
- src/com/algorithm2025\backjoon3\day019\Example20250822_Q1.java

### 패턴 매칭 (12)

- src/com/algorithm2023\jababookbackjoon3\Example20240402_q1197.java
- src/com/algorithm2023\jababookbackjoon\Sample027.java
- src/com/algorithm2023\jababookbacojoon5\Example20240907_review.java
- src/com/algorithm2023\jababookbacojoon5\Example20240908_q17182.java
- src/com/algorithm2024\letcode4\Example20240731_q1334.java
- src/com/algorithm2024\programers01\exam0209.java
- src/com/algorithm2024\programers04\Example20240705_05.java
- src/com/algorithm2024\programers04\Example20240718_01.java
- src/com/algorithm2024\programers06\Example20240910_GraphOptimization.java
- src/com/algorithm2025\backjoon2\day010\Example20250317_Q1834.java
- src/com/algorithm2025\backjoon4\day029\Example20251215_Q49191.java
- src/com/algorithm2026\programers\day005\Example20260117_Q2.java

## 누적합

### 명시적 태그 (7)

- src/com/algorithm2023\jababookbacojoon5\Example20240914_q2141.java
- src/com/algorithm2024\letcode3\Example20240613_q1248.java
- src/com/algorithm2024\letcode3\Example20240624_02.java
- src/com/algorithm2024\letcode6\Example20240903_q1894.java
- src/com/algorithm2024\programers01\Example20240331_01.java
- src/com/algorithm2024\programers04\Example20240703_06.java
- src/com/algorithm2024\programers04\Example20240704_01.java

### 패턴 매칭 (6)

- src/com/algorithm2023\jababookbackjoon2\Example20240327_q17144.java
- src/com/algorithm2023\jababookbackjoon3\Example20240404_q2015.java
- src/com/algorithm2023\jababookbackjoon3\Example20240417_q21921.java
- src/com/algorithm2023\jababookbackjoon3\Example20240419_q2573.java
- src/com/algorithm2023\javabook\algoritm1\Example20241024_q1.java
- src/com/algorithm2024\letcode\Example20240327_q2485.java
