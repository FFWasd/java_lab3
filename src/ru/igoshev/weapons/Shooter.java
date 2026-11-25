package ru.igoshev.weapons;
public class Shooter {
    private String name;
    private Pistol2 pistol;
    private Rifle rifle;

    public Shooter(String name){
        this.name = name;
        this.pistol = null;
        this.rifle = null;
    }

    public void setName(String name){
        this.name = name;
        System.out.println("Имя изменено на " + name);
    }

    public void setPistol(Pistol2 pistol){
        this.pistol = pistol;
        this.rifle = null;
        System.out.println("Текущее оружие пистолет");
    }
    public Rifle getRifle(){
        return rifle;
    }
    public Pistol2 getPistol(){
        return pistol;
    }
    public void setRifle(Rifle rifle){
        this.rifle = rifle;
        this.pistol = null;
        System.out.println("Текущее оружие автомат");
    }

    public void takeWeapon(){
        this.rifle = null;
        this.pistol = null;
        System.out.println("У стрелка больше нет оружия");
    }
    
    public String getName(){
        return name;
    }

    public String getWeapon(){
        if(rifle != null && pistol == null){
            return "Текущее оружие автомат";
        }
        else if(rifle == null && pistol != null){
            return "Текущее оружие пистолет";
        }
        else{
            return "Нет оружия";
        }
    }

    @Override 
    public String toString(){
        if(rifle != null && pistol == null){
            return rifle.toString();
        }
        else if(rifle == null && pistol != null){
            return pistol.toString();
        }
        else{
            return "Не могу участвовать в перестрелке";
        }
    }
}