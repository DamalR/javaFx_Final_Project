package controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DashboardFormController {


    public BorderPane pane;
    public BorderPane pane1;
    public AnchorPane mainAnchor;
    public Label lblTime;
    public Label lblDate;
    @FXML
    private Button btnHome;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnItemCategory;

    @FXML
    private Button btnItem;

    @FXML
    private Button btnUser;

    @FXML
    private Button btnReport;

    @FXML
    private Label txtTitle;
    private EmbeddedWindow primaryStage;
    public void initialize(){
        calculateTime();
        loadDate();
    }
    private void calculateTime() {
        Timeline timeline = new Timeline(new KeyFrame(
                javafx.util.Duration.ZERO,
                actionEvent -> lblTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
        ), new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    private void loadDate() {
        Date date = new Date();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(f.format(date));
    }


    public void homeButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.homeCaller(stage);
    }

    public void orderButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.orderCaller(stage);
    }

    public void itemCategoryButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.itemCategoryCaller(stage);
    }

    public void itemButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.itemCaller(stage);
    }

    public void userButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.userCaller(stage);
    }

    public void reportButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.reportCaller(stage);
    }
}

