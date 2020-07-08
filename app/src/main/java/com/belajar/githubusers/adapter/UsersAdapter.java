package com.belajar.githubusers.adapter;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
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
    public void onBindViewHolder(@NonNull final UsersViewHolder holder, final int position) {
        final Users user = listUsers.get(position);

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

        holder.tbFavorite.setChecked(false);
        holder.tbFavorite.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.ic_baseline_favorite));
        holder.tbFavorite.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    holder.tbFavorite.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.ic_baseline_favorite_click));
                    Toast toast = Toast.makeText(holder.itemView.getContext(), "Favorite " + user.getName(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                } else {
                    holder.tbFavorite.setBackgroundDrawable(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.ic_baseline_favorite));
                    Toast toast = Toast.makeText(holder.itemView.getContext(), "Unfavorite " + user.getName(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
                    toast.show();
                }
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
        ToggleButton tbFavorite;

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAvatar = itemView.findViewById(R.id.iv_avatar);
            tvName = itemView.findViewById(R.id.tv_name);
            tvUsername = itemView.findViewById(R.id.tv_username);
            tvFollower = itemView.findViewById(R.id.tv_follower);
            tvFollowing = itemView.findViewById(R.id.tv_following);
            tbFavorite = itemView.findViewById(R.id.tb_favorite);
        }
    }

    public interface OnItemClickedCallback {
        void onItemClicked(Users data);
    }
}
