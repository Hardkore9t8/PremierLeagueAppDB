package javafxApp;

import connection.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
//this is the controller class for the fxml
public class Controller implements Initializable {

    public TextField teamtextfield;
    public TextField playertextfield;
    public Label teamLabel;
    public Label playerLabel;
    public ChoiceBox teamdropdown;
    public ChoiceBox playerdropdown;
    public Button teambutton;
    public Button playerbutton;

    @FXML
    private TableView<Table> table;
    @FXML
    private TableColumn<Table, String> col_team;
    @FXML
    private TableColumn<Table, String> col_name;
    @FXML
    private TableColumn<Table, Integer> col_age;
    @FXML
    private TableColumn<Table, String> col_position;
    @FXML
    private TableColumn<Table, Integer> col_points;

// create array to hold table objects
    ObservableList<Table> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
        Connection con = (Connection) DBConnection.getConnection();

//sql statement to query the database and return data to Table view container
            ResultSet rs = con.createStatement().executeQuery("SELECT team,name,age,fpl_points,position FROM PLEAGUEDB");
            while(rs.next()){
                oblist.add(new Table(rs.getString("team"),rs.getString("name"),rs.getString("position")
                        ,rs.getInt("age"),rs.getInt("fpl_points")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
//setting location for data values for the Table.
        col_team.setCellValueFactory(new PropertyValueFactory<>("team"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
        col_points.setCellValueFactory(new PropertyValueFactory<>("points"));
        col_position.setCellValueFactory(new PropertyValueFactory<>("position"));

        table.setItems(oblist);


    }


    public void teambutton(ActionEvent actionEvent) throws SQLException {

    }

    public void playerbutton(ActionEvent actionEvent) {
        col_team.setText(playertextfield.getText());

    }


}
