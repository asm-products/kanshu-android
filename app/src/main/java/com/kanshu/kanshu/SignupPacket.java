package com.kanshu.kanshu;

public class SignupPacket {

    public String password;
    public String email;
    public String userBio;
    public String profileImageUrl;
    public String username;
    public String country;
    public int hsklevel;

    public SignupPacket(String password, String email,String username, String userBio, String country, int hsklevel){
        this.password = password;
        this.email = email;
        this.userBio = userBio;
        this.profileImageUrl = "http://someurl.com/image.png"; //This can be replaced by the actual url once there is a field in the activity
        this.username = username;
        this.country = country;
        this.hsklevel = hsklevel;
    }
}
