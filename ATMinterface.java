import java.util.*;

public class ATMinterface {
    Scanner sc = new Scanner(System.in);
    int id = 7654;
    int pin = 1567;
    double amount = 0;
    int withdrawlAmount;
    int depositAmount, transaction, transferAmount, transferred;
    int Account;
    double balance;

    void login() {

        System.out.println("\t___welcome___");

        System.out.println("Please enter the details : ");

        // taking user id
        System.out.print("Enter your id :  ");
        id = sc.nextInt();

        // taking user pin
        System.out.print("Enter your pin : ");
        pin = sc.nextInt();

        if (id == 7654 && pin == 1567) {
            System.out.println("Login Successfully");
            menu();
        } else {
            System.out.println("Login failed, try again!!");
            login();
        }
    }

    void menu() {
        int ch;

        do {
            System.out.println(
                    "\nSelect your choice: \n1.Transaction history \n2.Withdraw \n3.Deposit \n4.Transfer \n5.Check balance \n6.Quit");
            System.out.println("\nEnter choice:");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    Transactionhistory();
                    break;
                case 2:
                    Withdrawl();
                    break;
                case 3:
                    Deposit();
                    break;
                case 4:
                    Transfer();
                    break;
                case 5:
                    viewBalance();
                    break;
                case 6:
                    quit();
                    break;
                default:
                    System.out.println("Enter valid choice");
                    break;
            }
        } while (ch <= 6);
    }

    // view transaction history
    void Transactionhistory() {
        if (transaction == 1)
            System.out.println("You deposited Rs." + depositAmount);
        else if (transaction == -1)
            System.out.println("You withdrawn Rs." + withdrawlAmount);
        else
            System.out.println("You have not done any transaction yet");

    }

    // withdrawing money
    void Withdrawl() {
        System.out.print("Enter withdraw Amount:");
        withdrawlAmount = sc.nextInt();

        System.out.println("Withdrawl successfully");

        transaction = -1;
    }

    // deposit money
    void Deposit() {
        System.out.print("Enter deposit Amount:");
        depositAmount = sc.nextInt();
        System.out.println("Deposit Sccessfully");
        transaction = 1;
    }

    // transferring money
    void Transfer() {
        System.out.print("Enter transfer amount:");
        transferAmount = sc.nextInt();
        System.out.print("Enter a account number of Beneficiary :");
        Account = sc.nextInt();
        if (transferAmount > balance) {
            System.out.println("Insufficient money to transfer..");
        } else {
            System.out.println("Transfer Successfully");
            transferred = transferAmount;
        }
    }

    // viewing balance
    void viewBalance() {
        balance = (amount - (withdrawlAmount + transferred)) + depositAmount;
        System.out.println("Amount available:" + balance);

    }

    // quit
    void quit() {
        System.out.println("Thank you.");
        System.exit(0);

    }

    public static void main(String[] args) {
        ATMinterface s1 = new ATMinterface();
        s1.login();
    }
}