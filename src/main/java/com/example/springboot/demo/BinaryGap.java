package com.example.springboot.demo;

public class BinaryGap {

    public static void main(String[] args){
        int number = 1041;
        System.out.println("Input is " +number);
        System.out.println("Longest binary gap in number "+number + " is "+solution(number));
    }
    public static int solution(int N) {

        String binaryString = Integer.toBinaryString(N);
        System.out.println("Binary for number "+N +" is "+binaryString);

         int countsOfOne = 0;
         int countsOfZero = 0;

        char[] chars =  binaryString.toCharArray();
        int lengthOfLongestBinaryGap = 0;
        for(char c :chars){

            if(c == '1'){
                countsOfOne++;
            }else if(c == '0'){
                countsOfZero++;
            }

            if(countsOfOne == 2){
                if(countsOfZero >lengthOfLongestBinaryGap){
                    lengthOfLongestBinaryGap =countsOfZero;
                }
                countsOfOne = 1;
                countsOfZero = 0;
            }
        }
    return lengthOfLongestBinaryGap;

    }
}
