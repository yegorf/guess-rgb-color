package com.example.guess_rgb_color.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.guess_rgb_color.R;
import com.skydoves.colorpickerpreference.ColorPickerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RgbFragment extends Fragment {

    @BindView(R.id.v_color_picker)
    ColorPickerView colorPickerView;

    @BindView(R.id.tv_rgb_code)
    TextView colorTv;

    @BindView(R.id.v_color_code)
    LinearLayout colorView;

    @OnClick(R.id.ib_copy)
    void onCopyClicked() {
        ClipboardManager clipboard = (ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("", colorTv.getText());
        clipboard.setPrimaryClip(clip);
        Toast.makeText(getContext(),
                getContext().getString(R.string.copied_to_buffer),
                Toast.LENGTH_SHORT).show();
    }

    public static RgbFragment getInstance() {
        return new RgbFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rgb, container, false);
        ButterKnife.bind(this, view);

        colorPickerView.setColorListener(colorEnvelope -> {
            int[] colorArray = colorEnvelope.getColorRGB();
            String color = String.format("%d, %d, %d", colorArray[0], colorArray[1], colorArray[2]);
            colorTv.setText(color);
            colorTv.setTextColor(android.graphics.Color.rgb(
                    (255 - colorArray[0]),
                    (255 - colorArray[1]),
                    (255 - colorArray[2]))
            );
            colorView.setBackgroundColor(android.graphics.Color.rgb(colorArray[0], colorArray[1], colorArray[2]));
        });

        return view;
    }
}
