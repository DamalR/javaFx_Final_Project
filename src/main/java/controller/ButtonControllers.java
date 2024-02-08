package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ButtonControllers {

    public static BorderPane pane;

    public static void homeCaller(Stage stage){
        try {
            stage.setScene(new Scene(FXMLLoader.load(ButtonControllers.class.getResource("/view/DashboardForm.fxml"))));
            stage.setTitle("Home");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void orderCaller(Stage stage) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(ButtonControllers.class.getResource("/view/OrderForm.fxml"))));
            stage.setTitle("Order Form");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void itemCategoryCaller(Stage stage) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(ButtonControllers.class.getResource("/view/ItemCategoryForm.fxml"))));
            stage.setTitle("ItemCategory Form");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void itemCaller(Stage stage) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(ButtonControllers.class.getResource("/view/ItemForm.fxml"))));
            stage.setTitle("Item Form");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void userCaller(Stage stage) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(ButtonControllers.class.getResource("/view/RegisterForm.fxml"))));
            stage.setTitle("User Form");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void reportCaller(Stage stage) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(ButtonControllers.class.getResource("/view/ReportsForm.fxml"))));
            stage.setTitle("Report Form");
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
