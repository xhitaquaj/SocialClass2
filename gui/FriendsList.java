package gui;

import javafx.geometry.Orientation;
import javafx.scene.control.ScrollBar;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import java.util.*;

public class FriendsList extends Parent{
    
    private VBox stack;
    private ScrollBar scroll;
    private List<Friend> friends;;

    public FriendsList(Stage sc){
	stack = new VBox();
	scroll = new ScrollBar();
	friends = new ArrayList<Friend>();
	initializeScroll();
	adjustWidth(sc);
	adjustHeight(sc);
	bindScroll();
	stack.setSpacing(5);
    }

    private void bindScroll(){
	scroll.valueProperty().addListener(new ChangeListener<Number>() {
		public void changed(ObservableValue<? extends Number> ov,
				    Number old_val, Number new_val) {
                    stack.setLayoutY(-new_val.doubleValue());
		}
        });
    }

    private void initializeScroll(){
	scroll.setLayoutX(0);
	scroll.setMin(20);
        scroll.setOrientation(Orientation.VERTICAL);
        scroll.setPrefHeight(720);//
        //scroll.setMax(1740);//contenu
    }

    public VBox stack(){
	return stack;
    }

    public ScrollBar scroll(){
	return scroll;
    }

    private void adjustWidth(Stage s){
	s.widthProperty().addListener(new ChangeListener<Number>(){
		public void changed(ObservableValue<? extends Number> obervable,
				    Number oldValue, Number newValue){
		    Double width = (Double)newValue;
		    stack.setPrefWidth(width*0.3);
		    stack.setMaxWidth(width*0.3);
		    stack.setMinWidth(width*0.3);
		}
	    });
    }

    private void adjustHeight(Stage s){
	s.heightProperty().addListener(new ChangeListener<Number>(){
		public void changed(ObservableValue<? extends Number> obervable,
				    Number oldValue, Number newValue){
		    Double height = (Double)newValue;
		    stack.setPrefHeight(height);
		    scroll.setPrefHeight(height);
		}
	    });	
    }

    private void adjustPosition(){
	for(Friend f : friends){
	    
	}
    }        

    public void addFriend(Friend f){
	int s=friends.size();	
	friends.add(f);

	stack.getChildren().add(friends.get(s).pic());
    }
}
