package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        PrintStream printStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        PrintStream printStream1 = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream1);

        testString.printSomething();

       String s=byteArrayOutputStream.toString();



        FileOutputStream fileOutputStream = new FileOutputStream(reader.readLine());
fileOutputStream.write(s.getBytes());

        System.setOut(printStream);
        System.out.println(s);
        reader.close();
        fileOutputStream.close();


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

