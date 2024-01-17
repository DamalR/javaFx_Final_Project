package controller;

import bo.BoFactory;
import bo.custom.EmployeeBo;
import bo.custom.ItemCategoryBo;
import dao.util.BoType;
import dto.EmployeeDto;
import dto.ItemCategoryDto;
import dto.ItemDto;
import dto.tm.EmployeeTm;
import dto.tm.EmployeeTm2;
import dto.tm.ItemTm;
import dto.tm.ItemTm2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class RegisterFormController {

    public TextField txtFieldEmployeeIdT2;
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

    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("empId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("email"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("contactNumber"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadEmpTable();

        tblEmpDetilas.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((EmployeeTm) newValue);
        });
    }

    private void setData(EmployeeTm newValue) {
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
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
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
                    new EmployeeDto(txtFieldEmployeeId.getText(),
                            txtFieldFullName.getText(),
                            txtFieldEmail.getText(),
                            txtFieldContactNumber.getText(),
                            txtFieldUsername.getText(),
                            txtFieldPassword.getText()
                    ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Item Category Saved!").show();
            }
        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

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

//    public void generateId(){
//        try {
//            EmployeeDto dto = emplo.lastOrder();
//            if (dto!=null){
//                String id = dto.getOrderId();
//                int num = Integer.parseInt(id.split("[D]")[1]);
//                num++;
//                lblOrderId.setText(String.format("D%03d",num));
//            }else{
//                lblOrderId.setText("D001");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }


}

