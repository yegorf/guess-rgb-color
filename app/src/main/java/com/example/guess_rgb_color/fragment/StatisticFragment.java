package com.example.guess_rgb_color.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.guess_rgb_color.R;
import com.example.guess_rgb_color.constant.PrefConstants;
import com.example.guess_rgb_color.tools.PercentCalculator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StatisticFragment extends Fragment {

    @BindView(R.id.tv_win_count)
    TextView winCountTv;

    @BindView(R.id.tv_loose_count)
    TextView looseCountTv;

    public static StatisticFragment getInstance() {
        return new StatisticFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistic, container, false);
        ButterKnife.bind(this, view);
        initViews();
        return view;
    }

    private void initViews() {
        if (getActivity() != null) {
            SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
            int winCount = preferences.getInt(PrefConstants.WIN_SCORE, 0);
            int looseCount = preferences.getInt(PrefConstants.LOOSE_SCORE, 0);

            String win = winCount + " (" + PercentCalculator.calculateWin(winCount, looseCount) +  "%)";
            String loose = looseCount + " (" + PercentCalculator.calculateLoose(winCount, looseCount) +  "%)";

            winCountTv.setText(win);
            looseCountTv.setText(loose);
        }
    }
}
