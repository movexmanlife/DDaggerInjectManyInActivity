package com.robot.ddagger.component;

import android.content.Context;

import com.robot.ddagger.App;
import com.robot.ddagger.bean.Student;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private static int count = 0;
    private App app;
    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    Student providerStudent() {
        return new Student(23, "jack" + String.valueOf(count++));
    }

    @Provides
    @Singleton
    Context providerApplicationContext() {
        return app.getApplicationContext();
    }
}
