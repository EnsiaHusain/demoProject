package com.example.springboot.demo;

public class FindMissingElement {

    public static void main(String[] args){
        int[] numbers = {1,2,5,6,3,8,9,7};
        System.out.println("Missing elements is "+findMissingElement(numbers));
    }

    public static int findMissingElement(int[] numbers){

        int totalNumbeerOfElements = numbers.length+1;

        int sumOfTotalElements = (totalNumbeerOfElements*(totalNumbeerOfElements+1))/2;
        int sumOfElementsInArray = 0;

        for(int a:numbers){
            sumOfElementsInArray = sumOfElementsInArray+a;
        }

        return sumOfTotalElements-sumOfElementsInArray;
    }
}
