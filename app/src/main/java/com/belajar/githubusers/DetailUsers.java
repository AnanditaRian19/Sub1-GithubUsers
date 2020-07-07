package com.belajar.githubusers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.belajar.githubusers.model.Users;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailUsers extends AppCompatActivity {

    public static final String EXTRA_USERS = "extra_users";
    private String name, username, follower, following, avatar;
    private TextView tvName, tvUsername, tvFollower, tvFollowing;
    private ImageView ivAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_users);

        ivAvatar = findViewById(R.id.iv_avatar);
        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvFollower = findViewById(R.id.tv_follower);
        tvFollowing = findViewById(R.id.tv_following);

        Users users = getIntent().getParcelableExtra(EXTRA_USERS);
//        ArrayList<Users> users1 = this.getIntent().getParcelableArrayListExtra(EXTRA_USERS);

//        String getAvatar = users.getAvatar();
//        ivAvatar.setBackgroundResource(Integer.parseInt(getAvatar));

        Glide.with(DetailUsers.this)
                .load(users.getAvatar())
                .into(ivAvatar);

        String getName = users.getName();
        tvName.setText(getName);

        String getUsername = users.getUsername();
        tvUsername.setText(getUsername);

        String getFollower = users.getFollower();
        tvFollower.setText(getFollower);

        String getFollowing = users.getFollowing();
        tvFollowing.setText(getFollowing);

//        name = users.get(0).getName();
//        tvName.setText(name);
//
//        username = users.get(0).getUsername();
//        tvUsername.setText(username);
//
//        follower = users.get(0).getFollower();
//        tvFollower.setText(follower);
//
//        following = users.get(0).getUsername();
//        tvFollowing.setText(following);
    }
}