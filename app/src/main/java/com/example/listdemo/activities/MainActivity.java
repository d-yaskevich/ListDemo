package com.example.listdemo.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.listdemo.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToListView(View view) {
        Intent intent = new Intent(MainActivity.this, ListViewActivity.class);
        startActivity(intent);
    }

    public void goToRecyclerView(View view) {
        Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
        startActivity(intent);
    }
}
