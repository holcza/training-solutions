package consoleselection.greetings;

public class Greetings {
    public void greetings(int hour, int minute) {
        int timeInMinute = 60 * hour + minute;

        if (timeInMinute < 5 * 60) {
            System.out.println("Jó éjt!");
        } else if (timeInMinute < 9 * 60) {
            System.out.println("Jó reggelt!");
        } else if (timeInMinute < 18 * 60 + 30) {
            System.out.println("Jó napot!");
        } else if (timeInMinute < 20 * 60) {
            System.out.println("Jó estét!");
        } else {
            System.out.println("jó éjt!");
        }
    }

    public static void main(String[] args) {
        Greetings greetings=new Greetings();
        greetings.greetings(4,20);
        greetings.greetings(6,20);
        greetings.greetings(10,20);
        greetings.greetings(19,20);
        greetings.greetings(21,20);
    }
}
