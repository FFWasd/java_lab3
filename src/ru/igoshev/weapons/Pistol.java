package ru.igoshev.weapons;
public class Pistol{
    private int bullets;
    private final int max_bullets;

    public Pistol(int max_bullets, int bullets){
        this.bullets = bullets;
        this.max_bullets = max_bullets;
    }

    public int getMaxBullets(){
        return max_bullets;
    }

    public void reload(int bullets){
        if (bullets<0){
            System.out.println("Нельзя ввести отрицательно число! ");
        }
        else{
            if (bullets > max_bullets-this.bullets){
                int old_bullets = this.bullets;
                this.bullets = max_bullets;
                System.out.println("Заряжено " + (max_bullets - old_bullets) + " патронов");
                System.out.println("Возвращено " + (bullets - (max_bullets - old_bullets)) + " патронов");
            }
            else{
                this.bullets+=bullets;
                System.out.println("Заряжено " + bullets + " патронов");
            }
        }
    }

    void takebullet(){
        bullets--;
    }
    public void empty(){
        System.out.println("Возвращено " + this.bullets + " патронов");
        this.bullets = 0;
    }

    public int getBullets(){
        return bullets;
    }

    public boolean is_loaded(){
        return (bullets>0) ? true : false;
    }
    @Override 
    public String toString(){
        if (bullets>0){
            bullets--;
            return "Бах!";
        }
        else{
            return "Клац!";
        }
    }
}