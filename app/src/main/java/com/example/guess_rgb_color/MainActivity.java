package com.example.guess_rgb_color;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_color_rgb)
    TextView colorTv;

    @BindView(R.id.plate1)
    View plate1;

    @BindView(R.id.plate2)
    View plate2;

    @BindView(R.id.plate3)
    View plate3;

    @BindView(R.id.plate4)
    View plate4;

    @BindView(R.id.plate5)
    View plate5;

    @BindView(R.id.plate6)
    View plate6;

    @BindView(R.id.plate7)
    View plate7;

    @BindView(R.id.plate8)
    View plate8;

    @BindView(R.id.plate9)
    View plate9;

    private LinkedList<View> plates = new LinkedList<>();

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
        int answer = Generator.getPlateNum();
        boolean right;

        for (int i = 0; i < plates.size(); i++) {
            right = (answer == i);
            setPlateColor(plates.get(i), right);
        }
    }

    private void setPlateColor(View plate, boolean right) {
        Color color = Generator.generateRGB();
        plate.setBackgroundColor(android.graphics.Color.rgb(color.getR(), color.getG(), color.getB()));

        if (right) {
            colorTv.setText(color.toString());
            plate.setOnClickListener(e -> {
                Toast.makeText(this, "Right!", Toast.LENGTH_SHORT).show();
                setData();
            });
        } else {
            plate.setOnClickListener(e -> Toast.makeText(this, "Wrong!", Toast.LENGTH_SHORT).show());
        }
    }


}
