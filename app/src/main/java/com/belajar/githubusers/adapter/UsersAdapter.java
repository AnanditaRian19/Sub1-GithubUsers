package com.belajar.githubusers.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.belajar.githubusers.R;
import com.belajar.githubusers.model.Users;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    private ArrayList<Users> listUsers;
    private UsersAdapter.OnItemClickedCallback onItemClickedCallback;

    public UsersAdapter(ArrayList<Users> user) {
        this.listUsers = user;
    }

    public void setOnItemClickedCallback(OnItemClickedCallback onItemClickedCallback) {
        this.onItemClickedCallback = onItemClickedCallback;
    }


    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final UsersViewHolder holder, int position) {
        Users user = listUsers.get(position);

        Glide.with(holder.itemView.getContext())
                .load(user.getAvatar())
                .apply(new RequestOptions().override(65,65))
                .into(holder.ivAvatar);

        holder.tvName.setText(user.getName());
        holder.tvUsername.setText(user.getUsername());
        holder.tvFollower.setText(user.getFollower());
        holder.tvFollowing.setText(user.getFollowing());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickedCallback.onItemClicked(listUsers.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }

    public class UsersViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvUsername, tvFollower, tvFollowing;
        CircleImageView ivAvatar;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvFollower = itemView.findViewById(R.id.tv_follower);
            tvFollowing = itemView.findViewById(R.id.tv_following);
        }
    }

    public interface OnItemClickedCallback {
        void onItemClicked(Users data);
    }
}
