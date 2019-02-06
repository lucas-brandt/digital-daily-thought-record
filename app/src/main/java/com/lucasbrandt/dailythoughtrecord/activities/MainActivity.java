package com.lucasbrandt.dailythoughtrecord.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.lucasbrandt.dailythoughtrecord.R;
import com.lucasbrandt.dailythoughtrecord.databinding.ActivityMainBinding;
import com.lucasbrandt.dailythoughtrecord.viewmodels.MainViewModel;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends BaseActivity {

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(mainViewModel);
    }

    @Nullable
    @Override
    protected CompositeDisposable registerUnboundViewEvents() {
        CompositeDisposable events = new CompositeDisposable();

        return events;
    }
}
