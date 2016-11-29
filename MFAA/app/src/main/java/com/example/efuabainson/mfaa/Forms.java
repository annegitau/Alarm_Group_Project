package com.example.efuabainson.mfaa;

import android.support.v7.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.app.Dialog;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Toast;
import android.content.Intent;
import android.util.Log;

public class Forms extends AppCompatActivity {

    private Button result;
    private Button next;
    private EditText mEdit;
    public static EditText fname;
    public static EditText lname;
    final Context context = this;

    static String first;
    static String last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forms);

        result = (Button) findViewById(R.id.result);
        next = (Button) findViewById(R.id.next);
        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                Intent i = new Intent(Forms.this, FormB.class);

                first = fname.getText().toString();
                last = lname.getText().toString();

                i.putExtra("first",first);
                i.putExtra("last",last);
                startActivity(i);

            }
        });

        result.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                //mEdit   = (EditText)findViewById(R.id.fname);
                //i.putExtra("Name",mEdit.getText().toString());
                //String a =getIntent().getCharSequenceExtra("first").toString();
                //String b =getIntent().getCharSequenceExtra("last").toString();
                String c =getIntent().getCharSequenceExtra("Sex").toString();
                String d =getIntent().getCharSequenceExtra("Major").toString();

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);

                // set title
                alertDialogBuilder.setTitle("Form Summary");

                // set dialog message
                alertDialogBuilder
                        .setMessage("Firstname: " + first + "\n" + "Lastname: " + last + "\n" + "Sex: " + c +
                        "\n" + "Major: " + d)
                        .setCancelable(false)

                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });
    }

}
