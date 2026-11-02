/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;
import model.BmiModel;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class BmiViewController implements Initializable {
    
@FXML private TextField inputBerat;
    @FXML private TextField inputTinggi;
    @FXML private RadioButton radioPria;
    @FXML private RadioButton radioWanita;

    @FXML
    private void klikTombolHitung(ActionEvent event) {
        try {
           
            double berat = Double.parseDouble(inputBerat.getText());
            double tinggi = Double.parseDouble(inputTinggi.getText());
            String gender = radioPria.isSelected() ? "Laki-laki" : "Perempuan";

            BmiModel model = new BmiModel(berat, tinggi, gender);
            double hasilBmi = model.hitungNilaiBmi();
            String kategori = model.getKategoriBmi();
            double beratIdeal = model.hitungBeratIdeal();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/promlan/bmi/BmiView1.fxml"));
            Parent root = loader.load();

            BmiView1Controller BmiView1Controller = loader.getController();
            BmiView1Controller.setHasilPerhitungan(hasilBmi, kategori, beratIdeal);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (Exception e) {
            e.printStackTrace(); 
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
