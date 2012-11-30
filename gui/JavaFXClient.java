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
import javafx.scene.paint.Color;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Region;

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
    DropShadow shadow = new DropShadow();
 
    @Override
    public void start(Stage stage) {
        Region root = new Region();
        Scene scene = new Scene(root, 1280, 680);//fenetre
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Scrollbar");
        //root.getChildren().addAll(vb, sc, vb2, txt, bt, sc2, sc3);
 
        shadow.setColor(Color.GREY);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);
 
        vb.setLayoutX(5);
        vb.setSpacing(10);//espace vide

	vb2.setLayoutX(500);
	vb2.setSpacing(5);

	txt.setLayoutX(540);
	txt.setPrefHeight(30);
	txt.setPrefWidth(300);

	bt.setDefaultButton(true);//bouton avec valide avec la touche entree
	bt.setLayoutX(640);
	bt.setLayoutY(50);
	bt.setEffect(new Reflection());

        sc.setLayoutX(0/*scene.getWidth()-sc.getWidth()*/);//position de la barre
        sc.setMin(20);
        sc.setOrientation(Orientation.VERTICAL);
        sc.setPrefHeight(720);//barre
        sc.setMax(1740);//contenu
 
	sc2.setLayoutX(600);
	sc2.setMin(20);
	sc2.setOrientation(Orientation.VERTICAL);
	sc2.setPrefHeight(720);
	sc2.setMax(1740);

	sc3.setLayoutX(900);
	sc3.setMin(20);
	sc3.setOrientation(Orientation.VERTICAL);
	sc3.setPrefHeight(720);
	sc3.setMax(1740);

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
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}