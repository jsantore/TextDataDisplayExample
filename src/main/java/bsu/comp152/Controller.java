package bsu.comp152;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public TextField NameField;
    public TextField CultureField;
    public TextField BornField;
    public TextField TitleField;
    public TextField inputName;
    private Model dataModel;

    @Override
    public void initialize(URL location, ResourceBundle resources){
        dataModel = new Model();
    }

    public void loadData(ActionEvent event){
        var site = "https://anapioficeandfire.com/api/";
        var input = inputName.getText();
        if (input.length() <1){
            Alert box = new Alert(Alert.AlertType.INFORMATION);
            box.setContentText("Enter Character ID before I can get Data");
            box.showAndWait();
            return;
        }
        site = site+ "characters/"+input;
        GoTData data = dataModel.GetData(site);
        displayData(data);
    }

    public void displayData(GoTData data){
        //set the data (or at least the part we want) from the Game if Thrones data object
        //into text fields for display.
        NameField.setText(data.name);
        CultureField.setText(data.culture);
        BornField.setText(data.born);
        //some people have many titles,some have none. If there is at least one
        //then use the first one
        if(data.titles.size() >=1)
            TitleField.setText(data.titles.get(0));

    }

}
