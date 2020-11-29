package methodpass;

public class Trooper {

    private String name;
    private Position position;

    public Trooper(String name) {
        isEmpty(name);
        this.name = name;
        position = new Position(0,0);
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public void changePosition(Position target) {
        isNull(target);

        position = target;
    }

    public double distanceFrom(Position target) {
        isNull(target);

        return position.distanceFrom(target);
    }

    private void isEmpty(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("Name must not be empty.");
        }
    }

    private void isNull(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("");
        }
    }
}
