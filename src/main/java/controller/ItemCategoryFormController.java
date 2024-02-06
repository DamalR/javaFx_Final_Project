package controller;

import bo.BoFactory;
import bo.custom.ItemCategoryBo;
import dao.util.BoType;
import dao.util.HibernateUtil;
import dto.ItemCategoryDto;
import dto.tm.ItemCategoryTm;
import dto.tm.ItemCategoryTm2;
import dto.tm.ItemTm;
import entity.Item;
import entity.ItemCategory;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ItemCategoryFormController {

    public Button btnSaveItemCategory;
    public TableColumn colItemCategoryIdT2;
    public TableColumn colItemCategoryNameT2;
    public Button btnReload;
    public BorderPane paneItemCategory;
    public Button btnBack;
    public Label lblItemCategory;
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
    private Tab tabAddItemCategory;

    @FXML
    private Text txtSearchItemCategoryT1;

    @FXML
    private TextField txtFieldItemCategoryT1;

    @FXML
    private Button btnSearchItemCategoryT1;

    @FXML
    private Text txtItemCategoryID;

    @FXML
    private TextField txtFieldItemCategoryId;

    @FXML
    private Text txtItemCategoryName;

    @FXML
    private TextField txtFieldItemCategoryName;

    @FXML
    private Button btnAddItemCategory;

    @FXML
    private TableView<ItemCategoryTm> tblItemCategoryT1;

    @FXML
    private TableColumn colItemCategory;

    @FXML
    private TableColumn colItemCategoryName;

    @FXML
    private Tab tabDeleteItemCategory;

    @FXML
    private Text txtItemCategory;

    @FXML
    private TextField txtFieldSearchItemCategory;

    @FXML
    private Button btnSearchItemCategory;

    @FXML
    private TableView<ItemCategoryTm> tblItemCategory;

    @FXML
    private TableColumn colItemCategoryId;

    @FXML
    private TableColumn colDelete;

    @FXML
    private Label txtTitle;

    private StackPane contentArea;

    private ItemCategoryBo itemCategoryBo = BoFactory.getInstance().getBo(BoType.ITEMCATEGORY);

    public void initialize() throws ClassNotFoundException {
        generateItemCategoryId();
        colItemCategoryId.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colItemCategoryName.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        loadItemCategoryTable();

        tblItemCategoryT1.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((ItemCategoryTm) newValue);
        });

        colItemCategoryIdT2.setCellValueFactory(new PropertyValueFactory<>("categoryId"));
        colItemCategoryNameT2.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        colDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));
        loadItemCategoryTable2();

        tblItemCategory.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            setData((ItemCategoryTm2) newValue);
        });

    }

    private void loadItemCategoryTable2() {
        ObservableList<ItemCategoryTm> tmList = FXCollections.observableArrayList();

        try {
            List<ItemCategoryDto> dtoList = itemCategoryBo.allItemCategory();

            for (ItemCategoryDto dto : dtoList) {
                Button btn = new Button("Delete");
                ItemCategoryTm2 c = new ItemCategoryTm2(
                        dto.getCategoryId(),
                        dto.getCategoryName(),
                        btn
                );
                btn.setOnAction(actionEvent -> deleteItemCategory(c.getCategoryId()));
                tmList.add(c);
            }
            tblItemCategory.setItems(tmList);

        } catch (SQLException e) {
            throw new RuntimeException("Error loading customer table", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void setData(ItemCategoryTm newValue) {
        if (newValue != null) {
            txtFieldItemCategoryId.setEditable(false);
            txtFieldItemCategoryId.setText(newValue.getCategoryId());
            txtFieldItemCategoryName.setText(newValue.getCategoryName());
        }
    }

    private void loadItemCategoryTable() throws ClassNotFoundException {
        ObservableList<ItemCategoryTm> tmList = FXCollections.observableArrayList();

        try {
            List<ItemCategoryDto> dtoList = itemCategoryBo.allItemCategory();

            for (ItemCategoryDto dto : dtoList) {

                ItemCategoryTm c = new ItemCategoryTm(
                        dto.getCategoryId(),
                        dto.getCategoryName()
                );
                tmList.add(c);
            }
            tblItemCategoryT1.setItems(tmList);

        } catch (SQLException e) {
            throw new RuntimeException("Error loading customer table", e);
        }
    }

    private void deleteItemCategory(String id) {
        try {
            boolean isDeleted = itemCategoryBo.deleteCustomer(id);
            if (isDeleted){
                new Alert(Alert.AlertType.INFORMATION,"Customer Deleted!").show();
                loadItemCategoryTable();
            }else{
                new Alert(Alert.AlertType.ERROR,"Something went wrong!").show();
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }


    public void homeButtonOnAction(ActionEvent actionEvent) throws IOException {
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

    public void saveButtonOnAction(ActionEvent actionEvent) {
        try {
            boolean isSaved = itemCategoryBo.saveItemCategory(
                    new ItemCategoryDto(lblItemCategory.getText(),
                            txtFieldItemCategoryName.getText()
                    ));
            if (isSaved){
                new Alert(Alert.AlertType.INFORMATION,"Item Category Saved!").show();
                loadItemCategoryTable();
                generateItemCategoryId();
                clearFields1();
            }
        } catch (SQLIntegrityConstraintViolationException ex){
            new Alert(Alert.AlertType.ERROR,"Duplicate Entry").show();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    private void clearFields1() {
        txtFieldItemCategoryName.clear();
    }

    public void reloadButtonOnAction(ActionEvent actionEvent) {
        loadItemCategoryTable2();
        tblItemCategory.refresh();

    }

    public void SearchButtonOnActionT2(ActionEvent actionEvent) {

    }

    public void SearchButtonOnActionT1(ActionEvent actionEvent) {
        txtFieldItemCategoryT1.textProperty().addListener((observable, oldValue, newValue) -> {
            tblItemCategoryT1.getItems().clear();


            List<ItemCategoryTm> filteredItems = tblItemCategoryT1.getItems().stream()
                    .filter(item ->
                            item.getColItemCategoryId().contains(newValue) ||
                                    item.getColItemCategoryName().contains(newValue)
                    )
                    .collect(Collectors.toList());

            tblItemCategoryT1.getItems().addAll(filteredItems);
        });

    }

    public void backButtonOnAction(ActionEvent actionEvent) {
        Stage stage = (Stage) paneItemCategory.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void generateItemCategoryId() {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            session.beginTransaction();

            Query<ItemCategory> query = session.createQuery("FROM ItemCategory ORDER BY categoryId DESC");
            query.setMaxResults(1);
            List<ItemCategory> resultList = query.getResultList();

            if (!resultList.isEmpty()) {
                String id = resultList.get(0).getCategoryId();
                if (!id.isEmpty() && id.matches("S\\d{3}")) {
                    int num = Integer.parseInt(id.substring(1)) + 1;
                    lblItemCategory.setText(String.format("S%03d", num));
                } else {
                    lblItemCategory.setText("S001");
                }
            } else {
                lblItemCategory.setText("IC001");
            }
            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
