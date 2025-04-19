package org.example.academyfx_mvc.Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Direction {
    private final IntegerProperty direction_id;
    private final StringProperty direction_name;

    public Direction(Integer direction_id, String direction_name) {
        this.direction_id = new SimpleIntegerProperty(direction_id);
        this.direction_name = new SimpleStringProperty(direction_name);
    }
    public IntegerProperty directionIdProperty(){
        return direction_id;
    }
    public final Integer getDirectionId()
    {
        return direction_id.get();
    }
    public final void setDirectionId(Integer direction_id){
        this.direction_id.set(direction_id);
    }
    public StringProperty directionNameProperty()
    {
        return direction_name;
    }
    public final String getDirectionName(){
        return direction_name.get();
    }
    public final void setDirectionName(String direction_name){
        this.direction_name.set(direction_name);
    }
}
