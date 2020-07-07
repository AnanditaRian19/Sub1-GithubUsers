package com.belajar.githubusers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.belajar.githubusers.model.Users;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class DetailUsers extends AppCompatActivity {

    public static final String EXTRA_USERS = "extra_users";
    private TextView tvName, tvUsername, tvFollower, tvFollowing, tvLocation, tvCompany, tvRepository, tvEmail;
    private ImageView ivAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_users);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_detail_users);

        ivAvatar = findViewById(R.id.iv_avatar);
        tvName = findViewById(R.id.tv_name);
        tvUsername = findViewById(R.id.tv_username);
        tvFollower = findViewById(R.id.tv_follower);
        tvFollowing = findViewById(R.id.tv_following);
        tvLocation = findViewById(R.id.tv_location);
        tvCompany = findViewById(R.id.tv_company);
        tvRepository = findViewById(R.id.tv_repository);
        tvEmail = findViewById(R.id.tv_email);

        Users users = getIntent().getParcelableExtra(EXTRA_USERS);

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

        String getLocation = users.getLocation();
        tvLocation.setText(getLocation);

        String getComapny = users.getCompany();
        tvCompany.setText(getComapny);

        String getRepository = users.getRepository();
        tvRepository.setText(getRepository);

        String getEmail = users.getEmail();
        tvEmail.setText(getEmail);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}