package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{"Ivan Ivanov", "Alex Alex", "Pavel Pavel", "Fedor Fedor", "David David", "Sam Sam", "Name Name"};
    private int[] avatars = new int[]{R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5, R.drawable.p6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<User> users = new ArrayList<>();
//        for(String name: names)
        for (int i = 0; i < names.length; i++) { // i = i + 1
            User user;

            String name = names[i];
            if (i < avatars.length) {
                int avatarRes = avatars[i];

                user = new User(avatarRes, name, i + 20);
            } else {
                user = new User(name, i + 20);
            }

            users.add(user);
        }

//        final ArrayAdapter<User> adapter = new ArrayAdapter<>(this, R.layout.custom_list_item, R.id.text, users);

        // Custom adapter
        final UserAdapter adapter = new UserAdapter(this, users);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = users.get(position);
//                user.setAge(user.getAge() + 1);
//                adapter.notifyDataSetChanged();

                String msg;
                if (user != null) {
                    msg = user.toString();
                } else {
                    msg = "BANNER";
                }

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
