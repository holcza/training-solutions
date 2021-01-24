package week12d04;

import java.util.*;

public class Clients {

    Map<String,Client> clients = new HashMap<>();

    public void addClient (String name, String regNumber){
        clients.put(regNumber,new Client(name,regNumber));
    }

    public Client findByRegNumber(String regNumber){
        if (!clients.containsKey(regNumber)){
            throw new IllegalArgumentException("Does not include registration number");
        }
        return clients.get(regNumber);
    }

    public List<Client> findByName(String name){
        List<Client> filteredClients = new ArrayList<>();
        for (Client c: clients.values() ){
            if (c.getName().contains(name)){
                filteredClients.add(c);
            }
        }
        return filteredClients;
    }


    public static void main(String[] args) {
        Clients clients = new Clients();
        clients.addClient("Lilla","1");
        clients.addClient("Otto","2");
        clients.addClient("Lillianna","3");
        System.out.println(clients.findByName("Lil").get(0).getName());
        System.out.println(clients.findByName("Lil").get(1).getName());
        System.out.println(clients.findByRegNumber("2").getName());
    }
}
