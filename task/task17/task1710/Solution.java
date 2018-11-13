package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-c — добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u — обновляет данные человека с данным id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
id соответствует индексу в списке

Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров:
-c Миронов м 15/04/1990

Пример вывода для параметра -і:
Миронов м 15-Apr-1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {


        if (args[0].equals("-c")) {

            String name = args[1];
            String pol = args[2];
            String d = args[3];

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dat = simpleDateFormat.parse(d);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date data = simpleDateFormat1.parse(simpleDateFormat1.format(dat));
            Person person;
            if (pol.equals("м")) {
                person = Person.createMale(name, data);
            } else
                person = Person.createFemale(name, data);
            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        }
        if (args[0].equals("-u")) {
            String idString = args[1];
            int id = Integer.parseInt(idString);
            String name = args[2];
            String pol = args[3];
            String d = args[4];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dat = simpleDateFormat.parse(d);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date data = simpleDateFormat1.parse(simpleDateFormat1.format(dat));
            Person person = allPeople.get(id);
            person.setName(name);
            person.setBirthDay(data);
            if (pol.equals("м"))
                person.setSex(Sex.MALE);
            else
                person.setSex(Sex.FEMALE);
            allPeople.set(id, person);
        }

        if (args[0].equals("-d")) {
            String idString = args[1];
            int id = Integer.parseInt(idString);

            Person person = allPeople.get(id);
            person.setName(null);
            person.setBirthDay(null);
            person.setSex(null);
            allPeople.set(id, person);
        }
        if (args[0].equals("-i")) {
            String idString = args[1];
            int id = Integer.parseInt(idString);

            Person person = allPeople.get(id);
            Sex sex = person.getSex();
            String pol = "";
            if (sex.equals(Sex.MALE))
                pol = "м";
            else
                pol = "ж";
            Date date=person.getBirthDay();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

            System.out.print(person.getName() + " " + pol + " " +simpleDateFormat1.format(date) );


            //start here - начни тут
        }
    }
}