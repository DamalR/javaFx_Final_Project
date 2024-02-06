package controller;


import bo.BoFactory;
import bo.custom.OrdersBo;
import com.jfoenix.controls.JFXTextField;
import dao.util.BoType;
import dao.util.HibernateUtil;
import dto.OrdersDto;
import entity.Employee;
import entity.Orders;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
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
    public TextField txtFieldOrderIdT1;
    public TextField txtFieldDate;
    public JFXTextField textFieldItemCategory;
    public TextField textFieldItemCategory1;
    public Label lblOrderId;
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

    public void initialize(){
        generateOrderId();
    }

    private OrdersBo ordersBo = BoFactory.getInstance().getBo(BoType.ORDERS);
    public void homeButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.homeCaller(stage);
    }

    public void OrderButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.homeCaller(stage);
    }

    public void itemCategoryButtonOnAction(javafx.event.ActionEvent actionEvent) {
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

    public void placeOrderButtonOnAction(javafx.event.ActionEvent actionEvent) {
        try {
            boolean isSaved = ordersBo.saveOrders(
                    new OrdersDto(lblOrderId.getText(),
                            txtFieldCustomerName.getText(),
                            txtFieldCustomerContactNum.getText(),
                            textFieldItemCategory1.getText(),
                            txtFieldItemName.getText(),
                            txtFiledFault.getText(),
                            txtFieldDate.getText(),
                            txtFieldDescription.getText(),
                            txtFieldEmail.getText(),
                            "Pending"
                    ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Order Saved!").show();
                generateOrderId();
                clearFields();
            }
        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtFieldCustomerName.clear();
        txtFieldCustomerContactNum.clear();
        textFieldItemCategory1.clear();
        txtFieldItemName.clear();
        txtFiledFault.clear();
        txtFieldDate.clear();
        txtFieldDescription.clear();
        txtFieldEmail.clear();

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

    public void generateOrderId() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query<Orders> query = session.createQuery("FROM Orders ORDER BY orderId DESC");
            query.setMaxResults(1);
            List<Orders> resultList = query.getResultList();

            if (!resultList.isEmpty()) {
                String id = resultList.get(0).getOrderId();
                if (!id.isEmpty() && id.matches("D\\d{3}")) {
                    int num = Integer.parseInt(id.substring(1)) + 1;
                    lblOrderId.setText(String.format("D%03d", num));
                } else {
                    lblOrderId.setText("D001");
                }
            } else {
                lblOrderId.setText("D001");
            }
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
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

