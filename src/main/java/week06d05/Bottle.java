package week06d05;

public class Bottle {
    private BottleType bottleType;
    private int filledUntil;

    public Bottle(BottleType bottleType) {
        this.bottleType = bottleType;
        filledUntil = 0;
    }

    public static Bottle of (BottleType bottleType){
        return new Bottle(bottleType);
    }

    public BottleType getBottleType() {
        return bottleType;
    }

    public int getFilledUntil() {
        return filledUntil;
    }

    public void fill (int fillAmount){
        if (filledUntil + fillAmount > bottleType.getMaximumAmount()){
            throw new IllegalStateException("The bottle is full");
        } else {
            filledUntil+=fillAmount;
        }

    }

    public static void main(String[] args) {
        Bottle glassBottle = Bottle.of(BottleType.GLASS_BOTTLE);
        Bottle petBottle = Bottle.of(BottleType.PET_BOTTLE);

        glassBottle.fill(1);
        System.out.println(glassBottle.getFilledUntil());
        petBottle.fill(50);

    }


}
