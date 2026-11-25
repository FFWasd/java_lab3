package ru.igoshev.geometry;
public class Point{
    private double x;
    private double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    double getX(){
        return x;
    }

    double getY(){
        return y;
    }

    @Override
    public String toString(){
        return "{" + x + ";" + y + "}";
    }

    @Override 
    public boolean equals(Object o){
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Point p = (Point) o;
        return (x ==p.getX() && y == p.getY());
    }
}