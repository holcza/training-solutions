package match;

public class Game {
    public static void main(String[] args) {
        Warrior warrior1 = new Warrior("Sárkány", new Point(4, 5));
        Warrior warrior2 = new Warrior("Lovas", new Point(10, 2));
        System.out.println(warrior1.distance(warrior2));
        int count = 1;
        do {
            System.out.println("" + count + ". round");
            count++;
            if (warrior1.getPosition().getX() == warrior2.getPosition().getX() && warrior2.getPosition().getY() == warrior1.getPosition().getY()) {
                warrior1.attack(warrior2);

            } else {
                warrior1.move(warrior2);
            }
            if (warrior1.getPosition().getX() == warrior2.getPosition().getX() && warrior2.getPosition().getY() == warrior1.getPosition().getY()) {
                warrior2.attack(warrior1);

            } else {
                warrior2.move(warrior1);
            }
            System.out.println(warrior1.toString());
            System.out.println(warrior2.toString());

        } while (warrior1.isAlive() == true && warrior2.isAlive() == true);

        String winner = warrior1.isAlive() ? warrior1.toString() : warrior2.toString();
        System.out.println("Winner: " + winner);
        System.out.println(warrior1 instanceof Warrior);
    }
}
