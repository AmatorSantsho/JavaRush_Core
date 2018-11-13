package com.javarush.task.task19.task1923;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым — файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
Закрыть потоки.
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter(args[1]);
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        while (reader.ready()){
            String s= reader.readLine();
            String aa[]=s.split(" ");
            for (int i = 0; i <aa.length ; i++) {
                if(aa[i].matches(".+[0-9].+")) {
                    fileWriter.write(aa[i]+" ");





                }
            }


        }

        fileWriter.close();
        reader.close();
    }
}
