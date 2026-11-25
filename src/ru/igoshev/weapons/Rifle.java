package ru.igoshev.weapons;
public class Rifle extends Pistol{
    private final int rate;

    public Rifle(){
        super(30,30);
        rate = 30;
    }
    public Rifle(int max_bullets, int bullets){
        super(max_bullets,bullets);
        rate = max_bullets/2;
    }
    public Rifle(int max_bullets, int bullets, int rate){
        super(max_bullets,bullets);
        this.rate = rate;
    }
    
    public void timeFire(int time){
        for (int i =0; i<time; i++){
            System.out.println(this);
        }
    }
    
    @Override 
    public String toString(){
        String s ="";
        for (int i =0; i<rate; i++){
            if (getBullets()>0){
                s+= "Бах! ";
                takebullet();
            }
            else{
                s+= "Клац! ";
            }

        }
        return s;
    }
}