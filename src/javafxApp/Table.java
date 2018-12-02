package javafxApp;

public class Table {
    String team, name, position;
    int age, fpl_points;



    public Table(String team, String name, String position, int age, int points) {
        this.team = team;
        this.name = name;
        this.position = position;
        this.age = age;
        this.fpl_points = points;

    }
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoints() {
        return fpl_points;
    }

    public void setPoints(int points) {
        this.fpl_points = fpl_points;
    }
}
