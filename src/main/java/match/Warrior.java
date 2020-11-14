package match;

import java.util.Random;

public class Warrior {

    private String name;
    private int stamina;
    private double skill;
    private Point position;

    public Warrior(String name, Point position) {
        this.name = name;
        this.position = position;
        Random rnd = new Random();
        stamina = rnd.nextInt(81)+20;
        skill = rnd.nextDouble();
    }

    public Point getPosition() {
        return position;
    }

    public double distance (Warrior other){
        return position.distance(other.getPosition());

    }

    public void move (Warrior other){
        int x = 0;
        int y =0;
        if (other.getPosition().getX()>position.getX()){
            x = 1;
        } else if (other.getPosition().getX()<position.getX()){
            x=-1;
        }

        if (other.getPosition().getY()>position.getY()){
            y = 1;
        } else if (other.getPosition().getY()<position.getY()){
            y=-1;
        }
        if (x*y==1||y*y==0){
            position = new Point(position.getX()+x,position.getY()+y);
        } else {
            if (other.getPosition().getX()!=position.getX()){
                position = new Point(position.getX()+x,position.getY());

            }else {
                position = new Point(position.getX(),position.getY()+y);

            }
        }



    }

    public boolean isAlive (){
        return stamina>0 ? true : false;
    }

    public void attack (Warrior other){
        Random rnd = new Random();

        if (rnd.nextDouble()<skill){
            other.stamina -= rnd.nextInt(3)+1;
        }
    }

    @Override
    public String toString() {
        return name + ": (" + position.getX()+","+position.getY()+") "+ stamina;
    }
}
