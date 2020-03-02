package com.example.hellocompat;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Hello World TextView
    private TextView helloTextView;
    // Array of color names to match the color resource in color.xml
    private String[] colorArray = {"red", "pink", "purple", "deep_purple",
            "indigo", "blue", "light_blue", "cyan", "teal", "green",
            "light_green", "lime", "yellow", "amber", "orange", "deep_orange",
            "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTextView = findViewById(R.id.hello_textView);

        // Restore saved instance state ( which is the text color )
        if (savedInstanceState != null) {
            helloTextView.setTextColor(savedInstanceState.getInt("color"));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // save the current text color
        outState.putInt("color", helloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        // Create a random number object
        Random random = new Random();
        // Picks a random color from the color array
        String colorName = colorArray[random.nextInt(20)];
        int colorResourceName = getResources().getIdentifier(colorName,
                "color", getApplicationContext().getPackageName());
        int colorRes = ContextCompat.getColor(this, colorResourceName);
        // Set the color of the TextView to the colorRes
        helloTextView.setTextColor(colorRes);
    }
}
