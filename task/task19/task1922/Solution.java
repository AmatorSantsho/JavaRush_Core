package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Ищем нужные строки
Считать с консоли имя файла.
Вывести в консоль все строки из файла, которые содержат всего 2 слова из списка words.
Закрыть потоки.

Пример:
words содержит слова А, Б, В

Строки:
В Б А Д //3 слова из words, не подходит
Д А Д //1 слово из words, не подходит
Д А Б Д //2 слова — подходит, выводим
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader reader1 = new BufferedReader(fileReader);
        ArrayList<String> list = new ArrayList<>();
        while (reader1.ready()){
           String s=reader1.readLine();
            list.add(s);
        }
        reader1.close();
        for (int i = 0; i <list.size() ; i++) {

            String[]aa = list.get(i).split(" ");
            int coont = 0;
            for (int j = 0; j <aa.length ; j++) {
               if (words.contains(aa[j]))
coont++;
            }
            if (coont==2){
                System.out.println(list.get(i));
            }


        }



    }
}
