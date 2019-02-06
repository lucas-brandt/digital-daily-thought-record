package com.lucasbrandt.dailythoughtrecord.dependencyinjection;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Provides;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AndroidViewModule.class,
        ApplicationModule.class,
        DatabaseModule.class})

public interface ApplicationComponent extends AndroidInjector<AndroidApplication> {
}
