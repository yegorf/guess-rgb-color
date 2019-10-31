package com.example.guess_rgb_color.injection;

import androidx.fragment.app.FragmentManager;

import com.example.guess_rgb_color.navigation.NavigationManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModule {

    private FragmentManager fragmentManager;

    public ViewModule(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
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
}
