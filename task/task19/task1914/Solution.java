package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream1);

        testString.printSomething();
        String s = byteArrayOutputStream.toString();
        System.setOut(printStream);

        String ss[] = s.split(" ");
int a = Integer.parseInt(ss[0]);
        int b = Integer.parseInt(ss[2]);
        int c=0;
        String znak = ss[1];
        if(znak.equals("+"))
            c=a+b;
        if(znak.equals("-"))
            c=a-b;
        if(znak.equals("*"))
            c=a*b;
        Integer z= c;
           String sss = s+z.toString();



        System.out.println(sss);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

