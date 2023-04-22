Java:
*********************
package com.example.exp6;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Scanner;
public class MainActivity extends AppCompatActivity {
    Button sendsms;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendsms = findViewById(R.id.button);
        sendsms.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                Intent it = new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms","0123456789",null));
                it.putExtra("Message","Hello..!, How are you ?");
                startActivity(it);
            }
        });
    }
}


XML:
******************************
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_gravity="center"
    android:gravity="center"
    tools:context=".MainActivity">
    <Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:text="Send SMS" />
</LinearLayout>