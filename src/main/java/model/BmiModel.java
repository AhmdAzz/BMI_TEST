/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author acer
 */
public class BmiModel {
    
    private double beratBadan; 
    private double tinggiBadan; 
    private String jenisKelamin; 

    public BmiModel() {
    }

    public BmiModel(double beratBadan, double tinggiBadan, String jenisKelamin) {
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.jenisKelamin = jenisKelamin;
    }

    public double getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(double beratBadan) {
        this.beratBadan = beratBadan;
    }

    public double getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(double tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public double hitungNilaiBmi() {
        if (tinggiBadan <= 0) {
            return 0; 
        }
        double tinggiMeter = tinggiBadan / 100.0; 
        return beratBadan / (tinggiMeter * tinggiMeter);
    }

    public String getKategoriBmi() {
        double bmi = hitungNilaiBmi();
        
        if (bmi <= 0) {
            return "Data tidak valid";
        } else if (bmi < 18.5) {
            return "Kurus (Underweight)";
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            return "Normal";
        } else if (bmi >= 25.0 && bmi <= 29.9) {
            return "Kelebihan Berat Badan (Overweight)";
        } else {
            return "Obesitas";
        }
    }

    public double hitungBeratIdeal() {
        if (tinggiBadan <= 0 || jenisKelamin == null) {
            return 0;
        }

        double beratNormal = tinggiBadan - 100;
        
        if (jenisKelamin.equalsIgnoreCase("Laki-laki")) {
            return beratNormal - (beratNormal * 0.10);
            
        } else if (jenisKelamin.equalsIgnoreCase("Perempuan")) {
            return beratNormal - (beratNormal * 0.15);
        }
        
        return 0; 
    }
}
