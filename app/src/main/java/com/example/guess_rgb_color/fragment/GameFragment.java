package com.example.guess_rgb_color.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.guess_rgb_color.R;
import com.example.guess_rgb_color.constant.PrefConstants;
import com.example.guess_rgb_color.tools.Color;
import com.example.guess_rgb_color.tools.Generator;

import java.util.LinkedList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameFragment extends Fragment {

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

    private LinkedList<Button> plates = new LinkedList<>();

    public static GameFragment getInstance() {
        return new GameFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        ButterKnife.bind(this, view);

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

        return view;
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
                Toast.makeText(getContext(), getString(R.string.right_answer), Toast.LENGTH_SHORT).show();
                setData();

                if (getActivity() != null) {
                    SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                    int count = preferences.getInt(PrefConstants.WIN_SCORE, 0);
                    preferences.edit().putInt(PrefConstants.WIN_SCORE, count + 1).apply();
                }
            });
        } else {
            plate.setOnClickListener(e -> {
                Toast.makeText(getContext(), getString(R.string.wrong_answer), Toast.LENGTH_SHORT).show();
                setPlateText(plate, color);

                if (getActivity() != null) {
                    SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                    int count = preferences.getInt(PrefConstants.LOOSE_SCORE, 0);
                    preferences.edit().putInt(PrefConstants.LOOSE_SCORE, count + 1).apply();
                }
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

    private void clearPlates() {
        for (Button plate : plates) {
            plate.setText("");
        }
    }
}
