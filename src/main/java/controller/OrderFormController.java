package controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Objects;

public class OrderFormController {

    public Tab tabAddCustomer;
    public Text txtAddress;
    public Text txtContactNumber;
    public Text txtEmail;
    public Text txtCustomerId;
    public TextField txtFieldEmail;
    public TextField txtFiledAddress;
    public Tab tabUpdateCustomer;
    public TableColumn colCustomerId;
    public TableColumn colName;
    public TableColumn colContactNumber;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colDelete;
    public Text txtSearchCustomerT2;
    public TextField txtFieldSearchCustomerT2;
    public Button btnSearchCustomerT2;
    public BorderPane pane;
    @FXML
    private BorderPane pane2;

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
    private Tab tabPlaceOrder;

    @FXML
    private Text txtSearchCustomer;

    @FXML
    private TextField txtFieldSearchCustomer;

    @FXML
    private Button btnSearchCustomer;

    @FXML
    private Text txtOrderId;

    @FXML
    private TextField txtFieldOrderId;

    @FXML
    private Text txtCustomerName;

    @FXML
    private Text txtCustomerContactNum;

    @FXML
    private TextField txtFieldCustomerName;

    @FXML
    private TextField txtFieldCustomerContactNum;

    @FXML
    private Text txtItemCategory;

    @FXML
    private Text txtItemName;

    @FXML
    private Text txtFault;

    @FXML
    private Text txtDescription;

    @FXML
    private TextField txtFieldItemName;

    @FXML
    private TextField txtFiledFault;

    @FXML
    private TextField txtFieldDescription;

    @FXML
    private Button btnPlaceOrder;

    @FXML
    private ComboBox<?> comboBoxItemCategory;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Button btnAddItem;

    @FXML
    private Tab tabDeleteOrder;

    @FXML
    private TableView<?> tblEmpDetilas;

    @FXML
    private TableColumn<?, ?> colOrderIdT1;

    @FXML
    private TableColumn<?, ?> colNameT1;

    @FXML
    private TableColumn<?, ?> colCategoryT1;

    @FXML
    private TableColumn<?, ?> colItemNameT1;

    @FXML
    private TableColumn<?, ?> colFaultT1;

    @FXML
    private TableColumn<?, ?> colDeleteT1;

    @FXML
    private Text txtSearchOrder;

    @FXML
    private Button btnSearchOrder;

    @FXML
    private Tab tabChangeOrder;

    @FXML
    private TableView<?> tblEmpDetilas1;

    @FXML
    private TableColumn<?, ?> colOrderIdT2;

    @FXML
    private TableColumn<?, ?> colNameT2;

    @FXML
    private TableColumn<?, ?> colCategoryT2;

    @FXML
    private TableColumn<?, ?> colItemNameT2;

    @FXML
    private TableColumn<?, ?> colFaultT2;

    @FXML
    private TableColumn<?, ?> colChangeStatusT2;

    @FXML
    private Text txtSearchOrderT2;

    @FXML
    private TextField txtFieldOrderIdT2;

    @FXML
    private Button btnSearchOrderT2;

    @FXML
    private Label txtTitle;

    @FXML
    void OrderButtonOnAction(ActionEvent event) {

    }

    @FXML
    void addCustomerButtonOnAction(ActionEvent event) {

    }

    @FXML
    void addItemButtonOnAction(ActionEvent event) {

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
    void placeOrderButtonOnAction(ActionEvent event) {

    }

    @FXML
    void reportButtonOnAction(ActionEvent event) {

    }

    @FXML
    void searchButtonOnAction(ActionEvent event) {

    }

    @FXML
    void userButtonOnAction(ActionEvent event) {

    }




    public void homeButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void OrderButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void itemCategoryButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void itemButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void userButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void reportButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void placeOrderButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void addCustomerButtonOnAction(javafx.event.ActionEvent actionEvent) {

        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/AddCustomerForm.fxml")))));
            stage.setTitle("Customer Form");
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void addItemButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void searchButtonOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void searchButtonOnActionT2(javafx.event.ActionEvent actionEvent) {

    }

    public void SearchButtonOnActionT1(javafx.event.ActionEvent actionEvent) {
    }
}

