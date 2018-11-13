package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1 = args[0];
        String file2 = args[1];
       FileReader reader = new FileReader(file1);
        BufferedReader buffereReader = new BufferedReader(reader);
        FileWriter writer =new FileWriter(file2);
        String line=null;
        StringBuilder str = new StringBuilder();
        while ((line=buffereReader.readLine())!=null){
            String[]a = line.split(" ");
            for (int i = 0; i <a.length ; i++) {
                if (a[i].length()>6){
                    str.append(a[i]+",");
                }
            }
        }

buffereReader.close();
        //reader.close();
        writer.write(str.toString().substring(0,str.length()-1));

writer.close();

    }
}
