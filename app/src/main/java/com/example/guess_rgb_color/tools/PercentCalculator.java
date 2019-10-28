package com.example.guess_rgb_color.tools;

import java.text.DecimalFormat;

public class PercentCalculator {

    public static String calculateWin(int win, int loose) {
        double percent = (((double)win / (double)(win + loose)) * 100);
        return  round(percent);
    }

    public static String calculateLoose(int win, int loose) {
        double percent = (((double)loose / (double)(win + loose)) * 100);
        return round(percent);
    }

    private static String round(double number) {
        DecimalFormat format = new DecimalFormat("##.00");
        return format.format(number);
    }
}
