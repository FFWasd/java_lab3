package ru.igoshev.main;

import java.util.ArrayList;
import java.util.Scanner;

import ru.igoshev.validation.*;

import ru.igoshev.weapons.*;
import ru.igoshev.person.*;
import ru.igoshev.contacts.*;
import ru.igoshev.geometry.*;

public class LabThird{
    Scanner scanner = new Scanner(System.in);
    Validator val = new Validator();

    void z1(){
        int max_bullets=0;
        int bullets=-1;
        while (max_bullets <=0 ){
            System.out.print("Введите максимальное число патронов: ");
            max_bullets = val.check_int();
            if (max_bullets < 0){
                System.out.println("Число должно быть положительным! ");
            }
        }
        while (bullets <0){
            System.out.print("Введите количество патронов: ");
            bullets = val.check_int();
            if (bullets < 0 ){
                System.out.println("Число должно быть положительным");
            }
        }
        Pistol pistol = new Pistol(max_bullets, bullets);
        int d = 1; 
        while (d!=0){
            System.out.print("\033[H\033[J");
            System.out.flush();
            System.out.print("1. Выстрел \n2. Перезарядка \n3. Разрядить \n4. Узнать максимальное количество патронов \n5. Узнать сколько патронов заряжено \n6. Узнать заряжен ли пистолет \n0. Выход\nВыберите действие: ");
            d = val.check_int();
            System.out.print("\033[H\033[J");
            System.out.flush();
            switch(d){
                case 1: 
                    System.out.println(pistol);
                    scanner.nextLine();
                    break;
                case 2:
                    int rel = 0;
                    System.out.print("Сколько патронов зарядить: ");
                    rel = val.check_int();
                    pistol.reload(rel);
                    scanner.nextLine();
                    break;
                case 3: 
                    pistol.empty();
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Максимально количество патронов: " + pistol.getMaxBullets());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Патронов заряжено: " + pistol.getBullets());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println(pistol.is_loaded() ? "Пистолет заряжен" : "Пистолет разряжен");
                    scanner.nextLine();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Такого выбора нет");
            }
        }
    }

    void z2(){
        System.out.print("Введите имя (Обязательно!): ");
        String first_name = val.have_dig();
        System.out.print("Введите фамилию: ");
        String second_name = val.have_dig();
        System.out.print("Введите отчество: ");
        String surname = val.have_dig();
        Name obj1;
        if (!first_name.isEmpty() && !second_name.isEmpty() && !surname.isEmpty()){
            try{
                obj1 = new Name(first_name, second_name, surname);
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
            obj1 = new Name(first_name, second_name, surname);
            System.out.println(obj1);
        } else if (!first_name.isEmpty() && !second_name.isEmpty() && surname.isEmpty()){
            try{
                obj1 = new Name(first_name, second_name);
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
            obj1 = new Name(first_name, second_name);
            System.out.println(obj1);
        } else if (!first_name.isEmpty() && second_name.isEmpty() && surname.isEmpty()){
            try{
                obj1 = new Name(first_name);
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
            obj1 = new Name(first_name);
            System.out.println(obj1);
        }else{
            System.out.println("Такие данные ввести нельзя! \nДоступные комбинации: \nЛичное имя \nЛичное имя и фамилия \nЛичное имя, фамилия, отчество");
            try{
                obj1 = new Name("");
            } catch (IllegalArgumentException e){
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
        scanner.nextLine();
    }

    void z3(){
        ContactBook cb = new ContactBook();
        int d = 1;
        while (d!=0){
            System.out.print("\033[H\033[J");
            System.out.flush();
            System.out.print("1. Добавить контакт \n2. Удалить контакт \n3. Узнать телефон \n4. Вывести все контакты \n5. Проверить имя \n6. Проверить телефон \n7. Получить все контакты \n8. Получить все имена \n9. Получить все телефоны \n10. Получить все имена по части \n0. Выход\nВыберите действие --> ");
            d = val.check_int();
            System.out.print("\033[H\033[J");
            System.out.flush();
            switch(d){
                case 1:{
                    System.out.print("Введите имя контакта: ");
                    String name = val.have_dig();
                    System.out.print("Введите номер телефона: ");
                    int number = val.check_int();
                    String cadd = cb.add(String.valueOf(number), name);
                    System.out.println("Контакт " + name + (cadd== null ? " добавлен" : " изменён, старый номер: " + cadd));
                    scanner.nextLine();
                    break;
                }
                case 2:{
                    System.out.print("Введите имя контакта: ");
                    String name = val.have_dig();
                    cb.delete(name);
                    scanner.nextLine();
                    break;
                }
                case 3:{
                    System.out.print("Введите имя контакта: ");
                    String name = val.have_dig();
                    System.out.println(cb.find(name));
                    scanner.nextLine();
                    break;
                }
                case 4:
                    System.out.println(cb);
                    scanner.nextLine();
                    break;
                case 5:{
                    System.out.print("Введите имя контакта: ");
                    String name = val.have_dig();
                    System.out.println("Контакт " + name + (cb.checkName(name) ? " существует" : " отсутствует"));
                    scanner.nextLine();
                    break;
                }
                case 6:{
                    System.out.print("Введите номер телефона: ");
                    int number = val.check_int();
                    System.out.println("Номер " + number + (cb.checkNumber(String.valueOf(number)) ? " существует" : " отсутствует"));
                    scanner.nextLine();
                    break;
                }
                case 7:{
                    ArrayList<String> list;
                    list = cb.getPairs();
                    System.out.println(list);
                    scanner.nextLine();
                    break;
                }
                case 8:{
                    ArrayList<String> list;
                    list = cb.getNames();
                    System.out.println(list);
                    scanner.nextLine();
                    break;
                }
                case 9:{
                    ArrayList<String> list;
                    list = cb.getNumbers();
                    System.out.println(list);
                    scanner.nextLine();
                    break;
                }
                case 10:{
                    ArrayList<String> list;
                    System.out.print("Введите часть имени: ");
                    String part = val.have_dig();
                    list = cb.getNamesByPart(part);
                    System.out.println(list);
                    scanner.nextLine();
                    break;
                }
                case 0:
                    break;
                default:
                    System.out.println("Такого варианта нет");
                    break;
            }
        }
    }
    void z4(){
        System.out.print("1. Без параметров \n2. С указанием максимального числа патронов \n3. С указанием максимального числа патронов и скорострельности \nВыберите тип создания автомата --> ");
        int d = val.check_int();
        Rifle rifle;
        if (d == 1){
            rifle = new Rifle();
        }
        else if (d == 2){
            System.out.print("Введите максимальное чило патронов: ");
            int ammo = 0;
            while (ammo<=0){
                ammo = val.check_int();
                if (ammo <=0 ) System.out.println("Число должно быть положительным ");
            }
            System.out.print("Введите количество заряженных патронов: ");
            int bullets = 0;
            while (bullets<=0){
                bullets = val.check_int();
                if (bullets <=0 ) System.out.println("Число должно быть положительным ");
            }
            rifle = new Rifle(ammo, bullets);
        }
        else if (d == 3){
            System.out.print("Введите максимальное чило патронов: ");
            int ammo = 0;
            while (ammo<=0){
                ammo = val.check_int();
                if (ammo <=0 ) System.out.println("Число должно быть положительным ");
            }
            System.out.println("Введите количество заряженных патронов: ");
            int bullets = 0;
            while (bullets<=0){
                bullets = val.check_int();
                if (bullets <=0 ) System.out.println("Число должно быть положительным ");
            }
            System.out.println("Введите скорострельность: ");
            int rate = 0;
            while (rate<=0){
                rate = val.check_int();
                if (rate <=0 ) System.out.println("Число должно быть положительным ");
            }
            rifle = new Rifle(ammo, bullets, rate);
        }
        else{
            rifle = new Rifle();
        }
        while (d!=0){
            System.out.print("\033[H\033[J");
            System.out.flush();
            System.out.print("1. Выстрел \n2. Перезарядка \n3. Разрядить \n4. Узнать максимальное количество патронов \n5. Узнать сколько патронов заряжено \n6. Узнать заряжен ли автомат \n7. Стрелять n секунд\nВыберите действие: ");
            d = val.check_int();
            System.out.print("\033[H\033[J");
            System.out.flush();
            switch(d){
                case 1: 
                    System.out.println(rifle);
                    scanner.nextLine();
                    break;
                case 2:
                    int rel = 0;
                    System.out.print("Сколько патронов зарядить: ");
                    rel = val.check_int();
                    rifle.reload(rel);
                    scanner.nextLine();
                    break;
                case 3: 
                    rifle.empty();
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Максимально количество патронов: " + rifle.getMaxBullets());
                    scanner.nextLine();
                    break;
                case 5:
                    System.out.println("Патронов заряжено: " + rifle.getBullets());
                    scanner.nextLine();
                    break;
                case 6:
                    System.out.println(rifle.is_loaded() ? "Автомат заряжен" : "Автомат разряжен");
                    scanner.nextLine();
                    break;
                case 7:
                    System.out.print("Введите количество секунд: ");
                    int sec = 0;
                    while (sec <=0){
                        sec = val.check_int();
                        if (sec <= 0) System.out.println("Число должно быть положительным");
                    }
                    rifle.timeFire(sec);
                    scanner.nextLine();
                case 0:
                    break;
                default:
                    System.out.println("Такого выбора нет");
            }
        }
    }

    void z6(){
        System.out.print("Введите координаты первой точки \nX: ");
        double X = val.checkDouble();
        System.out.print("Y: ");
        double Y = val.checkDouble();
        System.out.print("Введите координаты второй точки \nX: ");
        double X2 = val.checkDouble();
        System.out.print("Y: ");
        double Y2 = val.checkDouble();
        Point p1 = new Point(X,Y);
        Point p2 = new Point(X2, Y2);
        System.out.println(p1.equals(p2) ? "Точки равны " : "Точки не равны ");
        scanner.nextLine();
    }
    public void start(){
        int z = 1;
        while (z!= 0){
            System.out.print("\033[H\033[J");
            System.out.flush();
            System.out.print("Выберите задание: \n1. Перезарядка пистолета \n2. Непустые имена \n3. Жёлтые страницы \n4. Автомат \n5. Лучший стрелок \n6. Сравнение точек \n0. Выход \n--> ");
            z = val.check_int();
            System.out.print("\033[H\033[J");
            System.out.flush();
            switch (z) {
                case 1: {
                    z1();
                    break;
                }
                case 2:
                    z2();
                    break;  
                case 3:{
                    z3();
                    break;
                }
                case 4:{
                    z4();
                    break;
                }
                case 5:{
                    ShooterInterface z5 = new ShooterInterface();
                    z5.start();
                    break;
                }
                case 6:{
                    z6();
                    break;
                }
            }
        }
    }
}