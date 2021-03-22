package csci2081.L2;

import java.util.Scanner;

public class BankAccount {

    // initialize variables:
    private String name;
    private String password;
    private double balance;

    // constructor:
    public BankAccount(String name, String password, double balance){
        this.balance = balance;
        this.name = name;
        this.password = password;
    }

    // getters (there is no getter for the password):
    public String getName(){return name;}

    public double getBalance(String password){
        if(this.password.equals(password)){
            return balance;
        }
        else{
            return -1;
        }
    }


    // setters:
    public void setName(String name){this.name = name;}
    public void changePassword(String currentPassword,String newPassword){
        if(!currentPassword.equals(newPassword)){
            password = newPassword;
        }
        else{ System.out.println("Wrong password");
        }
    }
    public void withdraw(String enteredPassword, double amount){
        if(!password.equals(enteredPassword)){
            System.out.println("Wrong password");
        }
        else if(amount > balance){
            System.out.println("Insufficient funds");
        }
        else{
            balance -= amount;
        }
    }
    public void deposit(String enteredPassword, double amount) {
        if (!password.equals(enteredPassword)) {
            System.out.println("Wrong password");
        }
        else if(amount < 0){
            System.out.println("Error: cannot deposit negative amount");
        }
        else{
            balance += amount;
        }
    }

    // testing main method:
    public static void main(String args[]){
        BankAccount b1 = new BankAccount("Daniel","Password",200.0);

        Scanner scnr = new Scanner(System.in);
        System.out.println("enter your password");
        String input = scnr.nextLine();
        String pass = input;
        System.out.println("what do you want to do?: ");
        input = scnr.next();

        if(input.equals("withdraw")){
            double amount = scnr.nextDouble();
            b1.withdraw(pass,amount);
        }
        else if(input.equals("deposit")){
            double amount = scnr.nextDouble();
            b1.deposit(pass,amount);
        }
        else if(input.equals("getBalance")){
            System.out.println("your balance is: " + b1.getBalance(pass));
            return;
        }
        else{
            System.out.println("didn't understand command");
        }
    }
}
