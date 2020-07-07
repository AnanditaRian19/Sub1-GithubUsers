package com.belajar.githubusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import com.belajar.githubusers.adapter.UsersAdapter;
import com.belajar.githubusers.model.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvUser;
    private ArrayList<Users> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_main);

        rvUser = findViewById(R.id.rv_github_users);
        rvUser.setHasFixedSize(true);

        list.addAll(getListUsers());
        showRecyclerList();
    }

    public ArrayList<Users> getListUsers() {
        String[] dataAvatar = getResources().getStringArray(R.array.avatar);
        String[] dataName = getResources().getStringArray(R.array.name);
        String[] dataUsername = getResources().getStringArray(R.array.username);
        String[] dataFollower = getResources().getStringArray(R.array.followers);
        String[] dataFollowing = getResources().getStringArray(R.array.following);
        String[] dataLocation = getResources().getStringArray(R.array.location);
        String[] dataCompany = getResources().getStringArray(R.array.company);
        String[] dataRepository = getResources().getStringArray(R.array.repository);
        String[] dataEmail = getResources().getStringArray(R.array.email);

        ArrayList<Users> listuser = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Users users = new Users();
            users.setAvatar(dataAvatar[i]);
            users.setName(dataName[i]);
            users.setUsername(dataUsername[i]);
            users.setFollower(dataFollower[i]);
            users.setFollowing(dataFollowing[i]);
            users.setLocation(dataLocation[i]);
            users.setCompany(dataCompany[i]);
            users.setRepository(dataRepository[i]);
            users.setEmail(dataEmail[i]);

            listuser.add(users);
        }
        return listuser;
    }

    private void showRecyclerList() {
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        UsersAdapter usersAdapter = new UsersAdapter(list);
        rvUser.setAdapter(usersAdapter);

        usersAdapter.setOnItemClickedCallback(new UsersAdapter.OnItemClickedCallback() {
            @Override
            public void onItemClicked(Users data) {
                showSelectedItem(data);
            }
        });
    }

    private void showSelectedItem(Users users) {
        Users user = new Users();
        user.setAvatar(users.getAvatar());
        user.setName(users.getName());
        user.setUsername(users.getUsername());
        user.setFollower(users.getFollower());
        user.setFollowing(users.getFollowing());
        user.setRepository(users.getRepository());
        user.setLocation(users.getLocation());
        user.setCompany(users.getCompany());
        user.setEmail(users.getEmail());

        Intent intent = new Intent(MainActivity.this, DetailUsers.class);
        intent.putExtra(DetailUsers.EXTRA_USERS, user);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}