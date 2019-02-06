package com.lucasbrandt.dailythoughtrecord.dependencyinjection;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.*;

@Qualifier
@Retention(RUNTIME)
public @interface IoScheduler {
}
