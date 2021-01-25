import javafx.application.Application;
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
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Presentation extends Application {
    private Car car = new AudiURQuattro();
    // private Car car = new Volvo240();
    // private Car car = new Saab95();

    @Override
    public void start(Stage stage) throws Exception {

        Button btGas = new Button("Gas");
        Button btBreak = new Button("Break");
        Button btMove = new Button("Move");


        BorderPane pane = new BorderPane();

        // Top pane
        if (car instanceof AuxTrim && car instanceof AuxTurbo) {
            pane.setTop(new CustomPane("Trim and turbo"));
        } else if (car instanceof AuxTrim) {
            pane.setTop(new CustomPane("Trim"));
        } else if (car instanceof AuxTurbo) {
            pane.setTop(new CustomPane("Turbo"));
        } else {
            pane.setTop(new CustomPane("Poor car without turbo or trim."));
        }

        // Left pane
        pane.setLeft(new CustomPane("Turn left"));

        // Right pane
        pane.setRight(new CustomPane("Turn right"));


        // Bottom pane (gas, move, break)
        HBox centerBox = new HBox();
        centerBox.setSpacing(20);
        centerBox.setAlignment(Pos.CENTER);
        SpeedPane speedPane = new SpeedPane(car);
        centerBox.getChildren().add(speedPane);
        pane.setCenter(centerBox);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(btGas);
        hBox.getChildren().add(btMove);
        hBox.getChildren().add(btBreak);
        pane.setBottom(hBox);



        // make scene
        Scene scene = new Scene(pane);
        stage.setTitle("Presentation of Car");
        stage.setScene(scene);
        stage.show();

        // Event handlers
        btGas.setOnAction(e -> {
            car.gas(0.2);
            speedPane.setSpeed(car.getCurrentSpeed());
            System.out.println("Gas pressed");
        });

        btBreak.setOnAction(e -> {
            car.brake(0.2);
            speedPane.setSpeed(car.getCurrentSpeed());
            System.out.println("Break pressed");
        });

        btMove.setOnAction(e -> {
            car.move();
            System.out.println("Move pressed\n" + car.getCurrentSpeed());
        });


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
    private Car c; // bind this car to start car ?

    public SpeedPane(Car car) {
        this.c = car;
        setSpeed(c.getCurrentSpeed());
    }

    public void setSpeed(double speed) {
        this.speed = speed;
        paint();
    }

    private void paint() {

        double rectHeight = 30;
        double rectWidth = 100;
        double speedPercent = c.getCurrentSpeed();


        Rectangle rectangle = new Rectangle(0, 0, rectWidth, rectHeight);
        rectangle.setFill(Color.WHITE);
        rectangle.setStroke(Color.BLACK);
        // faktor 10 ligger där för att man skall se att något händer..
        Rectangle speed = new Rectangle(0, 0, speedPercent * 10, rectHeight);
        speed.setFill(Color.RED);

        Label speedText = new Label("Speed: " + c.getCurrentSpeed());
        speedText.setAlignment(Pos.CENTER);


        getChildren().clear();
        getChildren().addAll(rectangle, speed);

    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        paint();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        paint();
    }
}


class TurboPane extends Pane {
    private boolean turboOn = false;

    public void paint() {
        // make checkbox with turbo.
        // show turbo effect.
        Label turboLabel = new Label("This car has a turbo.");
        turboLabel.setAlignment(Pos.CENTER);

        getChildren().clear();
        getChildren().addAll(turboLabel);
    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        paint();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        paint();
    }
}


class TrimPane extends Pane {

    public void paint() {
        // show trim.
        // show trim effect.
        Label trimLabel = new Label("This car has a trim mod.");
        trimLabel.setAlignment(Pos.CENTER);

        getChildren().clear();
        getChildren().addAll(trimLabel);
    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        paint();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        paint();
    }
}
