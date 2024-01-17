package controller;



import bo.BoFactory;
import dao.util.BoType;
import bo.custom.ItemBo;
import dto.ItemDto;
import dto.tm.ItemTm;
import dto.tm.ItemTm2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class ItemFormController {

    public TableColumn colCategoryT3;
    public TableColumn colImageT3;
    public Text txtItemCategoryT2;
    public TextField txtFieldItemCategoryT2;
    public TableColumn colItemCategory;
    public TableColumn colImage;
    public ComboBox comboBoxItemCategory;
    public TextField txtFieldFault;
    public Text txtItemFault;
    public TextField txtFieldItemId;
    public Text txtItemId;
    public Button btnUpdate;
    public BorderPane pane;
    public Button btnReloadT2;



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
    private Tab tabAddItem;

    @FXML
    private Text txtItemCategory;

    @FXML
    private TextField txtFieldItemCategory;

    @FXML
    private Text txtItemName;

    @FXML
    private TextField txtFieldItemName;

    @FXML
    private Text txtItemCode;

    @FXML
    private TextField txtFieldItemCode;

    @FXML
    private Button btnSave;

    @FXML
    private Text txtImage;

    @FXML
    private TextField txtFieldImage;

    @FXML
    private Tab tabUpdateItem;

    @FXML
    private Text txtSearchItemIdT2;

    @FXML
    private TextField txtFieldSearchItemT2;

    @FXML
    private Button btnSearchItemT2;

    @FXML
    private TableView<ItemTm> tblItemT2;

    @FXML
    private TableColumn colItemId;

    @FXML
    private TableColumn colItemName;



    @FXML
    private TableColumn colFault;




    @FXML
    private TableColumn<?, ?> colDelete;

    @FXML
    private Text txtItemIdT2;

    @FXML
    private TextField txtFieldItemIdT2;

    @FXML
    private Text txtItemNameT2;

    @FXML
    private TextField txtFieldItemNameT2;

    @FXML
    private Text txtFaultT2;

    @FXML
    private TextField txtFieldFaultT2;

    @FXML
    private Text txtManufactureT2;

    @FXML
    private TextField txtFieldManufactureT2;

    @FXML
    private Text txtCostT2;

    @FXML
    private TextField txtFieldCostT2;

    @FXML
    private Tab tabDeleteItem;

    @FXML
    private Text txtSearchItem;

    @FXML
    private TextField txtFieldSearchItem;

    @FXML
    private Button btnSearchT3;

    @FXML
    private TableView<ItemTm2> tblDeleteItem;

    @FXML
    private TableColumn<?, ?> colItemIdT3;

    @FXML
    private TableColumn<?, ?> colItemNameT3;

    @FXML
    private TableColumn<?, ?> colManufactureT3;

    @FXML
    private TableColumn<?, ?> colFaultT3;

    @FXML
    private TableColumn<?, ?> colCostT3;

    @FXML
    private TableColumn<?, ?> colDeleteT3;

    @FXML
    private Label txtTitle;
    private ItemBo itemBo = BoFactory.getInstance().getBo(BoType.ITEM);

    public void initialize() throws SQLException, ClassNotFoundException {
        comboBoxItemCategory.getItems().addAll("Electrical","Electronic");

        colItemId.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colItemName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colItemCategory.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        colFault.setCellValueFactory(new PropertyValueFactory<>("fault"));

        loadItemTable();

        tblItemT2.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((ItemTm) newValue);
        });

        colItemIdT3.setCellValueFactory(new PropertyValueFactory<>("itemId"));
        colItemNameT3.setCellValueFactory(new PropertyValueFactory<>("name"));
        colCategoryT3.setCellValueFactory(new PropertyValueFactory<>("fault"));
        colFaultT3.setCellValueFactory(new PropertyValueFactory<>("itemCategory"));
        colDeleteT3.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadItemCategoryTable3();

        tblDeleteItem.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
//            setData((ItemTm) newValue);
        });
    }

    private void loadItemCategoryTable3() {
        ObservableList<ItemTm2> tmList = FXCollections.observableArrayList();

        try {
            List<ItemDto> dtoList = itemBo.allItems();

            for (ItemDto dto : dtoList) {
                Button btn = new Button("Delete");
                ItemTm2 c = new ItemTm2(
                        dto.getItemId(),
                        dto.getName(),
                        dto.getFault(),
                        dto.getItemCategory(),
                        btn
                );
                btn.setOnAction(actionEvent -> deleteItem(c.getItemId()));
                tmList.add(c);
            }
            tblDeleteItem.setItems(tmList);

        } catch (SQLException e) {
            throw new RuntimeException("Error loading customer table", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteItem(String id) {
        try {
            boolean isDeleted = itemBo.deleteCustomer(id);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
                loadItemCategoryTable3();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void setData(ItemTm newValue) {
        if (newValue != null) {
            txtFieldItemIdT2.setEditable(false);
            txtFieldItemIdT2.setText(newValue.getItemId());
            txtFieldItemNameT2.setText(newValue.getName());
            txtFieldFaultT2.setText(newValue.getFault());
            txtFieldItemCategoryT2.setText(newValue.getItemCategory());

        }
    }

    private void loadItemTable() throws SQLException, ClassNotFoundException {
        ObservableList<ItemTm> tmList = FXCollections.observableArrayList();

        try {
            List<ItemDto> dtoList = itemBo.allItems();

            for (ItemDto dto : dtoList) {

                ItemTm c = new ItemTm(
                        dto.getItemId(),
                        dto.getName(),
                        dto.getFault(),
                        dto.getItemCategory()
                );
                tmList.add(c);
            }
            tblItemT2.setItems(tmList);


        }catch (SQLException e) {
            throw new RuntimeException("Error loading customer table", e);
        }
    }


    public void homeButtonOnAction(ActionEvent actionEvent) {

    }

    public void OrderButtonOnAction(ActionEvent actionEvent) {

    }

    public void itemCategoryButtonOnAction(ActionEvent actionEvent) {

    }

    public void itemButtonOnAction(ActionEvent actionEvent) {

    }

    public void userButtonOnAction(ActionEvent actionEvent) {

    }

    public void reportButtonOnAction(ActionEvent actionEvent) {

    }

    public void saveButtonOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = itemBo.saveItem(
                    new ItemDto(txtFieldItemId.getText(),
                            txtFieldItemName.getText(),
                            txtFieldFault.getText(),
                            comboBoxItemCategory.getSelectionModel().getSelectedItem().toString()
                    ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Item Saved!").show();
            }
        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }


    }

    public void searchButtonT3OnAction(ActionEvent actionEvent) {

    }

    public void updateButtonOnAction(ActionEvent actionEvent) {
        try {
            boolean isUpdated = itemBo.updateItem(
                    new ItemDto(txtFieldItemIdT2.getText(),
                            txtFieldItemNameT2.getText(),
                            txtFieldFaultT2.getText(),
                            txtFieldItemCategoryT2.getText()
                    ));
            if (isUpdated){
                new Alert(Alert.AlertType.INFORMATION,"Customer Updated!").show();

                loadItemTable();
                clearFields();
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void clearFields() {
        txtFieldItemIdT2.clear();
        txtFieldItemNameT2.clear();
        txtFieldFaultT2.clear();
        txtFieldItemCategoryT2.clear();

    }
    public void reloadT2ButtonOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        loadItemTable();
        tblItemT2.refresh();
    }
}

