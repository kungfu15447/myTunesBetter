/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes.GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import mytunes.GUI.Model.MyTunesModel;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class CreateSongController implements Initializable
{
    private MyTunesModel mtm;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField txtTitleInput;
    @FXML
    private TextField txtArtistInput;
    @FXML
    private ComboBox<String> comboCategoryBox;
    @FXML
    private TextField txtDuration;
    @FXML
    private TextField txtFile;
    
    
    /**
     * Initializes the controller class.
     */
    public CreateSongController() {
        mtm = new MyTunesModel();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        comboCategoryBox.setItems(FXCollections.observableArrayList("Blues","Hip Hop","Pop","Rap",
                "Rock","Techno"));
        comboCategoryBox.setVisibleRowCount(6);
        
        
        
    }    

    @FXML
    private void handleMoreBtn(ActionEvent event)
    {
    }

    @FXML
    private void handleChooseBtn(ActionEvent event)
    {
        txtFile.setText(mtm.chooseFile());
        txtTitleInput.setText(mtm.getSongTitle());
        txtDuration.setText(mtm.getDuration());
    }

    @FXML
    private void handleSaveBtn(ActionEvent event)
    {
    }

    @FXML
    private void handleCancelBtn(ActionEvent event) throws IOException
    {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private String handleComboCategory(ActionEvent event)
    {
        String category;
        
        int selectedIndex = comboCategoryBox.getSelectionModel().getSelectedIndex();
        
        switch(selectedIndex)
        {
            case 0:
                category = "blues";
                break;
            case 1:
                category = "hipHop";
                break;
            case 2:
                category = "pop";
                break;
            case 3:
                category = "rap";
            case 4:
                category = "rock";
            case 5:
                category = "techno";
            default: 
                throw new UnsupportedOperationException("Category not chosen");
        }
        return category;
    }
    
    
}
