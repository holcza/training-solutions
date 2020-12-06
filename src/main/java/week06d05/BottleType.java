package week06d05;

public enum BottleType {
    GLASS_BOTTLE (10), PET_BOTTLE(5);

    private int maximumAmount;

    BottleType(int maximumAmount) {
        this.maximumAmount = maximumAmount;
    }

    public int getMaximumAmount() {
        return maximumAmount;
    }
}
