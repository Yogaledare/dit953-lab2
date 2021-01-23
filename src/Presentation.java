import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import javafx.stage.Stage;


public class Presentation extends Application {
    private Car car = new Volvo240();

    @Override
    public void start(Stage stage) throws Exception {

        Button btGas = new Button("Gas");
        GasHandlerEvent handleGas = new GasHandlerEvent();
        btGas.setOnAction(handleGas);

        Button btBreak = new Button("Break");
        BreakHandlerEvent handleBreak = new BreakHandlerEvent();
        btBreak.setOnAction(handleBreak);

        Button btMove = new Button("Move");
        MoveHandlerEvent handleMove = new MoveHandlerEvent();
        btMove.setOnAction(handleMove);


        BorderPane pane = new BorderPane();
        pane.setTop(new CustomPane("Top"));
        pane.setLeft(new CustomPane("Turn left"));

        HBox centerBox = new HBox();
        centerBox.setSpacing(20);
        centerBox.setAlignment(Pos.CENTER);

        // draw the rectangle with a bar to show speed
        SpeedPane speedPane = new SpeedPane(car);

        centerBox.getChildren().add(speedPane);

        pane.setCenter(centerBox);

        pane.setRight(new CustomPane("Turn right"));

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(btGas);
        hBox.getChildren().add(btMove);
        hBox.getChildren().add(btBreak);

        pane.setBottom(hBox);

        Scene scene = new Scene(pane);
        stage.setTitle("Presentation of Cars");
        stage.setScene(scene);
        stage.show();
    }

    class GasHandlerEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            car.gas(0.2);
            // todo - Tell speedPane to repaint


            System.out.println("Gas pressed");
        }
    }

    class BreakHandlerEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            car.brake(0.2);
            System.out.println("Break pressed");
        }
    }

    class MoveHandlerEvent implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            car.move();
            System.out.println("Move pressed\n" + car.getCurrentSpeed());
        }
    }

}




class CustomPane extends StackPane {
    public CustomPane(String title) {
        getChildren().add(new Label(title));
        setStyle("-fx-border-color: red"); // debug
        setPadding(new Insets(15, 15, 15, 15));

    }
}


class SpeedPane extends Pane {

    private double speed;
    private Car c;

    public SpeedPane(Car car) {
        this.c = car;
        setSpeed(c.getCurrentSpeed());
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        paintSpeed();
    }

    private void paintSpeed() {

        double rectHeight = 30;
        double rectWidth = 100;
        double speedPercent = c.getCurrentSpeed();


        Rectangle rectangle = new Rectangle(0, 0, rectWidth, rectHeight);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        Rectangle speed = new Rectangle(0, 0, speedPercent*10, rectHeight);
        speed.setFill(Color.RED);

        Label speedText = new Label("Speed: " + c.getCurrentSpeed());
        speedText.setAlignment(Pos.CENTER);


        getChildren().clear();

        getChildren().addAll(rectangle, speed);

    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        paintSpeed();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        paintSpeed();
    }
}

