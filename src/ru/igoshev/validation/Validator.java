package ru.igoshev.validation;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;

public class Validator{
    String consoleEncoding = System.getProperty("console.encoding", "UTF-8");
    Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8);
    public int check_int(){
        int z;
        while (true){
            if (scanner.hasNextInt()){
                z = scanner.nextInt();
                break;
            }
            else{
                System.out.print("Введено не число, повторите попытку --> ");
                scanner.next();
            }
        }
        scanner.nextLine();
        return z;
    }
    
    public String have_dig(){
        String s;
        while (true){
            s = scanner.nextLine();
            if (s.matches("^[a-zA-Zа-яА-ЯёЁ-]*$")){
                break;
            }
            else{
                System.out.print("В строке есть недопустимые символы, повторите попытку --> ");
            }
        }
        return s;
    }

    public double checkDouble(){
        double z;
        while (true){
            if (scanner.hasNextDouble()){
                z = scanner.nextDouble();
                break;
            }
            else{
                System.out.print("Введено не число, повторите попытку --> ");
                scanner.next();
            }
        }
        scanner.nextLine();
        return z;
    }
}
