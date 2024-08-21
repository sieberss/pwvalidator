package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String password = new Scanner(System.in).nextLine();
        if (PwValidator.isValid(password)){
            System.out.println("Das Passwort erfüllt alle Bedingungen");
        }
        else {
            System.out.println("Das Passwort ist unsicher");
        }

    }
}
