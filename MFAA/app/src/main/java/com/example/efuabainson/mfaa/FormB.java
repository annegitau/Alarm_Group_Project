package com.example.efuabainson.mfaa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class FormB extends AppCompatActivity {

    private Button result;
    private CheckBox major_1;
    private CheckBox major_2;
    private CheckBox major_3;
    private RadioButton sex_m;
    private RadioButton sex_f;

    String sex;
    StringBuffer major = new StringBuffer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_b);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        result = (Button) findViewById(R.id.finish);
        major_1 = (CheckBox) findViewById(R.id.checkBox);
        major_2 = (CheckBox) findViewById(R.id.checkBox2);
        major_3 = (CheckBox) findViewById(R.id.checkBox3);
        sex_m = (RadioButton) findViewById(R.id.radioButton4);
        sex_f = (RadioButton) findViewById(R.id.radioButton3);


        result.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                Intent i = new Intent(FormB.this, Forms.class);

                if(major_1.isChecked()){
                    major.append("CS");
                }

                if(major_2.isChecked()){
                    major.append("MIS");
                }

                if(major_3.isChecked()){
                    major.append("BA");
                }

                if(sex_m.isChecked()){
                    sex = "Male";
                } else if(sex_f.isChecked()){
                    sex = "Female";
                }


                i.putExtra("Major",major.toString());
                i.putExtra("Sex",sex);
                startActivity(i);
            }
        });
    }

}
