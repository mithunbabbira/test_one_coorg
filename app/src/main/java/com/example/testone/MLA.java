package com.example.testone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MLA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ml);
    }


    public void bWork(View view){

        String value ="bopaiah";

        Intent intent= new Intent(MLA.this ,retriveDB.class);
        intent.putExtra("namebdm",value);// sending the value to the  Main2Activity from Mainactivity
        startActivity(intent);



    }
    public void aWork(View view){

        String value ="appachu";

        Intent intent= new Intent(MLA.this ,retriveDB.class);
        intent.putExtra("namebdm",value);// sending the value to the  Main2Activity from Mainactivity
        startActivity(intent);



    }
}
