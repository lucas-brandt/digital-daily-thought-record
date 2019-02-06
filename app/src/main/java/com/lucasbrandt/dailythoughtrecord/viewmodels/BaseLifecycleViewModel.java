package com.lucasbrandt.dailythoughtrecord.viewmodels;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseLifecycleViewModel implements LifecycleObserver {

    private CompositeDisposable lifecycleSubscriptions = new CompositeDisposable();

    protected void subscribeOnLifecycle(Disposable disposable) {
        lifecycleSubscriptions.add(disposable);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        lifecycleSubscriptions.clear();
    }
}
