package database.models;

public class UsrMinimo2 {
    private String name;
    private String avatarUrl;
    private int points;
    private String equipo;

    public UsrMinimo2() {
    }

    public UsrMinimo2(String name, String avatarUrl, int points, String equipo) {
        this.equipo = equipo;
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

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
}
