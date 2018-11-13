package com.javarush.task.task19.task1917;

/*
Свой FileWriter
Реализовать логику FileConsoleWriter.
Класс FileConsoleWriter должен содержать приватное поле FileWriter fileWriter.
Класс FileConsoleWriter должен содержать все конструкторы, которые инициализируют fileWriter для записи.

При записи данных в файл, должен дублировать эти данные на консоль.
Свой FileWriter
*/

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter  {
    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {

        fileWriter=new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {

       fileWriter=new FileWriter(fileName,append);
    }

    public FileConsoleWriter(File file) throws IOException {

       fileWriter=new FileWriter(file);

    }

    public FileConsoleWriter(File file, boolean append) throws IOException {

        fileWriter = new FileWriter(file,append);
    }

    public FileConsoleWriter(FileDescriptor fd) {

        fileWriter = new FileWriter(fd);
    }


    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }


    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        StringBuilder stringBuilder = new StringBuilder();
        for (char c: cbuf)
            stringBuilder.append(c);
        System.out.println(stringBuilder);


//        for (int i = 0; i <cbuf.length ; i++) {
//            System.out.println(cbuf[i]);
//        }
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
       StringBuffer stringBuffer = new StringBuffer();


            stringBuffer.append(cbuf, off, len);
        System.out.println(stringBuffer);

    }


    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }


    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);

            System.out.println(str.substring(off,off+len));

    }
    public  void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) {

    }

}
