package com.animator_abhi.contactretrieve;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class GridActivity extends AppCompatActivity {
    GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        gridview.setNumColumns(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE ? 3 : 2);
        super.onConfigurationChanged(newConfig);
    }
}
