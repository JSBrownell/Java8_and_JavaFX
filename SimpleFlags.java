//Brownell, Jessica
//CSIT 142, Spring 2016
//GUI Lab T1 - Flags


import java.util.Collections;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.shape.Rectangle;
public class SimpleFlags extends Application {
    
    @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {   
    // Create a pane
    Pane pane = new Pane();
    
    // Create rectangles and add to pane
    Rectangle r1 = new Rectangle(0, 0, 80, 160);
    r1.setStroke(Color.BLUE);
    r1.setFill(Color.BLUE);
    pane.getChildren().add(new Text(80, 175, "Flag of France"));
    pane.getChildren().add(r1);
    
    Rectangle r2 = new Rectangle(80, 0, 80, 160);
    r2.setStroke(Color.WHITE);
    r2.setFill(Color.WHITE);
    pane.getChildren().add(r2);
    
    Rectangle r3 = new Rectangle(160, 0, 80, 160);
    r3.setStroke(Color.RED);
    r3.setFill(Color.RED); 
    pane.getChildren().add(r3);
    
    Rectangle r4 = new Rectangle(0, 200, 240, 50);
    r4.setStroke(Color.BLACK);
    r4.setFill(Color.BLACK);
    pane.getChildren().add(r4);
    
    Rectangle r5 = new Rectangle(0, 250, 240, 50);
    r5.setStroke(Color.RED);
    r5.setFill(Color.RED);
    pane.getChildren().add(r5);
    
    
    Rectangle r6 = new Rectangle(0, 300, 240, 50);
    r6.setStroke(Color.YELLOW);
    r6.setFill(Color.YELLOW);
     pane.getChildren().add(new Text(75, 365, "Flag of Germany"));
    pane.getChildren().add(r6);
    
    
    
     Rectangle r7 = new Rectangle(0, 380, 60, 150);
    r7.setStroke(Color.RED);
    r7.setFill(Color.RED);
    pane.getChildren().add(new Text(50, 545, "Flag of United Arab Emirates"));
    pane.getChildren().add(r7);
    
    
     Rectangle r8 = new Rectangle(60, 380,180, 50);
    r8.setStroke(Color.GREEN);
    r8.setFill(Color.GREEN);
    pane.getChildren().add(r8);
    
    Rectangle r9 = new Rectangle(60, 430, 180, 50);
    r9.setStroke(Color.WHITE);
    r9.setFill(Color.WHITE);
    pane.getChildren().add(r9);
    
    
    Rectangle r10 = new Rectangle(60, 480, 180, 50);
    r10.setStroke(Color.BLACK);
    r10.setFill(Color.BLACK);
    pane.getChildren().add(r10);
 
    
     // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 700, 700);
    primaryStage.setTitle("ShowRectangle"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
    
    
    public static void main(String[] args) {
	// TODO Auto-generated method stub
launch(args);
    }

}