package com.example.guess_rgb_color.navigation;

import android.app.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.guess_rgb_color.R;
import com.example.guess_rgb_color.fragment.GameFragment;
import com.example.guess_rgb_color.fragment.InfoFragment;
import com.example.guess_rgb_color.fragment.RgbFragment;
import com.example.guess_rgb_color.fragment.SettingsFragment;
import com.example.guess_rgb_color.fragment.StatisticFragment;

public class NavigationManager {
    private static String currentFragment;
    public static final String SCREEN_GAME = "SCREEN_GAME";
    public static final String SCREEN_STATISTICS = "SCREEN_STATISTICS";
    public static final String SCREEN_INFO = "SCREEN_INFO";
    public static final String SCREEN_RGB = "SCREEN_RGB";
    public static final String SCREEN_SETTINGS = "SCREEN_SETTINGS";
    private FragmentManager fragmentManager;

    public NavigationManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void openFragment(String screenName) {
        Fragment fragment = getFragmentForScreen(screenName);
        if (fragment != null) {
            open(fragment, screenName);
            currentFragment = screenName;
        }
    }

    private void open(Fragment fragment, String screenName) {
        if (fragmentManager != null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(screenName)
                    .commit();
        }
    }

    private Fragment getFragmentForScreen(String screenName) {
        switch (screenName) {
            case SCREEN_GAME:
                return GameFragment.getInstance();
            case SCREEN_STATISTICS:
                return StatisticFragment.getInstance();
            case SCREEN_INFO:
                return InfoFragment.getInstance();
            case SCREEN_RGB:
                return RgbFragment.getInstance();
            case SCREEN_SETTINGS:
                return SettingsFragment.getInstance();
            default:
                return null;
        }
    }
    public void navigateBack(Activity activity) {
        if (currentFragment.equals(SCREEN_GAME)) {
            activity.finish();
        } else {
            openFragment(SCREEN_GAME);
        }
    }
}
