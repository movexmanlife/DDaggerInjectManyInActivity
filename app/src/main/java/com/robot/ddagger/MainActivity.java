package com.robot.ddagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.robot.ddagger.bean.ConstructorView;
import com.robot.ddagger.bean.Student;
import com.robot.ddagger.constructorcomponent.ConstructorModule;
import com.robot.ddagger.constructorcomponent.DaggerConstructorComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    Button btn;
    Button btn2;
    /**
     * @Inject
     * ConstructorView constructorView;
     * 会生成对应的MainActivity_MembersInjector，而这里有一个@Inject，那么MainActivity_MembersInjector会传入一个参数
     */
    @Inject
    ConstructorView constructorView;
    /**
     * @Inject
     * Student student;
     * 也会生成对应的MainActivity_MembersInjector，那么MainActivity_MembersInjector此时就有两个参数了。
     */
    @Inject
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);

        /**
         * 这里不会出现错误的原因就是因为，这个地方只需要Student的依赖并不需要MainActivity。
         * 也就是传入两个参数进行调用MainActivity_MembersInjector都不会为空。
         */
        DaggerConstructorComponent.builder().appComponent(((App) getApplication()).getAppComponent()).constructorModule(new ConstructorModule()).build().inject(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
    }

    private void test() {
        Student student = constructorView.getStudent();
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }

    private void test2() {
        constructorView.showInfo();
    }

}
