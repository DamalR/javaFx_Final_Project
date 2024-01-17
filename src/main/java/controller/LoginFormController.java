package controller;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;



public class LoginFormController {

    @FXML
    private BorderPane pane;

    @FXML
    private Label lblUsername;

    @FXML
    private TextField txtFeildUsername;

    @FXML
    private Label lblPassword;

    @FXML
    private TextField txtFeildPassword;

    @FXML
    private CheckBox checkBoxRememberMe;

    @FXML
    private JFXButton btnLogin;


    public void loginButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }
}
