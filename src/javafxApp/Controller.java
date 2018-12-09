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
import org.apache.derby.client.am.SqlException;

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
    private TableView TeamTable;
    @FXML
    private TableColumn<TableTeam, String> col_team;
    @FXML
    private TableColumn<TableTeam, String> col_name;
    @FXML
    private TableColumn<TableTeam, Integer> col_age;
    @FXML
    private TableColumn<TableTeam, String> col_position;
    @FXML
    private TableColumn<TableTeam, Integer> col_points;
    @FXML
    private TableColumn<TableTeam, String> col_country;

// create array to hold table objects


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        DBConnection.getConnection();
        Connection con = DBConnection.connection;

        //ObservableList<TableTeam> oblist = FXCollections.observableArrayList();
        try {
            //oblist = DBConnection.getAllRecords();

            //System.out.println(oblist.size());
            //System.out.println(oblist.get(0).getName());
            //System.out.println(oblist.get(1).getName());
            //System.out.println(oblist.get(2).getName());
            //col_team.
            //ResultSet rs = con.createStatement().executeQuery("SELECT * FROM TEAM");
            //ResultSet rs = DBConnection.sqlQuery("SELECT * FROM TEAM");

            //setting location for data values for the Table.
            col_team.setCellValueFactory(cellData -> cellData.getValue().getTeamName());
            col_name.setCellValueFactory(cellData -> cellData.getValue().getPlayerName());
            col_age.setCellValueFactory(cellData -> cellData.getValue().getPlayerAge().asObject());
            col_points.setCellValueFactory(cellData -> cellData.getValue().getPlayerPoints().asObject());
            col_position.setCellValueFactory(cellData -> cellData.getValue().getPlayerPosition());
            col_country.setCellValueFactory(cellData -> cellData.getValue().getPlayerCountry());

            ObservableList<TableTeam> teamList = DBConnection.getAllRecords();
            populateTableList(teamList);




        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SqlException e) {
            e.printStackTrace();
        }

    }

    private void populateTableList(ObservableList<TableTeam> teamList) {
        TeamTable.setItems(teamList);
    }


    public void teambutton(ActionEvent actionEvent) throws SQLException {
        TeamTable.getItems().clear();
        String team = teamtextfield.getText();

        String sqlStr = "Select * From Team Where Team = '"+team+"' Order By name";
        try {

            ObservableList<TableTeam> teamList = DBConnection.getSelectedRecords(sqlStr);
            populateTableList(teamList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SqlException e) {
            e.printStackTrace();
        }
    }
    //
    public void playerbutton(ActionEvent actionEvent) {
        TeamTable.getItems().clear();
        String player = playertextfield.getText();

        String sqlStr = "Select * From Team Where Name = '"+player+"'";
        try {

            ObservableList<TableTeam> teamList = DBConnection.getSelectedRecords(sqlStr);
            populateTableList(teamList);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SqlException e) {
            e.printStackTrace();
        }


    }


}
