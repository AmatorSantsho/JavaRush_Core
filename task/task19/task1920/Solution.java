package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;
        String name;
        double value;
        Map<String,Double> map=new HashMap<>();
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


        double maxValue =Collections.max(map.values());

ArrayList<String>list1=new ArrayList<>();
        for (Map.Entry entry:map.entrySet()){
           String key= (String) entry.getKey();
            Double val = (Double) entry.getValue();
            if(val==maxValue){
                list1.add(key);
            }
        }
Collections.sort(list1);
        for (String s:list1){
            System.out.println(s);
        }
    }
}
