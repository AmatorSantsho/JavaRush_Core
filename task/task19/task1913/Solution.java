package com.javarush.task.task19.task1913;

/* 
Выводим только цифры
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream1);

        testString.printSomething();

        System.setOut(printStream);
        String s = byteArrayOutputStream.toString();
        s = s.replaceAll("[^0-9]", "");


        System.out.print(s);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
