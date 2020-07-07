package com.belajar.githubusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.belajar.githubusers.model.Users;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailUsers extends AppCompatActivity {

    public static final String EXTRA_USERS = "extra_users";
    private TextView tvName, tvUsername, tvFollower, tvFollowing, tvLocation, tvCompany, tvRepository, tvEmail;
    private ImageView ivAvatar;
    private Button btnFollow;
    private ToggleButton btnToggle;
    private boolean isClick = true;

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
        btnFollow = findViewById(R.id.btn_follow);
        btnToggle = findViewById(R.id.btn_toggle);

        btnToggle.setChecked(false);
        btnToggle.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_baseline_favorite));
        btnToggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                Users userrr = new Users();

                if (b) {
                    btnToggle.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_baseline_favorite_click));
//                    Toast toast = Toast.makeText(DetailUsers.this, "Favorite " + userrr.getName(),Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
//                    toast.show();
                } else {
                    btnToggle.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_baseline_favorite));
//                    Toast toast = Toast.makeText(DetailUsers.this, "Unfavorite " + userrr.getName(),Toast.LENGTH_SHORT);
//                    toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL,0,0);
//                    toast.show();
                }
            }
        });

        btnFollow.setText("Follow");
        btnFollow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    btnFollow.setText("Following");

//                Toast toast = Toast.makeText(DetailUsers.this, "Follow ", Toast.LENGTH_SHORT);
//                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
//                toast.show();
            }
        });

        final Users users = getIntent().getParcelableExtra(EXTRA_USERS);

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