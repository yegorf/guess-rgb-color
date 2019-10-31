package com.example.guess_rgb_color.injection;

import com.example.guess_rgb_color.fragment.NavigationFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ViewModule.class})
public interface ViewComponent {
    void inject(NavigationFragment navigationFragment);
}
