public class ATM {
    int balance = 1000;
    String username = "kobe";
    int password = 2408;

    int withdraw(int amount){
        balance -= amount;
        System.out.println("Withdraw done! New balance: " + balance);
        return balance;
    }

    int deposit(int amount){
        balance += amount;
        System.out.println("Deposit done! New balance: " + balance);
        return balance;
    }

    boolean isDividerOfBalance(int value){
        System.out.println(balance + " / " + value);
        return balance % value == 0;
    }

    boolean loginCheck(String username1, int password1){
        return username1.equals(username) && password1 == password;
    }


    public static void main(String[] args) {
        ATM atm = new ATM();
        int x = 50;

        System.out.println("deposit: " + x + ", New balance: " + atm.deposit(x));
    }
}
