package controller;

import com.sun.javafx.stage.EmbeddedWindow;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DashboardFormController {


    public BorderPane pane;
    public BorderPane pane1;
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
    }
    private void calculateTime() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.ZERO,
                actionEvent -> lblTime.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
        ), new KeyFrame(Duration.seconds(1)));

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    @FXML
    void homeButtonOnAction(ActionEvent event) {

    }

    @FXML
    void itemButtonOnAction(ActionEvent event) {

    }

    @FXML
    void itemCategoryButtonOnAction(ActionEvent event) {

    }

    @FXML
    void orderButtonOnAction(ActionEvent event) {

    }

    @FXML
    void reportButtonOnAction(ActionEvent event) {

    }

    @FXML
    void userButtonOnAction(ActionEvent event) {

    }

    public void homeButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane1.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.setTitle("Customer Form");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void orderButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/OrderForm.fxml"))));
            stage.setTitle("Customer Form");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void itemCategoryButtonOnAction(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemCategoryForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void itemButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ItemForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/RegisterForm.fxml"))));
            stage.setTitle("Customer Form");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void reportButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }
}

