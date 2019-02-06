package com.lucasbrandt.dailythoughtrecord.dependencyinjection;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import dagger.android.support.HasSupportFragmentInjector;

public class AndroidApplication extends Application implements HasActivityInjector {

    protected static ApplicationComponent component;

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidActivityInjector;

    public static ApplicationComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
       super.onCreate();
       component = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidActivityInjector;
    }
}
