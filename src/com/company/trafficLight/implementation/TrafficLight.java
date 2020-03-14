package com.company.trafficLight.implementation;

import com.company.input.implementation.ButtonInput;
import com.company.output.implementation.TrafficLightOutput;
import com.company.trafficLight.interfaces.ITrafficLight;

public class TrafficLight implements ITrafficLight {

    private final String firstOption = "1";
    private final String secondOption = "2";
    private int lightsAmount;
    private boolean trafficLightState = true;
    private TrafficLightOutput trafficLightOutput;
    private ButtonInput buttonInput;

    public TrafficLight(int lightsAmount, TrafficLightOutput trafficLightOutput, ButtonInput buttonInput) {
        this.lightsAmount = lightsAmount;
        this.trafficLightOutput = trafficLightOutput;
        this.buttonInput = buttonInput;
    }

    @Override
    public void runTrafficLight() {
        while(true) {
            System.out.println("\n1-Change colors\n2-Night mode");
            String buttonPressed = buttonInput.checkButtonPressed();
            if (buttonPressed.equals(firstOption)) {
                if (trafficLightState) {
                    switchColors();
                    trafficLightState = false;
                } else {
                    reversedSwitch();
                    trafficLightState = true;
                }
            } else if (buttonPressed.equals(secondOption)) {
                nightMode();
            }
        }
    }

    @Override
    public void switchColors() {
        for (int i = 0; i < 2; i++) {
            trafficLightOutput.showTrafficLight("green");
            makeDelay(1000);
            trafficLightOutput.turnColorsOff();
            makeDelay(1000);
        }
        if (lightsAmount >= 3) {
            trafficLightOutput.showTrafficLight("yellow");
            makeDelay(1000);
        }
        trafficLightOutput.showTrafficLight("red");
    }

    @Override
    public void reversedSwitch() {
        trafficLightOutput.showTrafficLight("red");
        makeDelay(1000);
        if (lightsAmount >= 3) {
            trafficLightOutput.showTrafficLight("yellow");
            makeDelay(1000);
        }
        trafficLightOutput.showTrafficLight("green");
    }

    @Override
    public void nightMode() {
        if(lightsAmount > 2) {
            trafficLightOutput.showTrafficLight("yellow");
            makeDelay(1000);
            trafficLightOutput.turnColorsOff();
        } else {
            trafficLightOutput.turnColorsOff();
        }
    }

    private static void makeDelay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
