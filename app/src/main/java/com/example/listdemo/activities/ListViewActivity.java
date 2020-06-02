package com.example.listdemo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.listdemo.R;
import com.example.listdemo.adapters.UserAdapter;
import com.example.listdemo.models.User;
import com.example.listdemo.models.UserListItem;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        final ArrayList<User> users = User.getUsers(6);

//        final ArrayAdapter<User> adapter = new ArrayAdapter<>(this, R.layout.custom_list_item, R.id.text, users);

        // Custom adapter
        final UserAdapter adapter = new UserAdapter(this, users);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                UserListItem item = (UserListItem) parent.getItemAtPosition(position);

                String msg;
                if (item instanceof User) {
                    User user = (User) item;
//                user.setAge(user.getAge() + 1);
//                adapter.notifyDataSetChanged();
                    msg = user.toString();
                } else {
                    msg = "BANNER";
                }

                Toast.makeText(ListViewActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
