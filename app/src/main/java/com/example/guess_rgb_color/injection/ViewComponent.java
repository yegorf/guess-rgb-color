package com.example.guess_rgb_color.injection;

import com.example.guess_rgb_color.fragment.GameFragment;
import com.example.guess_rgb_color.fragment.NavigationFragment;
import com.example.guess_rgb_color.fragment.StatisticFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ViewModule.class})
public interface ViewComponent {
    void inject(NavigationFragment navigationFragment);
    void inject(StatisticFragment statisticFragment);
    void inject(GameFragment gameFragment);
}
