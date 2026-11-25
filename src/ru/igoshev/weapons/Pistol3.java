package ru.igoshev.weapons;
public class Pistol3 extends Weapon2{
    private int max_bullets;

    void shoot(){
        System.out.println(this);
    }

    public Pistol3(){
        super(5);
        this.max_bullets = 5;
    }

    public Pistol3(int max_bullets, int bullets){
        super(bullets);
        this.max_bullets = max_bullets;
    }

    int get_max_bullets(){
        return max_bullets;
    }

    void reload(int bullets){
        if (bullets<0){
            System.out.println("Нельзя ввести отрицательно число! ");
            throw new RuntimeException();
        }
        else{
            if (bullets > max_bullets-ammo()){
                int old_bullets = ammo();
                load(max_bullets);
                System.out.println("Заряжено " + (max_bullets - old_bullets) + " патронов");
                System.out.println("Возвращено " + (bullets - (max_bullets - old_bullets)) + " патронов");
            }
            else{
                load(ammo()+bullets);
                System.out.println("Заряжено " + bullets + " патронов");
            }
        }
    }

    void empty(){
        System.out.println("Возвращено " + ammo() + " патронов");
        ammo=0;
    }

    boolean is_loaded(){
        return (ammo()>0) ? true : false;
    }
    @Override 
    public String toString(){
        if (super.ammo()>0){
            getAmmo();
            return "Бах!";
        }
        else{
            return "Клац!";
        }
    }
}