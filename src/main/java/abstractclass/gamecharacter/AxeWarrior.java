package abstractclass.gamecharacter;

import java.util.Random;

public class AxeWarrior extends Character {


    public AxeWarrior(Point position, Random random) {
        super(position, random);
    }

    protected int getActualSecondaryDamage() {
        return super.getRandom().nextInt(getActualPrimaryDamage() * 2) + 1;
    }

    @Override
    public void secondaryAttack(Character enemy) {
        if (super.getPosition().distance(enemy.getPosition()) < 2) {
            super.hit(enemy, getActualSecondaryDamage());
        }
    }
}
