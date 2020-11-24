package methodstructure;

public class Pendrive {
    private String name;
    private int capacity;
    private int price;

    public Pendrive(String name, int capacity, int price) {
        this.name = name;
        this.capacity = capacity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pendrive{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                ", price=" + price +
                '}';
    }

    public void risePrice(int percent){
        price = (int) (price*1.0 *(1+percent*1.0/100));
    }

    public int comparePricePerCapacity (Pendrive anotherPendrive){
        if (price*0.1/capacity>anotherPendrive.getPrice()*0.1/anotherPendrive.getCapacity()){
            return 1;
        }else if (price*0.1/capacity<anotherPendrive.getPrice()*0.1/anotherPendrive.getCapacity()){
            return -1;
        }else {
            return 0;
        }
    }

    public boolean cheaperThan (Pendrive anotherPendrive){
        if (price<anotherPendrive.getPrice()){
            return true;
        } else {
            return false;
        }
    }
}
