package solutions.week02;

import java.util.Scanner;

public class Controller {
    private Office office;

    public void readOffice(){

        office= new Office();

        Scanner scanner=new Scanner(System.in);

        System.out.println("Hány db tárgyalót szeretne rögzíteni?");

        int number = scanner.nextInt();
        scanner.nextLine();

        String name;
        int length;
        int width;

        for (int i=0;i<number;i++){
            System.out.println((i+1)+". tárgyaló neve: ");
            name=scanner.nextLine();
            System.out.println((i+1)+". tárgyaló hosszúsága: ");
            length=scanner.nextInt();
            scanner.nextLine();
            System.out.println((i+1)+". tárgyaló szélessége: ");
            width=scanner.nextInt();
            scanner.nextLine();
            MeetingRoom meetingRoom=new MeetingRoom(name,length,width);

            office.addMeetingRoom(meetingRoom);
        }
    }

    public void printMenu(){
        System.out.println("1. Tárgyalók sorrendben\n" +
                "2. Tárgyalók visszafele sorrendben\n" +
                "3. Minden második tárgyaló\n" +
                "4. Területek\n" +
                "5. Keresés pontos név alapján\n" +
                "6. Keresés névtöredék alapján\n" +
                "7. Keresés terület alapján");
    }

    public void runMenu(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("A menüpont száma, amibe be szeretne lépni: ");

        int menuNumber=scanner.nextInt();
        scanner.nextLine();

        if (menuNumber==1){
            office.printNames();
        } else {
            if (menuNumber==2){
                office.printNamesReverse();
            }else {
                if (menuNumber==3){
                    office.printEvenNames();
                } else {
                    if (menuNumber==4){
                        office.printAreas();
                    }else {
                        if (menuNumber==5){
                            System.out.println("Addja meg a tárgyaló nevét: ");
                            String name=scanner.nextLine();
                            office.printMeetingRoomsWithName(name);
                        } else {
                            if (menuNumber==6){
                                System.out.println("Addja meg a szöveget a tárgyaló nevében: ");
                                String part=scanner.nextLine();
                                office.printMeetingRoomsContains(part);
                            } else {
                                System.out.println("Addja meg a területet, aminél nagyobb tárgyalók érdeklik: ");
                                int area =scanner.nextInt();
                                scanner.nextLine();
                                office.printAreasLargerThan(area);
                            }
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Controller controller= new Controller();

        controller.readOffice();

        controller.printMenu();

        controller.runMenu();

    }
}
