package com.example.guess_rgb_color.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.guess_rgb_color.R;

import butterknife.OnClick;

public class NavigationFragment extends Fragment {

    @OnClick(R.id.ib_game)
    void onGameClicked() {

    }

    @OnClick(R.id.ib_account)
    void onAccountClicked() {

    }

    @OnClick(R.id.ib_info)
    void onInfoClicked() {

    }

    public static NavigationFragment getInstance() {
        return new NavigationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        return view;
    }
}
