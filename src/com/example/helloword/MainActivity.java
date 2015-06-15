package com.example.helloword;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(new GameView(this));
        //findViewById(R.layout.activity_main);
        //setContentView(viewDisplay);
    }


    
}
