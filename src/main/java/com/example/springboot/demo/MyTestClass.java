package com.example.springboot.demo;

public class MyTestClass {

    public static void main(String[] args) throws Exception{

        String s = "00-44  48 5555 8361";
        System.out.println(solution(s));
        int[] A = {3, 2, 0, 1};
        System.out.println(anotherSolution("cdeo", A));

    }
    private  static String solution(String s) throws Exception{

        if(s== null || s.length() <2){
            throw new Exception("Invalid String Length");
        }

        if(!s.matches("[- 0-9]+")){
            throw new Exception("Invalid String Expression");
        }

        //check if string contains 2 digits
        if(!s.matches("[- 0-9]*[- 0-9]")){
            throw new Exception("Invalid String");
        }

        StringBuffer strBuff = new StringBuffer();
        char[] charArray = s.toCharArray();
        int countOfDigits = 0;
        

        for(char c : charArray){
            if(Character.isDigit(c)){

                if(countOfDigits == 3  && strBuff.length()>=3){
                    strBuff.append('-');
                    countOfDigits =0;
                }
                strBuff.append(c);
                countOfDigits++;

                }
            }
        String str = strBuff.substring(strBuff.lastIndexOf("-"),strBuff.length());


        return strBuff.toString();
    }

    public static String anotherSolution(String s , int[] A){


        if(A.length <1 || A.length >1000){
            return "Invalid length of Array";
        }

        if(s.length() != A.length){
            return "String S and Array A is not of equal length";
        }
       StringBuffer str = new StringBuffer();
        str.append(s.charAt(0));
        int i =0;
        while(i<A.length){
            if(A[i] ==0){
                break;
            }
          //  str.append(s.charAt(i));
            str.append(s.charAt(A[i]));
            i = s.indexOf(s.charAt(A[i]));

        }
return str.toString();


    }
}
