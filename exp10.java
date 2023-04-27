activity.xml:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">


    <EditText
       android:id="@+id/username"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Username"
       android:layout_marginTop="50dp"/>
   <EditText
       android:id="@+id/password"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:hint="password"
       android:layout_marginTop="50dp"
       android:layout_below="@id/username"/>
   <EditText
       android:id="@+id/repassword"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:hint="Retype password"
       android:layout_marginTop="50dp"
       android:layout_below="@id/password"/>
   <Button
       android:id="@+id/btnsignup"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
      android:text="Register"
       android:layout_marginTop="50dp"
       android:layout_below="@id/repassword"/>
   <Button
       android:id="@+id/btnsignin"
       android:layout_width="wrap_content"
       android:layout_height="wrap_content"
       android:text="Existing user"
       android:layout_marginTop="50dp"
       android:layout_below="@id/btnsignup"/>


</RelativeLayout>

MainActivity:
package com.example.myapplication12345;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText username,password,repassword;
     Button signin,signup;
     DBhelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.username);
        password=(EditText) findViewById(R.id.password);
        repassword=(EditText) findViewById(R.id.repassword);
        signin=(Button) findViewById(R.id.btnsignin);
        signup=(Button) findViewById(R.id.btnsignup);
        DB=new DBhelper(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user=username.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();
                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText( MainActivity.this, "Enter the fields",Toast.LENGTH_SHORT).show();
                else
                {
                    if(pass.equals(repass))
                    {
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false)
                        {
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true)
                            {
                                Toast.makeText( MainActivity.this,"Register successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                                startActivity(intent);
                            }
                            else
                            {

                                Toast.makeText(MainActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(MainActivity.this, "User Already exists", Toast.LENGTH_SHORT).show();

                        }
                    }
                    else {
                        Toast.makeText(MainActivity.this, "password not matching", Toast.LENGTH_SHORT).show();

                    }
                }

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);

            }
        });


    }
}

DBHelper:
package com.example.myapplication12345;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
class DBhelper extends SQLiteOpenHelper {
    public static final String DBNAME = "Login.db";

    public DBhelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create table users(username TEXT primary key,password TEXT)");
    }

    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists users");
    }

    public boolean insertData(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if (result == 1)
            return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username=?", new String[]{username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("select * from users where username=? and password=?", new String[]{username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }
}
 loginactivity.xml:
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="10dp"
    tools:context=".LoginActivity">

    <EditText
        android:id="@+id/username1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="User name"
        android:layout_marginTop="50dp"/>
    <EditText
        android:id="@+id/password1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="password"
        android:layout_marginTop="50dp"
        android:layout_below="@id/username1"/>
    <Button
        android:id="@+id/btnsignin1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:hint="Sign in"
        android:layout_marginTop="50dp"
        android:layout_below="@id/password1"/>

</RelativeLayout>

login .java:
package com.example.myapplication12345;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText username,password;
Button btnlogin;
DBhelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=(EditText) findViewById(R.id.username1);
        password=(EditText) findViewById(R.id.password1);
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        DB=new DBhelper(this);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("") || pass.equals(""))

                    Toast.makeText(LoginActivity.this, "Enter the fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if (checkuserpass == true)
                    {
                        Toast.makeText(LoginActivity.this, "Sign in successfully", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
                        startActivity(intent);

                    }
                    else
                    {
                        Toast.makeText(LoginActivity.this, "Invalid login details", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
homeactivity.xml:
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".HomeActivity">

</androidx.constraintlayout.widget.ConstraintLayout>
home.java:
package com.example.myapplication12345;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
}