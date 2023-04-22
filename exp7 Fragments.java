XML:
**************
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">
    <FrameLayout
        android:id="@+id/framelayout"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    <Button
        android:id="@+id/fragment1btn"
        android:layout_width="150dp"
        android:layout_height="60dp"
        android:backgroundTint="@color/black"
        android:text="Fragment1"
        android:layout_alignParentBottom="true"
        android:layout_marginBottom="50dp"
        android:layout_marginStart="50dp"/>
    <Button
        android:id="@+id/fragment2btn"
        android:layout_width="150dp"
        android:layout_height="60dp"
        android:backgroundTint="@color/black"
        android:text="Fragment2"
        android:layout_alignParentBottom="true"
        android:layout_alignParentRight="true"
        android:layout_marginBottom="50dp"
        android:layout_marginStart="50dp"/>
</RelativeLayout>

JAVA:
**********************
package com.example.exp7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button firstFragmentbtn,secondFragmentbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstFragmentbtn = findViewById(R.id.fragment1btn);
        secondFragmentbtn = findViewById(R.id.fragment2btn);
        firstFragmentbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                replaceFragment(new fragment1());
            }


        });
        secondFragmentbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                replaceFragment(new fragment2());
            }

        });

    }

    private void replaceFragment(Fragment fragment) {
           FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.framelayout,fragment);
            fragmentTransaction.commit();

    }
}

Fragment1.XML:
************************
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
   android:background="@color/fragment1"
    tools:context=".fragment1">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Chats"
        android:textSize="60dp"
        android:layout_centerInParent="true"
        android:textColor="@color/black"/>

</RelativeLayout>

Fragment1.java:
***********************
package com.example.exp7;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragment1 extends Fragment {
    View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       view = inflater.inflate(R.layout.fragment_fragment1, container, false);
       return view;
    }
}

Fragment2.XML:
***********************
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/fragment2"
    tools:context=".fragment2">

    <!-- TODO: Update blank fragment layout -->
    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Calls"
        android:textSize="60dp"
        android:layout_centerInParent="true"
        android:textColor="@color/black"/>
</RelativeLayout>

Fragment2.java:
*************************
package com.example.exp8;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class fragment2 extends Fragment {
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_fragment2, container, false);
        return view;
    }
}


color.xml:
*************************
<?xml version="1.0" encoding="utf-8"?>
<resources>
    
    <color name="fragment1">#49df89</color>
    <color name="fragment2">#ffbd59</color>

</resources>