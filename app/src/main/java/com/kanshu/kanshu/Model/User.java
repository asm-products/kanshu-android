package com.kanshu.kanshu.model;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private String userName;
    private String userLevel;
    private String sessionId;

    public User(String name, String level) {
        userName = name;
        userLevel = level;
        sessionId = "";
    }

    public User(Parcel parcel) {
        userName = parcel.readString();
        userLevel = parcel.readString();
        sessionId = parcel.readString();
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLevel() {
        return userLevel;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String session){ sessionId = session;}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(userLevel);
        dest.writeString(sessionId);
    }

    public static final Parcelable.Creator<User> CREATOR
            = new Parcelable.Creator<User>() {
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        public User[] newArray(int size) {
            return new User[size];
        }
    };
}
