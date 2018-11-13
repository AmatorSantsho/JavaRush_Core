package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader reader1 =new BufferedReader(new FileReader(reader.readLine()));
       BufferedWriter writer =new BufferedWriter(new FileWriter(reader.readLine()));

        reader.close();

        while (reader1.ready()){
           int x= reader1.read();
         if(!Pattern.matches("\\p{Punct}",String.valueOf((char)x)))
         {
             writer.write(x);
         }

        }
        reader1.close();
        writer.close();
//String s= " ";
//        char[]a =s.toCharArray();
//        System.out.println((int)a[0]);

    }
}
