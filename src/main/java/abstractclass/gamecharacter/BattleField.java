package abstractclass.gamecharacter;

public class BattleField {

    private int round;

    public int getRound() {
        return round;
    }

    private boolean oneHit(Character attacker, Character defender) {
        if (attacker.isAlive() && defender.isAlive()) {
            attacker.primaryAttack(defender);
            attacker.secondaryAttack(defender);
            return true;
        } else {
            return false;
        }
    }

    public Character fight(Character one, Character other){
        Character attacher;
        Character defender;
        Character winner = null;
        do{
            if (round%2 == 1){
                attacher = one;
                defender = other;

            } else {
                attacher = other;
                defender = one;
            }

            boolean isAlive = oneHit(attacher,defender);
            if (isAlive){
            round++;}

            if (!one.isAlive()){
                winner = one;
            }
            if (!other.isAlive()){
                winner = other;
            }

        } while (one.isAlive()&&other.isAlive());

        return winner;
    }


}
