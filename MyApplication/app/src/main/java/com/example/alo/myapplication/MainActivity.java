package com.example.alo.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.textView);
    }

    public void buttonPressed (View view){
        // TODO test
        Log.i(LOG_TAG, "buttonPressed(View) Called");
        String stringValue = "My Name is Alvin";
        mTextView.setText(stringValue);
        Log.v(LOG_TAG, "text change to: " + stringValue);
        Log.d(LOG_TAG, "buttonPressed(View) finished");
    }
}
