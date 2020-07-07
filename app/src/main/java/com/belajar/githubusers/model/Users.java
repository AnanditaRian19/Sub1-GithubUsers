package com.belajar.githubusers.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Users implements Parcelable {

    private String name;
    private String username;
    private String company;
    private String location;
    private String avatar;
    private String follower;
    private String following;
    private String repository;

    private String email;

    public Users () {

    }

    protected Users(Parcel in) {
        name = in.readString();
        username = in.readString();
        company = in.readString();
        location = in.readString();
        avatar = in.readString();
        follower = in.readString();
        following = in.readString();
        repository = in.readString();
        email = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(username);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(avatar);
        dest.writeString(follower);
        dest.writeString(following);
        dest.writeString(repository);
        dest.writeString(email);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Users> CREATOR = new Creator<Users>() {
        @Override
        public Users createFromParcel(Parcel in) {
            return new Users(in);
        }

        @Override
        public Users[] newArray(int size) {
            return new Users[size];
        }
    };

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }
}
