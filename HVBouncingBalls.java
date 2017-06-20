//Brownell, Jessica
//CSIT 142, Spring 2016
//GUI Lab T5


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HVBouncingBalls extends Application{

    final int maxBalls = 8;
    int ballCount = 0;
    double hortX = 20.0;
    double hortY = 20.0;
    double vertX = 20.0;
    double vertY = 20.0;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        MultipleBallPane ballPane = new MultipleBallPane();
        ballPane.setStyle("-fx-border-color: yellow");

        Button btAdd = new Button("+");
        Button btSubtract = new Button("-");
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(btAdd, btSubtract);
        hBox.setAlignment(Pos.CENTER);

        // Add or remove a ball
        btAdd.setOnAction(e -> {
                if(ballCount<maxBalls){
                    if(ballCount%2 == 0){
                        ballPane.add(hortX, hortY+(30*ballCount), 'h');
                    }
                    else{
                        ballPane.add(vertX+(30*ballCount), vertY, 'v');
                    }
                    ballCount++;}
            }
        );
        btSubtract.setOnAction(e -> {
                ballPane.subtract();
                ballCount--;}
        );

        // Pause and resume animation
        ballPane.setOnMousePressed(e -> ballPane.pause());
        ballPane.setOnMouseReleased(e -> ballPane.play());

        // Use a scroll bar to control animation speed
        ScrollBar sbSpeed = new ScrollBar();
        sbSpeed.setMax(20);
        sbSpeed.setValue(10);
        ballPane.rateProperty().bind(sbSpeed.valueProperty());

        BorderPane pane = new BorderPane();
        pane.setCenter(ballPane);
        pane.setTop(sbSpeed);
        pane.setBottom(hBox);

        // Create a scene and place the pane in the stage
        Scene scene = new Scene(pane, 600, 400);
        primaryStage.setTitle("Follow the Horizontal & Vertical Bouncing Balls"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    private class MultipleBallPane extends Pane {
    private Timeline animation;

    public MultipleBallPane() {
      // Create an animation for moving the ball
      animation = new Timeline(
        new KeyFrame(Duration.millis(50), e -> moveBall()));
      animation.setCycleCount(Timeline.INDEFINITE);
      animation.play(); // Start animation
    }

    public void add(double xcoord, double ycoord, char vhdir) {
      Color color = new Color(Math.random(), 
        Math.random(), Math.random(), 0.5);
      getChildren().add(new Ball(xcoord, ycoord, 20, color, vhdir)); 
    }
    
    public void subtract() {
      if (getChildren().size() > 0) {
        getChildren().remove(getChildren().size() - 1); 
      }
    }

    public void play() {
      animation.play();
    }

    public void pause() {
      animation.pause();
    }

    public void increaseSpeed() {
      animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
      animation.setRate(
        animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
      return animation.rateProperty();
    }

    protected void moveBall() {
      for (Node node: this.getChildren()) {
        Ball ball = (Ball)node;
        // Check boundaries
        if (ball.getCenterX() < ball.getRadius() || 
            ball.getCenterX() > getWidth() - ball.getRadius()) {
          ball.dx *= -1; // Change ball move direction
        }
        if (ball.getCenterY() < ball.getRadius() || 
            ball.getCenterY() > getHeight() - ball.getRadius()) {
          ball.dy *= -1; // Change ball move direction
        }

        // Adjust ball position
        if (ball.direction == 'h')
        ball.setCenterX(ball.dx + ball.getCenterX());
        else
        ball.setCenterY(ball.dy + ball.getCenterY());
        
      //  if ( ball.intersects (ball2(getBoundsInLocal())) ){
        //    ball.autoReverse();}
      }
    
    }
}
  

  class Ball extends Circle {
    private double dx = 1, dy = 1;
    private char direction;

    Ball(double x, double y, double radius, Color color, char dir) {
      super(x, y, radius);
      setFill(color); // Set ball color
      direction = dir;
    }
    
    
  }

    public static void main(String[] args) {
        launch(args);
    }
}
