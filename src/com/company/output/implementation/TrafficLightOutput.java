package com.company.output.implementation;

import com.company.output.interfaces.IOutput;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class TrafficLightOutput implements IOutput {

    public final String ANSI_RESET = "\u001B[0m";
    public final String ANSI_RED = "\u001B[31m";
    public final String ANSI_GREEN = "\u001B[32m";
    public final String ANSI_YELLOW = "\u001B[33m";

    private int lightsAmount;

    public TrafficLightOutput(int lightsAmount) {
        this.lightsAmount = lightsAmount;
    }

    @Override
    public void showTrafficLight(String color) {

        String dot = "⬤";
        String dot2 = "⬤";

        if (lightsAmount == 2) {
            dot2 = "";
        }

        Writer writer = new PrintWriter(System.out);

        try {
            String str = "⬤";
            writer.write(str);
            writer.flush();

            switch (color) {
                case ("green"):
                    writer.write("\r" + ANSI_GREEN + "⬤" + ANSI_RESET + dot + dot2);
                    break;
                case ("yellow"):
                    writer.write("\r" + "⬤" + ANSI_YELLOW + "⬤" + ANSI_RESET + "⬤");
                    break;
                case ("red"):
                    writer.write("\r" + dot + dot2 + ANSI_RED + "⬤" + ANSI_RESET);
                    break;
                case ("off"):
                    writer.write("\r" + "⬤⬤" + dot2 + ANSI_RESET);
                    break;
            }

            writer.flush();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void turnColorsOff() {
        showTrafficLight("off");
    }
}
