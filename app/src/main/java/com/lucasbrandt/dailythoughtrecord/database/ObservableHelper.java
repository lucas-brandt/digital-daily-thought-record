package com.lucasbrandt.dailythoughtrecord.database;

import com.lucasbrandt.dailythoughtrecord.dependencyinjection.IoScheduler;
import com.lucasbrandt.dailythoughtrecord.dependencyinjection.MainThreadScheduler;

import javax.inject.Inject;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;

public class ObservableHelper {

    private final Scheduler ioScheduler;
    private final Scheduler mainThreadScheduler;

    @Inject
    public ObservableHelper(@IoScheduler Scheduler ioScheduler, @MainThreadScheduler Scheduler mainThreadScheduler) {
        this.ioScheduler = ioScheduler;
        this.mainThreadScheduler = mainThreadScheduler;
    }

    public <T> ObservableTransformer<T, T> applyObservableSchedulers() {
        return observable -> observable.subscribeOn(ioScheduler).observeOn(mainThreadScheduler);
    }

    public <T> SingleTransformer<T, T> applySingleSchedulers() {
        return observable -> observable.subscribeOn(ioScheduler).observeOn(mainThreadScheduler);
    }
}
