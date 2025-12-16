package edu.upc.dsa_android_DriveNdodge.models;
public class UsrMinimo2 {
    private String name;
    private String avatarUrl;
    private int points;

    private String usergroup;

    public UsrMinimo2() {
    }

    public UsrMinimo2(String name, String avatarUrl, int points) {
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(String usergroup) {
        this.usergroup = usergroup;
    }
}
