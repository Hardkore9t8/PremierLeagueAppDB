package javafxApp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * This class holds the data retrieved from the database. These objects are then placed in an array that
 * is used to populate the TableView container on the gui.
 */
public class TableTeam {
    private IntegerProperty idProperty;
    private StringProperty teamProperty;
    private StringProperty nameProperty;
    private IntegerProperty ageProperty;
    private IntegerProperty pointsProperty;
    private StringProperty positionProperty;
    private StringProperty countryProperty;


    // class constructor that takes the table column as arguments
    public TableTeam() {
        this.idProperty = new SimpleIntegerProperty();
        this.teamProperty = new SimpleStringProperty();
        this.nameProperty = new SimpleStringProperty();
        this.ageProperty = new SimpleIntegerProperty();
        this.pointsProperty = new SimpleIntegerProperty();
        this.positionProperty = new SimpleStringProperty();
        this.countryProperty = new SimpleStringProperty();
    }

    public int getId() {
        return idProperty.get();
    }

    public IntegerProperty getTeamId() {
        return idProperty;
    }

    public void setId(int id) {
        this.idProperty.set(id);
    }

    public String getTeam() {
        return teamProperty.get();
    }

    public StringProperty getTeamName() {
        return teamProperty;
    }

    public void setTeam(String team) {
        this.teamProperty.set(team);
    }

    public String getName() {
        return nameProperty.get();
    }

    public StringProperty getPlayerName() {
        return nameProperty;
    }

    public void setName(String name) {
        this.nameProperty.set(name);
    }

    public int getAgeProperty() {
        return ageProperty.get();
    }

    public IntegerProperty getPlayerAge() {
        return ageProperty;
    }

    public void setAge(int age) {
        this.ageProperty.set(age);
    }

    public int getPoints() {
        return pointsProperty.get();
    }

    public IntegerProperty getPlayerPoints() {
        return pointsProperty;
    }

    public void setPoints(int points) {
        this.pointsProperty.set(points);
    }

    public String getPositionProperty() {
        return positionProperty.get();
    }

    public StringProperty getPlayerPosition() {
        return positionProperty;
    }

    public void setPosition(String position) {
        this.positionProperty.set(position);
    }

    public String getCountry() {
        return countryProperty.get();
    }

    public StringProperty getPlayerCountry() {
        return countryProperty;
    }

    public void setCountry(String country) {
        this.countryProperty.set(country);
    }

}
