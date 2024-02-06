package controller;

import com.jfoenix.controls.JFXButton;
import dao.util.*;
import db.DBConnection;
import entity.Employee;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;

import java.sql.SQLException;

import static dao.util.HibernateUtil.validateUser;


public class LoginFormController {

    public Label lblEmail;

    public TextField txtFiledEmail;
    public Hyperlink hyperLinkForgotPassword;
    @FXML

    private BorderPane pane;
    @FXML

    private Label lblPassword;

    @FXML
    private TextField txtFeildPassword;

    @FXML
    private CheckBox checkBoxRememberMe;

    @FXML
    private JFXButton btnLogin;


    public void loginButtonOnAction(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        Window owner = btnLogin.getScene().getWindow();

        if (txtFiledEmail.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter your email");
            return;
        }
        if (txtFeildPassword.getText().isEmpty()){
            showAlert(Alert.AlertType.ERROR,owner,"Form Error!","Please enter a password");
            return;
        }

        String email = txtFiledEmail.getText();
        String password = txtFeildPassword.getText();

        boolean flag = validateUser(email, password);

        if (!flag) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        } else {
            infoBox("Login Successful!", null, "Failed");
            Stage stage = (Stage) pane.getScene().getWindow();
            ButtonControllers.homeCaller(stage);
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }
}
