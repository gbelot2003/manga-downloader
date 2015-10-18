/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates<?xml version="1.0" encoding="UTF-8"?>
 * and open the template in the editor.
 */
package mangatest2;

import com.gbelot2003.mangaset.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author ajax
 */
public class FXMLDocumentController implements Initializable {
    
    private ArrayList<ChapterList> oList;
    
    @FXML
    private Label lblTitle;
    
    @FXML 
    private Button btnGet;
    
    @FXML
    private ImageView imgPort;
    
    @FXML
    private Label txaInfo;
    
    @FXML 
    private TextField txtUrl;
    
    @FXML
    private TableView TableChapters;
    
    
    public static TableColumn<ChapterList, String> getSubTitle(){
        TableColumn<ChapterList, String> title = new TableColumn<>("getSubTitle");
        title.setCellValueFactory(new PropertyValueFactory<>("getSubTitle"));
        title.setMinWidth(200);
        title.setText("Title");
        return title;
    } 
    
    public static TableColumn<ChapterList, String> getSubLink(){
        TableColumn<ChapterList, String> url = new TableColumn<>("getsubLink");
        url.setCellValueFactory(new PropertyValueFactory<>("getsubLink"));
        url.setMinWidth(200);
        url.setText("Title");
        return url;
    }
    
    public static TableColumn<ChapterList, String> getDate(){
        TableColumn<ChapterList, String> date = new TableColumn<>("getDate");
        date.setCellValueFactory(new PropertyValueFactory<>("getDate"));
        date.setMinWidth(150);
        date.setText("Date");
        return date;
    } 
    
       
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
       GetMangaData data = new GetMangaData();
       
       data.setMangaData(txtUrl.getText());
       
       Image image = new Image(data.getMangaImageInfo());
       imgPort.setImage(image);
            
       lblTitle.setText(data.getMangaTitle());
       txaInfo.setText(data.getMangaInfo());
       oList = data.getChapterList();
       TableInit();
            
    }
   
    public void TableInit(){
       
       ObservableList<ChapterList> list = FXCollections.observableArrayList(oList);
       
       TableChapters.getColumns().clear();
       TableChapters.getItems().clear();
       TableChapters.setItems(list);
       
       TableViewSelectionModel<ChapterList> tms = TableChapters.getSelectionModel();
       
       tms.setSelectionMode(SelectionMode.MULTIPLE);
       tms.setCellSelectionEnabled(true);
       
       ObservableList<Integer> lists = tms.getSelectedIndices();
       lists.addListener((ListChangeListener.Change<? extends Integer> change)->{
           System.out.println(lists);
       });
       
       TableChapters.getColumns().addAll(FXMLDocumentController.getSubTitle(),
                                         FXMLDocumentController.getSubLink(),
                                         FXMLDocumentController.getDate());
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    
}
