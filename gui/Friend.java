package gui;

import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Friend extends Parent{

    private Image image;
    private ImageView pic;

    public Friend(VBox stack){
	this(stack,"default_friend_pic.jpg");
    }
    
    public Friend(VBox stack, String image_name){
	loadImage(image_name);
	loadImageView();
	pic.setPreserveRatio(true);
	DropShadow shadow = new DropShadow();
	shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
	pic.setEffect(shadow);
	adjustHeight(stack);
	adjustWidth(stack);
    }

    public ImageView pic(){
	return pic;
    }    
    
    private void loadImage(String image_name){
	image = new Image(getClass().getResourceAsStream(image_name));
    }
    
    private void loadImageView(){
	pic = new ImageView(image);
    }

    private void adjustWidth(VBox sp){
	sp.widthProperty().addListener(new ChangeListener<Number>(){
		public void changed(ObservableValue<? extends Number> obervable,
				    Number oldValue, Number newValue){
		    Double width = (Double)newValue;
		    pic.setFitWidth(width);
		}
	    });
    }

    private void adjustHeight(VBox sp){
	sp.heightProperty().addListener(new ChangeListener<Number>(){
		public void changed(ObservableValue<? extends Number> obervable,
				    Number oldValue, Number newValue){
		    Double height = (Double)newValue;
		    // pic.setFitHeight(height*0.2);
		}
	    });	
    }

}
