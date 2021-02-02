// import Cars.AudiURQuattro;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;



public class Presentation extends Application {

    List<Vehicle> cars = new ArrayList<>();

    private void setupCar(int carChoice, Stage stage) {
        Button btGas = new Button("Gas");
        Button btBreak = new Button("Break");
        Button btMove = new Button("Move");
        Button btLeft = new Button("Left");
        Button btRight = new Button("Right");

        BorderPane pane = new BorderPane();

        VBox vBox = new VBox();

        Menu menu = new Menu("Cars");

        MenuItem item1 = new MenuItem("Saab95");
        MenuItem item2 = new MenuItem("Volvo240");
        MenuItem item3 = new MenuItem("AudiQuattro");

        CheckBox chTurbo = new CheckBox("turbo");

        CheckBox chEngine = new CheckBox("EngineOn");

        menu.getItems().addAll(item1, item2, item3);
        MenuBar menuBar = new MenuBar(menu);
        vBox.getChildren().add(menuBar);

        // Top pane
        if (cars.get(carChoice) instanceof AuxTrim && cars.get(carChoice) instanceof AuxTurbo) {
            vBox.getChildren().add(new CustomPane(cars.get(carChoice).getModelName() + " got both trim and a turbo."));
            vBox.getChildren().add(chTurbo);
            vBox.getChildren().add(chEngine);
        } else if (cars.get(carChoice) instanceof AuxTrim) {
            vBox.getChildren().add(new CustomPane(cars.get(carChoice).getModelName() + " with Trim"));
            vBox.getChildren().add(chEngine);
        } else if (cars.get(carChoice) instanceof AuxTurbo) {
            vBox.getChildren().add(new CustomPane(cars.get(carChoice).getModelName() + " with Turbo"));
            vBox.getChildren().add(chTurbo);
            vBox.getChildren().add(chEngine);
        } else {
            vBox.getChildren().add(new CustomPane(cars.get(carChoice).getModelName() + " is a poor car without turbo or trim."));
            vBox.getChildren().add(chEngine);
        }

        pane.setTop(vBox);

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
        SpeedPane speedPane = new SpeedPane(cars.get(carChoice));
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
        stage.setTitle("Presentation of " + cars.get(carChoice).getModelName());
        stage.setScene(scene);
        stage.show();


        // Event handlers
        btGas.setOnAction(e -> {
            cars.get(carChoice).gas(1.0);
            speedPane.setSpeed(cars.get(carChoice).getCurrentSpeed());
            System.out.println("Gas pressed (1.0)");
        });

        btBreak.setOnAction(e -> {
            cars.get(carChoice).brake(1.0);
            speedPane.setSpeed(cars.get(carChoice).getCurrentSpeed());
            System.out.println("Break pressed (1.0)");
        });

        btMove.setOnAction(e -> {
            cars.get(carChoice).move();
            System.out.println("Move pressed\n" + "Speed: " + cars.get(carChoice).getCurrentSpeed() +
                    " - x-pos: " + cars.get(carChoice).getPosition().getX() +
                    " y-pos: " + cars.get(carChoice).getPosition().getY());
        });

        btLeft.setOnAction(e -> {
            cars.get(carChoice).turnLeft();
            System.out.println("Left pressed\n" + cars.get(carChoice).getCurrentSpeed());
        });

        btRight.setOnAction(e -> {
            cars.get(carChoice).turnRight();
            System.out.println("Right pressed\n" + cars.get(carChoice).getCurrentSpeed());
        });

        item1.setOnAction(e -> {
            stage.close();
            setupCar(0,stage);

        });

        item2.setOnAction(e -> {
            stage.close();
            setupCar(1,stage);

        });

        item3.setOnAction(e -> {
            stage.close();
            setupCar(2,stage);
        });

        chTurbo.setOnAction( e -> {
            if (chTurbo.isSelected()) {
                ((AuxTurbo) cars.get(carChoice)).setTurboOn();
                System.out.println("Turbo on");
            } else {
                ((AuxTurbo) cars.get(carChoice)).setTurboOff();
                System.out.println("Turbo off");
            }
        });

        chEngine.setOnAction( e -> {
            if (chEngine.isSelected()) {
                cars.get(carChoice).startEngine();
                speedPane.setSpeed(cars.get(carChoice).getCurrentSpeed());
                System.out.println("Engine on");
            } else {
                cars.get(carChoice).stopEngine();
                speedPane.setSpeed(cars.get(carChoice).getCurrentSpeed());
                System.out.println("Engine off");
            }
        });
    }

    @Override
    public void start(Stage stage) throws Exception {

        cars.add(new Saab95());
        cars.add(new Volvo240());
        // cars.add(new AudiURQuattro());

        setupCar(0,stage);

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
    private Vehicle c; // bind this car to start car ?

    public SpeedPane(Vehicle car) {
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
