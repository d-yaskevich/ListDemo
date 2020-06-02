package com.example.listdemo.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.listdemo.R;
import com.example.listdemo.RVClickListener;
import com.example.listdemo.adapters.UserRVAdapter;
import com.example.listdemo.models.User;
import com.example.listdemo.models.UserListItem;

public class RecyclerViewActivity extends AppCompatActivity implements RVClickListener<UserListItem> {

    UserRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        adapter = new UserRVAdapter(this, User.getUsers(15), this);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(UserListItem item, int clickType) {
        String msg = null;

        if (clickType == UserRVAdapter.ClickType.Item.ordinal()) {
            msg = item.toString();
        } else if (clickType == UserRVAdapter.ClickType.Image.ordinal()) {
            msg = item.toString() + " avatar";
        }

        if (msg != null) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}
