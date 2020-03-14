package com.company.input.implementation;

import com.company.input.interfaces.IInput;
import java.util.Scanner;

public class ButtonInput implements IInput {

    @Override
    public String checkButtonPressed() {
        Scanner keyboard = new Scanner(System.in);
        String keyPressed = null;
        while (keyboard.hasNextLine()) {
            String input = keyboard.nextLine();
            if(input != null) {
                if ("1".equals(input) | "2".equals(input) | "".equals(input)) {
                    keyPressed = input;
                    return keyPressed;
                } else {
                    System.out.println("Select the option");
                }
            }
        }
        keyboard.close();
        return keyPressed;
    }
}
