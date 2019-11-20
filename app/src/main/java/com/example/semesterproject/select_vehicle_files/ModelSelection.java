package com.example.semesterproject.select_vehicle_files;

import android.content.Intent;
import android.os.Bundle;

import com.example.semesterproject.select_vehicle_files.dummy.YearContent;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.example.semesterproject.R;

public class ModelSelection extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {

    String year_selected;
    String make_selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_selection);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        year_selected = intent.getStringExtra("year_selected");
        make_selected = intent.getStringExtra("make_selected");

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onListFragmentInteraction(YearContent.YearItem item) {
        Intent toModel = new Intent(this, TrimSelection.class);
        toModel.putExtra("year_selected", year_selected);
        toModel.putExtra("make_selected", make_selected);
        toModel.putExtra("model_selected", item.year);
        startActivity(toModel);
    }
}
