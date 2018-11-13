package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        try {


            InputStream inputStream=new FileInputStream(reader.readLine());
            load(inputStream);

            } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {

Properties prop=new Properties();
        prop.putAll(properties);
        prop.store(outputStream,"");

        }



        //implement this method - реализуйте этот метод


    public void load(InputStream inputStream) throws Exception {

        Properties proper=new Properties();
        proper.load(inputStream);
        for (Map.Entry<Object, Object> entry : proper.entrySet()) {
            properties.put((String)entry.getKey(), (String)entry.getValue());
        }


        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
