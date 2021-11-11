package com.company;
import java.lang.String;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static boolean checker = true;
    public static boolean boolForFirstDo = true;
    public static boolean boolForSecondDo = true;

    public static void Menu() {
        System.out.println("1) Enter cash");
        System.out.println("2) Withdraw cash");
        System.out.println("3) Balance");
        System.out.print("Please enter number: ");
    }

    public static void Choice() {
        System.out.print("Would you want continue ? Please enter (Y/N): ");
        Scanner yesOno = new Scanner(System.in);
        String yesOrNo = yesOno.nextLine();

        if (Objects.equals(yesOrNo, "Y") || Objects.equals(yesOrNo, "y")) {
            Menu();
            checker = false;
        }
        else if (Objects.equals(yesOrNo, "N") || Objects.equals(yesOrNo, "n")) {
            System.out.println("Have a good day!");
            checker = true;
        }
        else {
            System.out.println("Error enter!");
            Choice();
        }
    }

    public static void main(String[] args) {
        int balance = 1000;

        Menu();
        Scanner choice = new Scanner(System.in);
        do {
            do {
                switch (choice.nextLine()) {
                    case "1" -> {
                        System.out.print("How many cash you want enter: ");
                        Scanner cashEnter = new Scanner(System.in);
                        balance += cashEnter.nextInt();
                        System.out.println("Your balance now: " + balance);
                        Choice();
                        if (!checker) {
                            boolForFirstDo = false;
                            boolForSecondDo = false;
                        }
                    }
                    case "2" -> {
                        System.out.print("How many cash you want: ");
                        Scanner cashEnter = new Scanner(System.in);
                        int withDraw = cashEnter.nextInt();
                        if (balance - withDraw < 0)
                        {
                            System.out.println("You don't have " + withDraw + " in your balance");
                        }
                        else {
                            balance -= withDraw;
                            System.out.println("Your balance: " + balance);
                        }
                        Choice();
                        if (!checker) {
                            boolForFirstDo = false;
                            boolForSecondDo = false;
                        }
                    }
                    case "3" -> {
                        System.out.println("Your balance: " + balance);
                        Choice();
                        if (!checker) {
                            boolForFirstDo = false;
                            boolForSecondDo = false;
                        }
                    }
                    default -> {
                        System.out.print("Please enter valid number: ");
                        boolForFirstDo = false;
                    }
                }
            } while (!boolForFirstDo);
        } while (!boolForSecondDo);
    }
}
