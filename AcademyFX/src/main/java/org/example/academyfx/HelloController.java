package org.example.academyfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.Callback;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collector;

public class HelloController {
    private Connector connector = null;
    /*@FXML
    private Label welcomeText;
    @FXML
    private TextField lastName;
    @FXML
    private TextField firstName;
    @FXML
    private DatePicker age;

    @FXML
    protected void onHelloButtonClick() {
        String data = lastName.getText() + " " + firstName.getText() + " " + age.getValue();
        //welcomeText.setText(data);
        //welcomeText.setText("Welcome to JavaFX Application!");
        Alert alert = new Alert(Alert.AlertType.INFORMATION,data, ButtonType.OK);
        alert.setTitle("Hello "+firstName.getText()+"!");
        alert.show();
    }*/
    @FXML
    private ComboBox cbDirections;
    @FXML
    private Button load;
    @FXML
    private Button check;
    @FXML
    private TableView<String[]> tableDirections;
    @FXML
    private Label status;
    @FXML
    protected void onLoadButtonClick()throws SQLException
    {
        String connectionString = "jdbc:sqlserver://localhost:1433;"+
                "DataSource=DESKTOP-CU1U64A;" +
                "Database=PD_212;" +
                "user=PHP;" +
                "password=111;" +
                "ConnectTimeout=30;Encrypt=True;" +
                "TrustServerCertificate=True;";

        Connection connection = DriverManager.getConnection(connectionString);
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery("SELECT * FROM Directions");
        while (set.next())
        {
            cbDirections.getItems().add(set.getString("direction_name"));
        }
        set.close();
        connection.close();

        Alert alert = new Alert(Alert.AlertType.INFORMATION,connectionString,ButtonType.OK);
        alert.show();
    }
    @FXML
    protected void onCheckButtonClick()
    {
        String msg = cbDirections.getValue().toString();
        Alert alert = new Alert(Alert.AlertType.INFORMATION, msg, ButtonType.OK);
        alert.show();
    }
    @FXML
    protected void loadDirections()throws SQLException
    {
        /*String connectionString =
                "jdbc:sqlserver://localhost:1433;"+
                        "DataSource=DESKTOP-CU1U64A;" +
                        "Database=PD_212;" +
                        "user=PHP;" +
                        "password=111;" +
                        "ConnectTimeout=30;Encrypt=True;" +
                        "TrustServerCertificate=True;";
        Connection connection = DriverManager.getConnection(connectionString);*/
        Statement statement = connector.getConnection().createStatement();

        ResultSet set = statement.executeQuery("SELECT * FROM Directions");
        for(int i=0;i<set.getMetaData().getColumnCount();i++)
        {
            TableColumn<String[],String> column = new TableColumn<>(set.getMetaData().getColumnLabel(i+1));
            tableDirections.getColumns().add(column);
            final  int j=i;
            column.setCellValueFactory(data->new SimpleStringProperty(data.getValue()[j]));
        }
        while (set.next())
        {
            Collection<String> list = new ArrayList<>();
            for (int i=1; i<=set.getMetaData().getColumnCount();i++)
            {
                list.add(set.getString(i));
            }
            String[] arr = new String[list.size()];
            list.toArray(arr);
            tableDirections.getItems().addAll(arr);
        }

        //connection.close();
    }
    @FXML
    protected void connect()
    {
        if(connector == null)
        {
            String connectionString =
                    "jdbc:sqlserver://localhost:1433;"+
                            "DataSource=DESKTOP-CU1U64A;" +
                            "Database=PD_212;" +
                            "user=PHP;" +
                            "password=111;" +
                            "ConnectTimeout=30;Encrypt=True;" +
                            "TrustServerCertificate=True;";
            try {
                connector = new Connector(connectionString);
                status.setText("Connected\n"+connector.getConnection().toString());
            }
            catch (SQLException e)
            {
                Alert error = new Alert(Alert.AlertType.ERROR, e.getMessage(),ButtonType.OK);
                error.showAndWait();
            }
        }
        else {
            Alert error = new Alert(Alert.AlertType.ERROR, "Connection already done",ButtonType.OK);
            error.showAndWait();
        }
    }
    @FXML
    protected void disconnect()
    {
        if(connector!=null)
        {
            try {
                connector.closeConnection();
                connector = null;
                //TODO: clear all data
                status.setText("Disconnected");
            } catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR,e.getMessage(),ButtonType.OK);
                alert.showAndWait();
            }
        }
    }
}