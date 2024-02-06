package controller;

import bo.BoFactory;
import bo.custom.EmployeeBo;
import dao.custom.EmployeeDao;
import dao.custom.impl.EmployeeDaoImpl;
import dao.util.BoType;
import dao.util.HibernateUtil;
import dto.EmployeeDto;
import dto.tm.*;
import entity.Employee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class RegisterFormController {

    public TextField txtFieldEmployeeIdT2;

    public Label lblEmpId;
    public TableView tblEmpDetilas2;
    public TableColumn colAdminId;
    public TableColumn colAdminName;
    public TableColumn colAdminContact;
    public TableColumn colAdminEmail;
    public TableColumn colAdminDelete;
    public Text txtName2;
    public TextField txtFieldName2;
    public Text txtEmployeeId2;
    public TextField txtFieldEmployeeIdT3;
    public Button btnSearchName2;
    public Button btnSearchEmpId2;
    public TableView tblAdminDetilas;
    @FXML
    private BorderPane pane;

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
    private Label txtSelectAdminEmployee;

    @FXML
    private Text txtFullName;

    @FXML
    private Text txtEmail;

    @FXML
    private Text txtContactNumber;

    @FXML
    private Text txtUsername;

    @FXML
    private Text txtPassword;

    @FXML
    private Text txtConfirmPassword;

    @FXML
    private TextField txtFieldFullName;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFieldContactNumber;

    @FXML
    private TextField txtFieldUsername;

    @FXML
    private TextField txtFieldPassword;

    @FXML
    private TextField txtFieldConfirmPassword;

    @FXML
    private Button btnSubmit;

    @FXML
    private ComboBox<?> comboBoxSelectAdminEmployee;

    @FXML
    private TableView tblEmpDetilas;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colContact;

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableColumn colDelete;

    @FXML
    private Text txtName;

    @FXML
    private TextField txtFieldName;

    @FXML
    private Text txtEmployeeId;

    @FXML
    private TextField txtFieldEmployeeId;

    @FXML
    private Button btnSearchName;

    @FXML
    private Button btnSearchEmpId;

    @FXML
    private Label txtTitle;

    private EmployeeBo employeeBo = BoFactory.getInstance().getBo(BoType.EMPLOYEE);
    private EmployeeDao employeeDao = new EmployeeDaoImpl();


    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadEmpTable();
        generateId();

        tblEmpDetilas.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((EmployeeTm2) newValue);
        });


    }





    private void setData(EmployeeTm2 newValue) {
        if (newValue != null) {
//            txtFieldEmployeeIdT2.setEditable(false);
//            txtFieldEmployeeIdT2.setText(newValue.getEmpId());

        }
    }

    private void loadEmpTable() {
        ObservableList<EmployeeTm2> tmList = FXCollections.observableArrayList();

        try {
            List<EmployeeDto> dtoList = employeeBo.allEmployees();

            for (EmployeeDto dto : dtoList) {
                Button btn = new Button("Delete");
                EmployeeTm2 c = new EmployeeTm2(
                        dto.getEmpId(),
                        dto.getName(),
                        dto.getContactNumber(),
                        dto.getEmail(),
                        btn
                );
                btn.setOnAction(actionEvent -> deleteEmployee(c.getEmpId()));
                tmList.add(c);
            }
            tblEmpDetilas.setItems(tmList);

        } catch (SQLException e) {
            throw new RuntimeException("Error loading customer table", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteEmployee(String id) {
        try {
            boolean isDeleted = employeeBo.deleteCustomer(id);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Employee Deleted!").show();
                loadEmpTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void submitButtonOnAction(javafx.event.ActionEvent actionEvent) {
        try {
            boolean isSaved = employeeBo.saveEmployee(
                    new EmployeeDto(lblEmpId.getText(),
                            txtFieldFullName.getText(),
                            txtFieldEmail.getText(),
                            txtFieldContactNumber.getText(),
                            txtFieldPassword.getText()
                    ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Item Category Saved!").show();
                generateId();
                clearFields();
            }
        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    private void clearFields() {
        txtFieldFullName.clear();
        txtFieldEmail.clear();
        txtFieldContactNumber.clear();
        txtFieldPassword.clear();
        txtFieldConfirmPassword.clear();

    }

    public void homeButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.homeCaller(stage);
    }

    public void OrderButtonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        ButtonControllers.orderCaller(stage);
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

    public void generateId() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query<Employee> query = session.createQuery("FROM Employee ORDER BY empId DESC");
            query.setMaxResults(1);
            List<Employee> resultList = query.getResultList();

            if (!resultList.isEmpty()) {
                String id = resultList.get(0).getEmpId();
                if (!id.isEmpty() && id.matches("D\\d{3}")) {
                    int num = Integer.parseInt(id.substring(1)) + 1;
                    lblEmpId.setText(String.format("D%03d", num));
                } else {
                    lblEmpId.setText("D001");
                }
            } else {
                lblEmpId.setText("D001");
            }
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

