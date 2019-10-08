package com.example.guess_rgb_color;

public class Generator {
    private static final int MAX = 255;
    private static final int MAX_PLATES = 8;

    public static Color generateRGB() {
        Color color = new Color();
        color.setR((int) (Math.random() * MAX));
        color.setG((int) (Math.random() * MAX));
        color.setB((int) (Math.random() * MAX));
        return color;
    }

    public static int getPlateNum() {
        return (int) (Math.random() * MAX_PLATES);
    }
}
