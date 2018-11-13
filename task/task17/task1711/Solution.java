package com.javarush.task.task17.task1711;



import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
CrUD Batch — multiple Creation, Updates, Deletion

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...

Значения параметров:
name — имя, String
sex — пол, «м» или «ж», одна буква
bd — дата рождения в следующем формате 15/04/1990
-с — добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u — обновляет соответствующие данные людей с заданными id
-d — производит логическое удаление человека с id, заменяет все его данные на null
-i — выводит на экран информацию о всех людях с заданными id: name sex bd
id соответствует индексу в списке

Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример вывода для параметра -і с двумя id:
Миронов м 15-Apr-1990
Миронова ж 25-Apr-1997

*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
int n =args.length;
switch (args[0]) {
    case "-c": {
        for (int i = 1; i <n ;) {


            String name = args[i];
            String pol = args[i+1];
            String d = args[i+2];
i++;
            i++;
            i++;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dat = simpleDateFormat.parse(d);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date data = simpleDateFormat1.parse(simpleDateFormat1.format(dat));
            Person person;
            if (pol.equals("м")) {
                person = Person.createMale(name, data);
            } else
                person = Person.createFemale(name, data);
           synchronized (allPeople) {
               allPeople.add(person);
           }
            System.out.println(allPeople.indexOf(person));
        }
        break;
    }
    case "-u": {
        for (int i = 1; i <n ;) {


            String idString = args[i];
            int id = Integer.parseInt(idString);
            String name = args[i+1];
            String pol = args[i+2];
            String d = args[i+3];
            i++;
            i++;
            i++;
            i++;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date dat = simpleDateFormat.parse(d);

            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            Date data = simpleDateFormat1.parse(simpleDateFormat1.format(dat));
            synchronized (allPeople) {

                Person person = allPeople.get(id);
                person.setName(name);
                person.setBirthDay(data);
                if (pol.equals("м"))
                    person.setSex(Sex.MALE);
                else
                    person.setSex(Sex.FEMALE);
                allPeople.set(id, person);
            }
        }
        break;
    }

    case "-d": {
        for (int i = 1; i <n ; i++) {


            String idString = args[i];
            int id = Integer.parseInt(idString);
            synchronized (allPeople) {

                Person person = allPeople.get(id);
                person.setName(null);
                person.setBirthDay(null);
                person.setSex(null);
                allPeople.set(id, person);
            }
        }
        break;
    }
    case "-i":{
        for (int i = 1; i <n ; i++) {
            String idString = args[i];
            int id = Integer.parseInt(idString);
            synchronized (allPeople) {

                Person person = allPeople.get(id);
                Sex sex = person.getSex();
                String pol = "";
                if (sex.equals(Sex.MALE))
                    pol = "м";
                else
                    pol = "ж";
                Date date = person.getBirthDay();
                SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

                System.out.println(person.getName() + " " + pol + " " + simpleDateFormat1.format(date));
            }
        }
break;

    }
}
    }
}
