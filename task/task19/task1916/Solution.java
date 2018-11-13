package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ff1=reader.readLine();
        String ff2=reader.readLine();

        reader.close();

        List<String> f1 = new ArrayList<String>(), f2 = new ArrayList<String>();
        BufferedReader fileReader1 = new BufferedReader(new FileReader(ff1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(ff2));


        while (fileReader1.ready()) f1.add(fileReader1.readLine());
        while (fileReader2.ready()) f2.add(fileReader2.readLine());
        fileReader2.close(); fileReader1.close();

        boolean flag = false;
        while (true) {
            if (f1.isEmpty()){
                if (f2.isEmpty()) break;
            else {
                if (flag) break;
                flag = true;
                lines.add(new LineItem(Type.ADDED, f2.get(0)));
            }
        } else if (f2.isEmpty()) {
            if (flag) break;
            flag = true;
            lines.add(new LineItem(Type.ADDED, f1.get(0)));
        } else if (f1.get(0).equals(f2.get(0))) {
            flag = false;
            lines.add(new LineItem(Type.SAME, f1.get(0)));
            f1.remove(0); f2.remove(0);
        } else {
            if (f1.get(0).equals(f2.get(1))) {
                if (flag) break;
                flag = true;
                lines.add(new LineItem(Type.ADDED, f2.get(0)));
                f2.remove(0);
            } else {
                if (flag) break;
                flag = true;
                lines.add(new LineItem(Type.REMOVED, f1.get(0)));
                f1.remove(0);
            }
        }
    }
}

public static enum Type {
    ADDED,        //добавлена новая строка
    REMOVED,      //удалена строка
    SAME          //без изменений
}

public static class LineItem {
    public Type type;
    public String line;

    public LineItem(Type type, String line) {
        this.type = type;
        this.line = line;
    }
}
}