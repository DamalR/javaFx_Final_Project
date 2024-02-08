package controller;

import com.jfoenix.controls.JFXButton;
import db.DBConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;

public class ReportsFormController {

    public AnchorPane pane;
    @FXML
    private JFXButton btnOrderReport;

    @FXML
    private JFXButton btnCustomer;

    @FXML
    private JFXButton btnSalesReport;

    @FXML
    private JFXButton btnback;

    public void orderReportButtonOnAction(javafx.event.ActionEvent actionEvent) {
        try {
            JasperDesign design = JRXmlLoader.load("src/main/resources/reports/order_report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void customerButtonOnAction(javafx.event.ActionEvent actionEvent) {
        try {
            JasperDesign design = JRXmlLoader.load("src/main/resources/reports/customer_report1.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void salesReportButtnOnAction(javafx.event.ActionEvent actionEvent) {
        try {
            JasperDesign design = JRXmlLoader.load("src/main/resources/reports/sales_report.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(design);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, DBConnection.getInstance().getConnection());
            JasperViewer.viewReport(jasperPrint, false);

        } catch (JRException | ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void backbuttonOnAction(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) pane.getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardForm.fxml"))));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
