package solutions.classstructuremethods;

public class ClientMain {
    public static void main(String[] args) {
        Client client=new Client();
        client.setName("Kata");
        client.setAddress("Budapest");
        client.setYear(1990);
        System.out.println(client.getName()+" , "+client.getAddress()+" , "+client.getYear());
        client.migrate("Győr");
        System.out.println(client.getAddress());
    }
}
