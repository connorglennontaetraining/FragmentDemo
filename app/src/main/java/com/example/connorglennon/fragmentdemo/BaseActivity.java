/*
 * Copyright (c) 2017. Connor Glennon for The App Experts
 */

package com.example.connorglennon.fragmentdemo;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.connorglennon.fragmentdemo.fragments.FirstFragment;
import com.example.connorglennon.fragmentdemo.fragments.SecondFragment;

/**
 * Activity that controls the fragments.
 */
public class BaseActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        fragmentManager = getSupportFragmentManager();
        button = (Button) findViewById(R.id.btnNews);

        if(savedInstanceState == null)
        {
            fragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, new FirstFragment()).commit();
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, new SecondFragment()).commit();
            }
        });
    }
}
