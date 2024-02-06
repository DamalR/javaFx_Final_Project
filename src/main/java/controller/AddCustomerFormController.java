package controller;



import bo.BoFactory;
import bo.custom.CustomerBo;
import bo.custom.EmployeeBo;
import dao.util.BoType;
import dao.util.HibernateUtil;
import dto.CustomerDto;
import dto.EmployeeDto;
import dto.ItemDto;
import dto.tm.CustomerTm;
import dto.tm.ItemTm;
import entity.Customer;
import entity.Orders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class AddCustomerFormController {

    public BorderPane pane2;
    public TextField txtFieldCustomerId;
    public TextField txtFieldName;
    public TextField txtFieldContactNumber;
    public TextField txtFieldEmailT2;
    public TextField txtFieldAddress;
    public Button btnUpdate;
    public Button btnReload;
    public TableView tblCustomerDetilas;
    public Label lblCustomerId;
    public Button btnGoToOrder;
    @FXML
    private BorderPane pane;

    @FXML
    private Tab tabAddCustomer;

    @FXML
    private Text txtSearchCustomer;

    @FXML
    private TextField txtFieldSearchCustomer;

    @FXML
    private Button btnSearchCustomer;

    @FXML
    private TextField txtFieldOrderId;

    @FXML
    private Text txtCustomerName;

    @FXML
    private Text txtAddress;

    @FXML
    private TextField txtFieldCustomerName;

    @FXML
    private TextField txtFieldCustomerContactNum;

    @FXML
    private Text txtContactNumber;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtCustomerId;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFiledAddress;

    @FXML
    private Button btnAddCustomer;

    @FXML
    private Tab tabUpdateCustomer;

    @FXML
    private TableView<?> tblEmpDetilas;

    @FXML
    private TableColumn colCustomerId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colContactNumber;

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colDelete;

    @FXML
    private Text txtSearchCustomerT2;

    @FXML
    private TextField txtFieldSearchCustomerT2;

    @FXML
    private Button btnSearchCustomerT2;

    @FXML
    private Label txtTitle;

    private CustomerBo customerBo = BoFactory.getInstance().getBo(BoType.CUSTOMER);

    public void initialize(){
        generateCustomerId();
        colCustomerId.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContactNumber.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadCustomerTable();

        tblCustomerDetilas.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((CustomerTm) newValue);
        });
    }

    private void setData(CustomerTm newValue) {
        if (newValue != null) {
            txtFieldCustomerId.setEditable(false);
            txtFieldCustomerId.setText(newValue.getCustomerId());
            txtFieldName.setText(newValue.getName());
            txtFieldContactNumber.setText(newValue.getContactNumber());
            txtFieldEmailT2.setText(newValue.getEmail());
            txtFieldAddress.setText(newValue.getAddress());

        }
    }

    public void SearchButtonOnActionT1(javafx.event.ActionEvent actionEvent) {

    }

    public void addCustomerButtonOnAction(javafx.event.ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        boolean isSaved = customerBo.saveCustomer(
                new CustomerDto(lblCustomerId.getText(),
                        txtFieldCustomerName.getText(),
                        txtFieldCustomerContactNum.getText(),
                        txtFieldEmail.getText(),
                        txtFiledAddress.getText()
                ));
        if (isSaved){
            new Alert(Alert.AlertType.INFORMATION,"Customer Saved!").show();
            generateCustomerId();
            clearFields();
        }

    }

    private void clearFields() {
        txtFieldCustomerName.clear();
        txtFieldCustomerContactNum.clear();
        txtFieldEmail.clear();
        txtFiledAddress.clear();
    }

    public void searchButtonOnActionT2(javafx.event.ActionEvent actionEvent) {

    }

    public void updateButtonOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = customerBo.updateCustomer(
                    new CustomerDto(lblCustomerId.getText(),
                            txtFieldName.getText(),
                            txtFieldContactNumber.getText(),
                            txtFieldEmailT2.getText(),
                            txtFieldAddress.getText()
                    ));
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Customer Updated!").show();

                loadCustomerTable();
                clearFields();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private void loadCustomerTable() {
        ObservableList<CustomerTm> tmList = FXCollections.observableArrayList();

        try {
            List<CustomerDto> dtoList = customerBo.allCustomer();

            for (CustomerDto dto : dtoList) {
                Button btn = new Button("Delete");
                CustomerTm c = new CustomerTm(
                        dto.getCustomerId(),
                        dto.getName(),
                        dto.getContactNumber(),
                        dto.getEmail(),
                        dto.getAddress(),
                        btn
                );
                btn.setOnAction(actionEvent -> deleteCustomer(c.getCustomerId()));
                tmList.add(c);
            }
            tblCustomerDetilas.setItems(tmList);


        }catch (SQLException e) {
            throw new RuntimeException("Error loading customer table", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCustomer(String customerId) {
        try {
            boolean isDeleted = customerBo.deleteCustomer(customerId);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
                loadCustomerTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void reloadButtonOnAction(ActionEvent actionEvent) {
        loadCustomerTable();
        tblCustomerDetilas.refresh();
    }

    public void generateCustomerId() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query<Customer> query = session.createQuery("FROM Customer ORDER BY customerId DESC");
            query.setMaxResults(1);
            List<Customer> resultList = query.getResultList();

            if (!resultList.isEmpty()) {
                String id = resultList.get(0).getCustomerId();
                if (!id.isEmpty() && id.matches("C\\d{3}")) {
                    int num = Integer.parseInt(id.substring(1)) + 1;
                    lblCustomerId.setText(String.format("C%03d", num));
                } else {
                    lblCustomerId.setText("C001");
                }
            } else {
                lblCustomerId.setText("C001");
            }
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToOrderButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.orderCaller(stage);
    }
}
