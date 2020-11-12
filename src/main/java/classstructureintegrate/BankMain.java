package classstructureintegrate;

public class BankMain {
    public static void main(String[] args) {
        BankAccount bankAccount1=new BankAccount("11111111-11111111-11111111","Kiss László",1000000);
        BankAccount bankAccount2=new BankAccount("11111111-11111111-00000000","Nagy Tibor",500000);

        bankAccount1.deposit(10000);
        bankAccount2.withdraw(20000);
        bankAccount1.transfer(bankAccount2,500000);
        System.out.println(bankAccount1.getInfo());
        System.out.println(bankAccount2.getInfo());

    }
}
