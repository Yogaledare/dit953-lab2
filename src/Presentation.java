import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class Presentation extends Application {
    // private Car car = new AudiURQuattro();
    private Car car = new Volvo240();
    // private Car car = new Saab95();

    @Override
    public void start(Stage stage) throws Exception {

        Button btGas = new Button("Gas");
        Button btBreak = new Button("Break");
        Button btMove = new Button("Move");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");


        BorderPane pane = new BorderPane();

        // Top pane
        if (car instanceof AuxTrim && car instanceof AuxTurbo) {
            pane.setTop(new CustomPane(car.getModelName() + " got both trim and a turbo."));
        } else if (car instanceof AuxTrim) {
            pane.setTop(new CustomPane(car.getModelName() + " with Trim"));
        } else if (car instanceof AuxTurbo) {
            pane.setTop(new CustomPane(car.getModelName() + " with Turbo"));
        } else {
            pane.setTop(new CustomPane(car.getModelName() + " is a poor car without turbo or trim."));
        }

        // Left pane
        VBox leftBox = new VBox();
        leftBox.setSpacing(20);
        leftBox.setAlignment(Pos.CENTER);
        leftBox.getChildren().add(btLeft);
        pane.setLeft(leftBox);

        // Right pane
        VBox rightBox = new VBox();
        rightBox.setSpacing(20);
        rightBox.setAlignment(Pos.CENTER);
        rightBox.getChildren().add(btRight);
        pane.setRight(rightBox);


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
            car.gas(1.0);
            speedPane.setSpeed(car.getCurrentSpeed());
            System.out.println("Gas pressed (1.0)");
        });

        btBreak.setOnAction(e -> {
            car.brake(1.0);
            speedPane.setSpeed(car.getCurrentSpeed());
            System.out.println("Break pressed (1.0)");
        });

        btMove.setOnAction(e -> {
            car.move();
            System.out.println("Move pressed\n" + car.getCurrentSpeed() +
                    " - x-pos: " + car.getPosition().getX() +
                    " y-pos: " + car.getPosition().getY()  ) ;
        });

        btLeft.setOnAction(e -> {
            car.turnLeft();
            System.out.println("Left pressed\n" + car.getCurrentSpeed());
        });

        btRight.setOnAction(e -> {
            car.turnRight();
            System.out.println("Right pressed\n" + car.getCurrentSpeed());
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
        Rectangle speed = new Rectangle(0, 0, (speedPercent * rectWidth) / c.getEnginePower(), rectHeight);
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
