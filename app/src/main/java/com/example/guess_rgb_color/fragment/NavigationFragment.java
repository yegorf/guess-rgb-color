package com.example.guess_rgb_color.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.guess_rgb_color.R;
import com.example.guess_rgb_color.injection.DaggerViewComponent;
import com.example.guess_rgb_color.injection.ViewComponent;
import com.example.guess_rgb_color.injection.ViewModule;
import com.example.guess_rgb_color.navigation.NavigationManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class NavigationFragment extends Fragment {

    @Inject
    NavigationManager manager;

    @OnClick(R.id.ib_game)
    void onGameClicked() {
        manager.openFragment(NavigationManager.SCREEN_GAME);
    }

    @OnClick(R.id.ib_account)
    void onAccountClicked() {
        manager.openFragment(NavigationManager.SCREEN_STATISTICS);
    }

    @OnClick(R.id.ib_info)
    void onInfoClicked() {
        manager.openFragment(NavigationManager.SCREEN_INFO);
    }

    @OnClick(R.id.ib_rgb)
    void onRgbClicked() {
        manager.openFragment(NavigationManager.SCREEN_RGB);
    }

    @OnClick(R.id.ib_settings)
    void onSettingsClicked() {
        manager.openFragment(NavigationManager.SCREEN_SETTINGS);
    }

    public static NavigationFragment getInstance() {
        return new NavigationFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        ButterKnife.bind(this, view);

        ViewComponent viewComponent = DaggerViewComponent.builder()
                .viewModule(new ViewModule(getFragmentManager()))
                .build();
        viewComponent.inject(this);

        return view;
    }
}
