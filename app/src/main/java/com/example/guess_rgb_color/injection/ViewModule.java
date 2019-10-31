package com.example.guess_rgb_color.injection;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.FragmentManager;

import com.example.guess_rgb_color.navigation.NavigationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    private FragmentManager fragmentManager;
    private Activity activity;

    public ViewModule(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public ViewModule(Activity activity) {
        this.activity = activity;
    }

    @Singleton
    @Provides
    public Activity provideActivity() {
        return activity;
    }

    @Singleton
    @Provides
    public FragmentManager provideFragmentManager() {
        return fragmentManager;
    }

    @Singleton
    @Provides
    public NavigationManager provideNavigationManager(FragmentManager fragmentManager) {
        return new NavigationManager(fragmentManager);
    }

    @Singleton
    @Provides
    public SharedPreferences povideSharedPreferences(Activity activity) {
        return activity.getPreferences(Context.MODE_PRIVATE);
    }
}
