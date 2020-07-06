package com.belajar.githubusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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

        ArrayList<Users> listuser = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Users users = new Users();
            users.setAvatar(dataAvatar[i]);
            users.setName(dataName[i]);
            users.setUsername(dataUsername[i]);
            users.setFollower(dataFollower[i]);
            users.setFollowing(dataFollowing[i]);

            listuser.add(users);
        }
        return listuser;
    }

    private void showRecyclerList() {
        rvUser.setLayoutManager(new LinearLayoutManager(this));
        UsersAdapter usersAdapter = new UsersAdapter(list);
        rvUser.setAdapter(usersAdapter);
    }
}