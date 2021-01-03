package ioreadwritebytes;

public class Temperatures {
    private byte[] data;

    public Temperatures(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return data;
    }

    public double getYearAverage() {
        double sum = 0;
        for (byte d : data) {
            sum+=d;
        }
        double average = data.length ==0 ? 0 : sum/data.length;
        return average;
    }

    public double getMonthAverage() {
        double sum = 0;
        for (int i = 0; i < 30 ; i++){
            sum += data[data.length-1-i];
        }
        double average = sum/30;
        return average;
    }
}
