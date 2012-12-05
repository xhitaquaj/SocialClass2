package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Region;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;
import gui.Friend;
import gui.FriendsList;
import javafx.scene.paint.Color;

public class JavaFXClient extends Application {
    final Button bt = new Button("Post");
    final TextField txt = new TextField();
    final ScrollBar sc = new ScrollBar();
    final ScrollBar sc2 = new ScrollBar();
    final ScrollBar sc3 = new ScrollBar();
    final Image[] images = new Image[5];
    final ImageView[] pics = new ImageView[5];
    final VBox vb = new VBox();//champ
    final VBox vb2 = new VBox();
    final DropShadow shadow = new DropShadow();
 
    @Override
    public void start(final Stage stage) {
        Group root = new Group();
        final Scene scene = new Scene(root);//fenetre
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
     	FriendsList friendlist=new FriendsList(stage);
	Friend friend=new Friend(friendlist.stack());
	Friend f=new Friend(friendlist.stack());
	friendlist.addFriend(friend);
	friendlist.addFriend(f);
	root.getChildren().addAll(friendlist.stack(), friendlist.scroll());

	/* root.getChildren().addAll(vb, sc, vb2, sc2, sc3);
 
        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
 
        vb.setTranslateX(5);
        vb.setSpacing(10);//espace vide

	vb2.setTranslateX(700);
	vb2.setSpacing(5);


	txt.setLayoutX(740);
	txt.setPrefHeight(30);
	txt.setPrefWidth(300);

	bt.setDefaultButton(true);//bouton avec valide avec la touche entree
	bt.setLayoutX(740);
	bt.setLayoutY(90);
	bt.setEffect(new Reflection());

        sc.setLayoutX(0);
        sc.setMin(20);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(720);//
        sc.setMax(1740);//contenu
 
	sc2.setLayoutX(500);
	sc2.setMin(20);
	sc2.setOrientation(Orientation.VERTICAL);
	sc2.setPrefHeight(720);
	sc2.setMax(1740);

	sc3.setLayoutX(900);
	sc3.setMin(20);
	sc3.setOrientation(Orientation.VERTICAL);
	sc3.setPrefHeight(720);
	sc3.setMax(1740);

	vb2.getChildren().add(txt);
	vb2.getChildren().add(bt);
        for (int i = 0; i < 5; i++) {
            final Image image = images[i] =
                new Image(getClass().getResourceAsStream(
                    "fw" +(i+1)+ ".jpg")
                );
            final ImageView pic = pics[i] =
                new ImageView(images[i]);
            pic.setEffect(shadow);
            vb.getChildren().add(pics[i]);
        }
 
        sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    vb.setLayoutY(-new_val.doubleValue());
            }
        });
        stage.show();
	stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		public void handle(WindowEvent we) {
		    System.out.println("Stage is closing");
		    stage.close();
		}
	    });        
	*/
	stage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
