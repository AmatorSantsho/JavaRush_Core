package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:\\aa.txt");
            InputStream inputStream = new FileInputStream("d:\\aa.txt");

            JavaRush javaRush = new JavaRush();

            User u=new User();
            User u2=new User();
            User u3 = new User();
            System.out.println(u3.getBirthDate());
            System.out.println(u3.isMale());
            System.out.println(u3.getCountry());
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
            Date date=simpleDateFormat.parse("25/12/1983");
            u.setBirthDate(date);
            u.setFirstName("aaa");
            u.setLastName("sss");
            u.setCountry(User.Country.RUSSIA);
            u.setMale(true);
            Date date2=simpleDateFormat.parse("28/02/1985");
            u2.setBirthDate(date2);
            u2.setFirstName("bbb");
            u2.setLastName("ccc");
            u2.setCountry(User.Country.UKRAINE);
            u2.setMale(false);

            javaRush.users.add(u);
            javaRush.users.add(u2);

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
//            for (User a:loadedObject.users){
//                System.out.println(a.getFirstName());
//                System.out.println(a.getLastName());
//                System.out.println(a.getBirthDate());
//                System.out.println(a.isMale());
//                System.out.println(a.getCountry().getDisplayedName());
//            }
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
if (loadedObject.equals(javaRush))
    System.out.println("Objeckts identificall");
            //System.out.println(loadedObject.users.get(0).getFirstName());
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter printWriter = new PrintWriter(outputStream);
            for (int i = 0; i < users.size(); i++) {
                if (!users.get(i).getFirstName().equals(null)){
                    printWriter.println("FirstName:");
                    printWriter.println(users.get(i).getFirstName());}
                if (!users.get(i).getLastName().equals(null)){
                    printWriter.println("LastName:");
                    printWriter.println(users.get(i).getLastName());}
                if (!users.get(i).getBirthDate().equals(null)){
                    printWriter.println("BirthDate:");
                    printWriter.println(users.get(i).getBirthDate().getTime());}
                if (users.get(i).isMale()){printWriter.println("Male:");
                    printWriter.println(users.get(i).isMale());}
                if (!users.get(i).getCountry().equals(null)){printWriter.println("Country:");
                    printWriter.println(users.get(i).getCountry());}
            }
            printWriter.close();


            //implement this method - реализуйте этот метод
        }

        public void load(InputStream inputStream) throws Exception {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (bufferedReader.ready()){
                User user = new User();
                String s = bufferedReader.readLine();
                if (s.equals("FirstName:")){user.setFirstName(bufferedReader.readLine());s = bufferedReader.readLine();}
                if (s.equals("LastName:")){user.setLastName(bufferedReader.readLine());s = bufferedReader.readLine();}
                if (s.equals("BirthDate:")){user.setBirthDate(new Date(Long.parseLong(bufferedReader.readLine())));s = bufferedReader.readLine();}
                if (s.equals("Male:")){user.setMale(Boolean.parseBoolean(bufferedReader.readLine()));s = bufferedReader.readLine();}else {user.setMale(false);}
                if (s.equals("Country:")){user.setCountry(User.Country.valueOf(bufferedReader.readLine()));}
                users.add(user);
            }


            bufferedReader.close();
            //implement this method - реализуйте этот метод
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
