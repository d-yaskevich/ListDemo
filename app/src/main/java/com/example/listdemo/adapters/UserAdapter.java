package com.example.listdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listdemo.R;
import com.example.listdemo.models.Banner;
import com.example.listdemo.models.User;
import com.example.listdemo.models.UserListItem;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<UserListItem> {

    private final int USER_TYPE = 1;
    private final int BANNER_TYPE = 2;

    public UserAdapter(@NonNull Context context, ArrayList<User> users) {
        super(context, R.layout.user_list_item);
        addAll(Banner.getBannerUserList(users));
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int layoutRes = R.layout.user_list_item;
        int itemViewType = getItemViewType(position);
        if (itemViewType == BANNER_TYPE) {
            layoutRes = R.layout.banner_list_item;
        }

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(layoutRes, parent, false);

        if (itemViewType == USER_TYPE) {
            ImageView avatarIV = view.findViewById(R.id.ivAvatar);
            TextView nameTV = view.findViewById(R.id.tvName);
            TextView ageTV = view.findViewById(R.id.tvAge);

            User user = (User) getItem(position);

            avatarIV.setImageResource(user.getAvatarRes());
            nameTV.setText(user.getName());
            ageTV.setText(String.valueOf(user.getAge()));
        }

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItem(position) instanceof Banner) {
            return BANNER_TYPE;
        }
        return USER_TYPE;
    }
}
