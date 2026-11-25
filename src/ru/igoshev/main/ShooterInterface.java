package ru.igoshev.main;
import ru.igoshev.weapons.*;
import java.util.Scanner;
import ru.igoshev.validation.*;

public class ShooterInterface {
    Scanner scanner = new Scanner(System.in);
    Validator val = new Validator();
    private Shooter shooter;

    public ShooterInterface(){
    }

    void givePistol(){
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
            Pistol2 pistol = new Pistol2(max_bullets, bullets);
            shooter.setPistol(pistol);
            scanner.nextLine();
    }

    void giveRifle(){
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
        System.out.print("Введите скорострельность: ");
        int rate = 0;
        while (rate<=0){
            rate = val.check_int();
            if (rate <=0 ) System.out.println("Число должно быть положительным ");
        }
        Rifle rifle = new Rifle(ammo, bullets, rate);
        shooter.setRifle(rifle);
        scanner.nextLine();
    }

    void reload(){
        if (shooter.getRifle() == null && shooter.getPistol() == null){
            System.out.println("Оружия нет");
            scanner.nextLine();
        } else if(shooter.getPistol() != null && shooter.getRifle() == null){
            Pistol2 pistol = shooter.getPistol();
            pistol.reload(pistol.get_max_bullets() - pistol.ammo());
            System.out.println("Пистолет заряжен");
            scanner.nextLine();
        } else{
            Rifle rifle = shooter.getRifle();
            rifle.reload(rifle.getMaxBullets() - rifle.getBullets());
            System.out.println("Автомат заряжен");
            scanner.nextLine();
        }
    }

    public void start(){
        String name;
        System.out.print("Введите имя стрелка: ");
        name = val.have_dig();
        shooter = new Shooter(name);
        System.out.print("1. Без оружия \n2. Пистолет \n3. Автомат \nВыберите оружие для стрелка: ");
        int n = val.check_int();
        if (n==1){
            shooter.takeWeapon();
        } else if(n==2){
            System.out.print("\033[H\033[J");
            System.out.flush();
            givePistol();
        } else if(n==3){
            System.out.print("\033[H\033[J");
            System.out.flush();
            giveRifle();
        } else{
            throw new IllegalArgumentException("Недоступный выбор");
        }
        int d = 1;
        while (d !=0){
            System.out.print("\033[H\033[J");
            System.out.flush();
            System.out.print("1. Выстрел \n2. Сменить оружие \n3. Сменить имя \n4. Узнать имя \n5. Узнать оружие \n6. Перезарядка \n0. Выход\nВыберите действие: ");
            d = val.check_int();
            System.out.print("\033[H\033[J");
            System.out.flush();
            switch (d) {
                case 1:
                    System.out.println(shooter);
                    scanner.nextLine();
                    break;
                case 2:
                    System.out.print("1. Без оружия \n2. Пистолет \n3. Автомат \nВыберите оружие для стрелка: ");
                    n = val.check_int();
                    if (n==1){
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        shooter.takeWeapon();
                        scanner.nextLine();
                    } else if(n==2){
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        givePistol();
                        scanner.nextLine();
                    } else if(n==3){
                        System.out.print("\033[H\033[J");
                        System.out.flush();
                        giveRifle();
                        scanner.nextLine();
                    } else{
                        System.out.println("Недоступный выбор");
                        scanner.nextLine();
                    }
                    break;
                case 3:
                    System.out.print("Введите имя: ");
                    name = val.have_dig();
                    shooter.setName(name);
                    System.out.println("Имя изменено");
                    scanner.nextLine();
                    break;
                case 4:
                    System.out.println("Имя стрелка: " + shooter.getName());
                    scanner.nextLine();
                    break;
                case 5:
                if (shooter.getRifle() == null && shooter.getPistol() == null){
                    System.out.println("Оружия нет");
                    scanner.nextLine();
                } else if(shooter.getPistol() != null && shooter.getRifle() == null){
                    System.out.println("Текущее оружие пистолет");
                    scanner.nextLine();
                } else{
                    System.out.println("Текущее оружие автомат");
                    scanner.nextLine();
                }
                break;
                case 6:
                    reload();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Такого выбора нет! ");
            }
        }
    }
}
