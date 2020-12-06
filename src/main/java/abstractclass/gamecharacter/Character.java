package abstractclass.gamecharacter;

import initializer.Rate;

import java.util.Random;

public abstract class Character {

    private Point position;
    private int hitPoint;
    private Random random;

    public Character(Point position, Random random) {
        this.position = position;
        hitPoint = 100;
        this.random = random;
    }

    public Point getPosition() {
        return position;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public Random getRandom() {
        return random;
    }

    public boolean isAlive() {
        if (hitPoint > 0) {
            return true;
        } else {
            return false;
        }
    }

    protected int getActualPrimaryDamage() {
        return random.nextInt(10) + 1;
    }

    private int getActualDefence() {
        return random.nextInt(5) + 1;
    }

    protected void hit(Character enemy, int damage) {
        int defence = getActualDefence();
        if (defence < damage) {
            enemy.decreaseHitPoint(damage - defence);
        }
    }

    private void decreaseHitPoint(int diff) {
        hitPoint -= diff;
    }

    public void primaryAttack(Character enemy) {
        hit(enemy, getActualPrimaryDamage());
    }

    abstract public void secondaryAttack(Character enemy);
}
