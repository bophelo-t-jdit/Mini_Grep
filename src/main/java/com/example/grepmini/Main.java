package com.example.grepmini;

import com.example.grepmini.app.App;

public class Main {
    public String process(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        return input.toUpperCase();
    }

    public boolean isValidLength(String input) {
        if (input == null) {
            return false;
        }
        return input.trim().length() >= 3;
    }

    public boolean isBlank(String input) {
        if (input == null) {
            return false;
        }
        return input.trim().isEmpty();
    }

    static void main(String[] args) {
        App app = new App();
        System.out.println("\nApp has started!");
        System.out.println("\nType ming help for instructions");

        // Access the App.java start() function
        app.start();
    }
}
