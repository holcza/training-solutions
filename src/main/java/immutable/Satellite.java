package immutable;

public class Satellite {

    private String registerIdent;

    private CelestialCoordinates destinationCoordinates;

    public Satellite(String registerIdent, CelestialCoordinates destinationCoordinates) {
        this.registerIdent = registerIdent;
        this.destinationCoordinates = destinationCoordinates;
    }

    public String getRegisterIdent() {
        return registerIdent;
    }

    public CelestialCoordinates getDestinationCoordinates() {
        return destinationCoordinates;
    }

    public void modifyDestination(CelestialCoordinates diff) {
        int x = destinationCoordinates.getX() + diff.getX();
        int y = destinationCoordinates.getY() + diff.getY();
        int z = destinationCoordinates.getZ() + diff.getZ();
        destinationCoordinates = new CelestialCoordinates(x, y, z);
    }


    @Override
    public String toString() {
        return "Satellite{" +
                "registerIdent='" + registerIdent + '\'' +
                ", destinationCoordinates=" + destinationCoordinates +
                '}';
    }
}
