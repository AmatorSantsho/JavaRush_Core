package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console=System.out;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        PrintStream printStream=new PrintStream(outputStream);
        System.setOut(printStream);
        testString.printSomething();

        String s=outputStream.toString();
        System.setOut(console);

String []aaa=s.split("\n");
        StringBuffer all_lines=new StringBuffer();
        for (int i = 0; i <aaa.length ; i++) {
            all_lines.append(aaa[i]);
            all_lines.append("\r\n");
            if (i%2!=0){
                all_lines.append("JavaRush - курсы Java онлайн");
                all_lines.append("\r\n");
            }
        }

        System.out.println(all_lines.toString());


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
