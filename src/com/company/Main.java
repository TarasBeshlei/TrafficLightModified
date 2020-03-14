package com.company;

import com.company.input.implementation.ButtonInput;
import com.company.output.implementation.TrafficLightOutput;
import com.company.trafficLight.implementation.TrafficLight;

public class Main {

    private static final String firstOption = "1";
    private static final String secondOption = "2";

    public static void main(String[] args) {

        ButtonInput buttonInput = new ButtonInput();
        System.out.println("1- 3 colors\n2- 2 colors");
        String buttonPressed = buttonInput.checkButtonPressed();

        if(buttonPressed.equals(firstOption)) {
            TrafficLightOutput trafficLightOutput = new TrafficLightOutput(3);
            TrafficLight trafficLight = new TrafficLight(3, trafficLightOutput, buttonInput);
            trafficLight.runTrafficLight();
        } else if (buttonPressed.equals(secondOption)) {
            TrafficLightOutput trafficLightOutput = new TrafficLightOutput(2);
            TrafficLight trafficLight = new TrafficLight(2, trafficLightOutput, buttonInput);
            trafficLight.runTrafficLight();
        }
    }
}
