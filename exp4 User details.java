Java:
***************
package com.example.exp4;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    Button mButton;
    EditText mEdit;
    TextView mText;
    Spinner sp;
    RadioGroup rb;
    String[] country = { "Andhra Pradesh","Telangana","Madhya Pradesh","Gujarat","Goa","TamilNadu","Karnataka","Delhi" };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spin = (Spinner) findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,country);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);
        mButton = (Button) findViewById(R.id.button1);
        mButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                String s="";
                mEdit = (EditText) findViewById(R.id.editText1);
                s+="Hello " + mEdit.getText().toString() + "!\n";
                mEdit = (EditText) findViewById(R.id.editText3);
                s+="Address "+mEdit.getText().toString()+"\n";
                rb = (RadioGroup) findViewById(R.id.r);
                int d = rb.getCheckedRadioButtonId();
                RadioButton x;
                x = (RadioButton)findViewById(d);
                s+="Gender "+x.getText().toString()+"\n";
                mEdit = (EditText) findViewById(R.id.editTextDate2);
                s+="Date of birth "+mEdit.getText().toString()+"\n";
                mEdit = (EditText) findViewById(R.id.editText4);
                s+="Age "+mEdit.getText().toString()+"\n";
                sp = (Spinner) findViewById(R.id.spinner);
                s+="State "+sp.getSelectedItem().toString()+"\n";
                mText = (TextView) findViewById(R.id.textView1);
                mText.setText(s);
            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Toast.makeText(getApplicationContext(), country[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
// TODO Auto-generated method stub
    }
}


XML:
*******************************

<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:layout_margin="5dp">
    <TextView
        android:id="@+id/textView1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentTop="true"
        android:layout_centerHorizontal="true"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#A4C639" />
    <!-- User name-->
    <TextView
        android:id="@+id/textView2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView1"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="23dp"
        android:text="User Name"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <EditText
        android:id="@+id/editText1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView2"
        android:layout_toRightOf="@+id/textView2"
        android:background="#CCCCCC"
        android:ems="10"
        android:inputType="textPersonName">
        <requestFocus />
    </EditText>
    <!--password-->
    <TextView
        android:id="@+id/textView3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView2"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="23dp"
        android:text="Password"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <EditText
        android:id="@+id/editText2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView3"
        android:layout_toRightOf="@+id/textView3"
        android:background="#CCCCCC"
        android:ems="10"
        android:inputType="textPassword">
        <requestFocus />
    </EditText>
    <!--address-->
    <TextView
        android:id="@+id/textView4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView3"
        android:layout_alignParentLeft="true"

        android:layout_marginTop="23dp"
        android:text="Address"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <EditText
        android:id="@+id/editText3"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView4"
        android:layout_toRightOf="@+id/textView4"
        android:background="#CCCCCC"
        android:ems="10"
        android:inputType="textPersonName">
        <requestFocus />
    </EditText>
    <!--Gender-->
    <TextView
        android:id="@+id/textView5"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView4"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="23dp"
        android:text="Gender"
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <RadioGroup
        android:id="@+id/r"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView5"
        android:layout_toRightOf="@+id/textView5"
        android:orientation="horizontal">
        <RadioButton
            android:id="@+id/radioButton1"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignBottom="@+id/textView5"
            android:layout_toRightOf="@+id/textView4"
            android:text="Male" />
        <RadioButton
            android:id="@+id/radioButton2"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_alignBottom="@+id/radioButton1"
            android:layout_toRightOf="@+id/radioButton1"
            android:text="Female" />
    </RadioGroup>
    <!--Date of birth-->
    <TextView
        android:id="@+id/textView6"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView5"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="23dp"
        android:text="Date of Birth "
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <EditText
        android:id="@+id/editTextDate2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView6"
        android:layout_toRightOf="@+id/textView6"
        android:ems="10"
        android:inputType="date" />

    <!-- Age-->
    <TextView
        android:id="@+id/textView7"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView6"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="23dp"
        android:text="Age "
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <EditText
        android:id="@+id/editText4"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView7"
        android:layout_toRightOf="@+id/textView7"
        android:background="#CCCCCC"
        android:ems="10"
        android:inputType="number"/>
    <requestFocus />
    <!-- State-->
    <TextView
        android:id="@+id/textView8"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView7"
        android:layout_alignParentLeft="true"
        android:layout_marginTop="23dp"
        android:text="State "
        android:textAppearance="?android:attr/textAppearanceLarge"
        android:textColor="#0099FF" />
    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignBottom="@+id/textView8"
        android:layout_toRightOf="@+id/textView8"
        />
    <!--Submit button-->
    <Button
        android:id="@+id/button1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/textView4"
        android:layout_alignParentLeft="true"
        android:layout_marginLeft="175dp"
        android:layout_marginTop="368dp"
        android:background="#0099FF"
        android:text="Submit"
        android:textColor="#FFFFFF" />

</RelativeLayout>