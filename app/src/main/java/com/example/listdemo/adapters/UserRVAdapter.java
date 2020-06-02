package com.example.listdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listdemo.R;
import com.example.listdemo.RVClickListener;
import com.example.listdemo.models.Banner;
import com.example.listdemo.models.User;
import com.example.listdemo.models.UserListItem;

import java.util.ArrayList;

public class UserRVAdapter extends RecyclerView.Adapter<UserRVAdapter.UserListItemViewHolder> {

    public enum ItemType {User, Banner}

    public enum ClickType {Item, Image}

    private LayoutInflater inflater;
    private ArrayList<UserListItem> data = new ArrayList<>();
    private RVClickListener<UserListItem> listener;

    public UserRVAdapter(Context context, ArrayList<User> users, RVClickListener<UserListItem> listener) {
        inflater = LayoutInflater.from(context);
        this.data.addAll(Banner.getBannerUserList(users));
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserListItemViewHolder viewHolder;
        if (viewType == ItemType.Banner.ordinal()) {
            View view = inflater.inflate(R.layout.banner_list_item, parent, false);
            viewHolder = new BannerViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.user_list_item, parent, false);
            viewHolder = new UserViewHolder(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final UserListItemViewHolder holder, int position) {
        final UserListItem item = data.get(position);

        holder.onBind(item, listener);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onClick(item, ClickType.Item.ordinal()); // "Item"
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public int getItemViewType(int position) {
        UserListItem item = data.get(position);
        if (item instanceof Banner) {
            return ItemType.Banner.ordinal();
        }
        return ItemType.User.ordinal();
    }

    public void addItem(User user) {
        data.add(user);
//        notifyDataSetChanged();
//        notifyItemChanged(data.size() - 1);
        notifyItemInserted(data.size() - 1);
    }

    public void removeItem(User user) {
        int index = data.indexOf(user);
        if (index != -1) {
            data.remove(index);
            notifyItemRemoved(index);
        }
    }

    abstract class UserListItemViewHolder extends RecyclerView.ViewHolder {

        UserListItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        abstract void onBind(UserListItem item, RVClickListener<UserListItem> listener);
    }

    class UserViewHolder extends UserListItemViewHolder {

        private ImageView avatarIV;
        private TextView nameTV;
        private TextView ageTV;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);

            avatarIV = itemView.findViewById(R.id.ivAvatar);
            nameTV = itemView.findViewById(R.id.tvName);
            ageTV = itemView.findViewById(R.id.tvAge);
        }

        @Override
        void onBind(final UserListItem item, final RVClickListener<UserListItem> listener) {
            User user = (User) item;

            avatarIV.setImageResource(user.getAvatarRes());
            nameTV.setText(user.getName());
            ageTV.setText(String.valueOf(user.getAge()));

            avatarIV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(item, ClickType.Image.ordinal());
                }
            });
        }
    }

    class BannerViewHolder extends UserListItemViewHolder {

        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        void onBind(UserListItem item, RVClickListener<UserListItem> listener) {

        }
    }
}
