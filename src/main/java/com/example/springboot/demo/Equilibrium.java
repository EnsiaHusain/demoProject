package com.example.springboot.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equilibrium {

    public static void main(String[] args){

        int[] numbers = {3,4,5,6,7,8,1};
        System.out.println(solution(numbers));


    }

    public static int solution(int[] numbers){

        int diff = 0;
        int leftsum = numbers[0];
        int rightSum = 0;

        int pivot =1;

        Arrays.sort(numbers);
        List list = new ArrayList();
        for(Object a:list){
            System.out.println(new Integer(a.toString()));
        }
        for(int i=pivot;i<numbers.length;i++){
            rightSum = rightSum+numbers[i];
        }
        diff = Math.abs(rightSum-leftsum);

        while(pivot<numbers.length-1){
            leftsum = leftsum+numbers[pivot];
            rightSum = rightSum-numbers[pivot];
            if(Math.abs(rightSum-leftsum) < diff){
                diff = Math.abs(rightSum-leftsum);
            }
            pivot++;
        }
        return diff;
    }
}
