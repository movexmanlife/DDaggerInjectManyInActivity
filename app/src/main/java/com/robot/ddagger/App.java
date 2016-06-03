package com.robot.ddagger;

import android.app.Application;

import com.robot.ddagger.component.AppComponent;
import com.robot.ddagger.component.AppModule;
import com.robot.ddagger.component.DaggerAppComponent;

public class App extends Application {
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
