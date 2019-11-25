package com.example.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.semesterproject.select_vehicle_files.YearSelection;
import com.example.semesterproject.select_vehicle_files.dummy.YearContent;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    public static final int selection = 1;

    String data;
    String make;
    String name;
    String trim;
    String year;
    String mgp;
    String capacity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button x = (Button)findViewById(R.id.selectVehicle);

        x.setOnClickListener(e -> {
            System.out.println("Button was clicked here");
            Intent yearIntent = new Intent(MainActivity.this, YearSelection.class);
            startActivityForResult(yearIntent, selection);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        data = intent.getStringExtra("data");
        make = intent.getStringExtra("make_id");
        name = intent.getStringExtra("name");
        trim = intent.getStringExtra("trim");
        year = intent.getStringExtra("year");
        mgp = intent.getStringExtra("mpg");
        capacity = intent.getStringExtra("capacity");

        System.out.println(capacity);
    }
}
