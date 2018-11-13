package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла — в allLines, из второго — в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
Не забудь закрыть потоки.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(bufferedReader.readLine());
        File file1 = new File(bufferedReader.readLine());
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s;
        while ((s=reader.readLine())!=null){

            allLines.add(s);
        }
reader.close();
        bufferedReader.close();
        BufferedReader reader2 = new BufferedReader(new FileReader(file1));
        String b;
        while ((b=reader2.readLine())!=null){

            forRemoveLines.add(b);
        }
        reader2.close();

        Solution solution=new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public  void joinData () throws CorruptedDataException{
        // если содержитВСЕ строки то удаляем ВСЕСтроки
        if (allLines.containsAll(forRemoveLines))
        {
            allLines.removeAll(forRemoveLines);
            return;
        }
        else {

            allLines.clear();
            throw new CorruptedDataException();
        }


    }
}
