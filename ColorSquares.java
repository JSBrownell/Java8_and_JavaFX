//Brownell, Jessica
//CSIT 142, Spring 2016
//GUI Lab T4


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ColorSquares extends Application {

    @Override
    public void start(Stage primaryStage){
        GridPane pane = new GridPane(); 
      // pane.setGridLinesVisible(true);
        pane.setPadding(new Insets(5,5,5,5));
        pane.setAlignment(Pos.CENTER);

        final int numRows = 8;
        final int numCols = 8;

        for (int row=0; row< numRows; row++){
            for (int col=0; col< numCols; col++){
                ColorPane cp = new ColorPane();
                cp.setOnMouseClicked(e-> {
                  cp.changeColor();
                });
                pane.add(cp, col, row);
            }
        }

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Fun with Colors! Yayy!"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.setResizable(false);
        primaryStage.show(); // Display the stage

    }

    public class ColorPane extends StackPane  {

        private Rectangle colorSquare = new Rectangle();

        public ColorPane(){
            getChildren().add(colorSquare);
            colorSquare.setStroke(Color.GRAY);
            colorSquare.setFill(Color.WHITE);
            colorSquare.setWidth(60);
            colorSquare.setHeight(60);               
        } 

        public void changeColor(){
            colorSquare.setFill(Color.color(Math.random(), Math.random(), 
          Math.random()));
        }        
    }
      
    public static void main(String[] args) {
        launch(args);
    }
}