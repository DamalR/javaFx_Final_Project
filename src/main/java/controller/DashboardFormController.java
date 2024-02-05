package controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class DashboardFormController {


    public BorderPane pane;
    public BorderPane pane1;
    public AnchorPane mainAnchor;
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
//        calculateTime();
    }
    //    private void calculateTime() {
//        Timeline timeline = new Timeline(new KeyFrame(
//                Duration.ZERO,
////                actionEvent -> lblTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
//        ), new KeyFrame(Duration.seconds(1)));
//
//        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();
//    }


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

    }
}

