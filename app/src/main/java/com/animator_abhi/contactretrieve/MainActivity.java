package com.animator_abhi.contactretrieve;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button conBtn,gridBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        conBtn= (Button) findViewById(R.id.contactButton);
        gridBtn= (Button) findViewById(R.id.gridButton);


    }

    public void openContactActivity(View v)
    {

        Intent i=new Intent(this,ContactActivity.class);
        startActivity(i);
    }

    public void openGridActivity(View v)
    {

        Intent i=new Intent(this,GridActivity.class);
        startActivity(i);
    }
}
