package com.javarush.task.task19.task1924;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
1. В статическом блоке инициализировать словарь map парами [число-слово] от 0 до 12 включительно.
Например, 0 — «ноль«, 1 — «один«, 2 — «два»
2. Считать с консоли имя файла, считать содержимое файла.
3. Заменить все числа на слова используя словарь map.
4. Результат вывести на экран.
5. Закрыть потоки.

Пример данных в файле:
Это стоит 1 бакс, а вот это - 12 .
Переменная имеет имя file1.
110 - это число.

Пример вывода в консоль:
Это стоит один бакс, а вот это - двенадцать .
Переменная имеет имя file1.
110 - это число.
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();
    static {
        map.put(0,"ноль");
        map.put(1,"один");
        map.put(2,"два");
        map.put(3,"три");
        map.put(4,"четыре");
        map.put(5,"пять");
        map.put(6,"шесть");
        map.put(7,"семь");
        map.put(8,"восемь");
        map.put(9,"девять");
        map.put(10,"десять");
        map.put(11,"одиннадцать");
        map.put(12,"двенадцать");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        String filename=reader.readLine();
        reader.close();
        reader=new BufferedReader(new FileReader(filename));
        String line="";
        String newLine="";
        while (reader.ready()){
            line = reader.readLine();
            newLine=newLine+line+"\n";
        }
        String[] str = newLine.split(" ");
        for (int i=0;i<str.length;i++){
            switch (str[i]){
                case "0": str[i]=map.get(0);
                    break;
                case "1": str[i]=map.get(1);
                    break;
                case "2": str[i]=map.get(2);
                    break;
                case "3": str[i]=map.get(3);
                    break;
                case "4": str[i]=map.get(4);
                    break;
                case "5": str[i]=map.get(5);
                    break;
                case "6": str[i]=map.get(6);
                    break;
                case "7": str[i]=map.get(7);
                    break;
                case "8": str[i]=map.get(8);
                    break;
                case "9": str[i]=map.get(9);
                    break;
                case "10": str[i]=map.get(10);
                    break;
                case "11": str[i]=map.get(11);
                    break;
                case "12": str[i]=map.get(12);
                    break;
            }
            System.out.print(str[i]+" ");
        }
        reader.close();
    }
}
