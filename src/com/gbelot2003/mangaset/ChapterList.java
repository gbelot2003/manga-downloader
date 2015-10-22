/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gbelot2003.mangaset;

import java.io.Serializable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author ajax
 */
public class ChapterList implements Serializable {
    public enum Type{
        SYSTEM, ENVIROMENT
    }
    
    private final StringProperty subTitle = new SimpleStringProperty();
    private final StringProperty subLink = new SimpleStringProperty();
    private final StringProperty date = new SimpleStringProperty();
    private final BooleanProperty isSelected = new SimpleBooleanProperty();

    public ChapterList() {}

    public ChapterList(String title, String url, String date, boolean isSelected){
        this.subTitle.set(title);
        this.subLink.set(url);
        this.date.set(date); 
        this.isSelected.set(isSelected);
    }
    
    public final StringProperty getSubTitleProperty() {
        return this.subTitle;
    }

    public final void setSubTitle(String name){
        this.getSubTitleProperty().set(name);
    }
    
    public final StringProperty getsubLinkProperty() {
        return this.subLink;
    }

    public final void setsubLink(String link){
        this.getsubLinkProperty().set(link);
    }
    
    public final StringProperty getDateProperty() {
        return this.date;
    }

    public final void setDate(String link){
        this.getDateProperty().set(link);
    }
    
    public final BooleanProperty getIsSelected(){
        return this.isSelected;
    }
    
    public final void setIsSelected(Boolean isSelected){
        this.getIsSelected().set(isSelected);
    }
    
   
}
