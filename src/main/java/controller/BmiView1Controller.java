/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class BmiView1Controller implements Initializable {

    @FXML private Label labelAngkaBmi;
    @FXML private Label labelKategori;
    @FXML private Label labelBeratIdeal;

    public void setHasilPerhitungan(double bmi, String kategori, double beratIdeal) {
        labelAngkaBmi.setText(String.format("%.2f", bmi)); 
        labelKategori.setText(kategori);
        labelBeratIdeal.setText(beratIdeal + " kg");
    }  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }
    
}
