package com.lucasbrandt.dailythoughtrecord.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class BaseActivity extends AppCompatActivity {

    private static final String ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT = "ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT";

    private final CompositeDisposable lifecycleSubscriptions = new CompositeDisposable();

    @Nullable
    protected CompositeDisposable registerUnboundViewEvents() {
        return null;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null && savedInstanceState.getBoolean(ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT, false)) {
            Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
    }

    @Override
    protected void onPause() {
        lifecycleSubscriptions.clear();
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        if(!isFinishing()) {
            outState.putBoolean(ACTIVITY_KILLED_BY_MEMORY_MANAGEMENT, true);
        }
        super.onSaveInstanceState(outState);
    }

    protected void subscribeOnLifecycle(Disposable disposable) {
        lifecycleSubscriptions.add(disposable);
    }
}
