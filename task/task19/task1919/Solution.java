package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String name;
        double value;
        Map<String,Double> map=new TreeMap<>();
        while ((line = bufferedReader.readLine())!=null){
            String a[]=line.split(" ");
            name=a[0];
            value= Double.parseDouble(a[1]);
            if(!map.containsKey(name)){
                map.put(name,value);
            }else{
               double newValue= map.get(name)+value;
                map.put(name,newValue);
            }

        }
        bufferedReader.close();

for (Map.Entry entry:map.entrySet()){
    System.out.println(entry.getKey() + " "+ entry.getValue());
}

    }
}
