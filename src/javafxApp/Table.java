package javafxApp;

/**
 * This class holds the data retrieved from the database. These objects are then placed in an array that
 * is used to populate the TableView container on the gui.
 */
public class Table {

    String team, name, position;
    int age, fpl_points;


    // class constructor that takes the table column as arguments
    public Table(String team, String name, String position, int age, int points) {
        this.team = team;
        this.name = name;
        this.position = position;
        this.age = age;
        this.fpl_points = points;

    // getter and setter methods
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
