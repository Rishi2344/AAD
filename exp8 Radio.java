
java code :
*********************
package com.example.exp8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button but;
    RadioGroup rgroup;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but=(Button) findViewById(R.id.button);
        rgroup=(RadioGroup) findViewById(R.id.radiogrp);
        but.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                int selected=rgroup.getCheckedRadioButtonId();
                RadioButton radio=(RadioButton) findViewById(selected);
                Toast.makeText(MainActivity.this,"You selected : "+radio.getText(),Toast.LENGTH_LONG).show();
            }
        });
    }
}

xml code:
**********************
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity" >

    <RadioGroup
        android:id="@+id/radiogrp"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <TextView
            android:id="@+id/textView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Select Your Gender" />

        <RadioButton
            android:id="@+id/radiomale"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Male" />

        <RadioButton
            android:id="@+id/radiofemale"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Female" />


        <Button
            android:id="@+id/button"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="Submit" />
    </RadioGroup>
</RelativeLayout>