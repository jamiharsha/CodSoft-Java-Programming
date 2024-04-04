import java.util.Scanner;

class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("Welcome to the ATM");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    public void withdraw(double amount) {
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful. Remaining balance: $" + account.getBalance());
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    public void deposit(double amount) {
        account.deposit(amount);
        System.out.println("Deposit successful. Current balance: $" + account.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: $" + account.getBalance());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);

        int choice;
        do {
            atm.displayOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
