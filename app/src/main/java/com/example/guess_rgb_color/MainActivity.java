package com.example.guess_rgb_color;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_color_rgb)
    TextView colorTv;

    @BindView(R.id.plate1)
    Button plate1;

    @BindView(R.id.plate2)
    Button plate2;

    @BindView(R.id.plate3)
    Button plate3;

    @BindView(R.id.plate4)
    Button plate4;

    @BindView(R.id.plate5)
    Button plate5;

    @BindView(R.id.plate6)
    Button plate6;

    @BindView(R.id.plate7)
    Button plate7;

    @BindView(R.id.plate8)
    Button plate8;

    @BindView(R.id.plate9)
    Button plate9;

    private static LinkedList<Button> plates = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        plates.add(plate1);
        plates.add(plate2);
        plates.add(plate3);
        plates.add(plate4);
        plates.add(plate5);
        plates.add(plate6);
        plates.add(plate7);
        plates.add(plate8);
        plates.add(plate9);

        setData();
    }

    private void setData() {
        clearPlates();
        int answer = Generator.getPlateNum();
        boolean right;

        for (int i = 0; i < plates.size(); i++) {
            right = (answer == i);
            setPlateColor(plates.get(i), right);
        }
    }

    private void setPlateColor(Button plate, boolean right) {
        Color color = Generator.generateRGB();
        plate.setBackgroundColor(android.graphics.Color.rgb(color.getR(), color.getG(), color.getB()));

        if (right) {
            colorTv.setText(color.toString());
            plate.setOnClickListener(e -> {
                Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
                setData();
            });
        } else {
            plate.setOnClickListener(e -> {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show();
                setPlateText(plate, color);
            });
        }
    }

    private static void setPlateText(Button plate, Color color) {
        plate.setTextSize(10);
        int r = Math.abs(255 - color.getR());
        int g = Math.abs(255 - color.getG());
        int b = Math.abs(255 - color.getB());
        plate.setTextColor(android.graphics.Color.rgb(r, g, b));
        plate.setText(color.toString());
    }

    public static void clearPlates() {
        for (Button plate : plates) {
            plate.setText("");
        }
    }
}
