package com.lucasbrandt.dailythoughtrecord.dependencyinjection;

import com.lucasbrandt.dailythoughtrecord.activities.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AndroidViewModule {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
