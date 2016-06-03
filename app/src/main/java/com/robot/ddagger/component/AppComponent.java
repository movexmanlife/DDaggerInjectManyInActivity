package com.robot.ddagger.component;

import android.content.Context;

import com.robot.ddagger.bean.Student;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getApplicationContext();
    Student getStudent();
}
