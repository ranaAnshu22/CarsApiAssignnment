package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.List;

public class HelloController {
    @FXML
    private Text carInformation;

    @FXML
    private TextField modelTextField;

    @FXML
    protected void onSearchButtonClick() {
        String make = modelTextField.getText();

        if (!make.isEmpty()) {
            CarApiUtility carApiUtility = new CarApiUtility();
            List<Car> cars = carApiUtility.fetchCarData(make);

            // Display information of the first car in the list
            if (!cars.isEmpty()) {
                Car car = cars.get(0);
                String carInfo = String.format("Make: %s\nModel: %s\nYear: %d\nCity MPG: %d\nHighway MPG: %d\n",
                        car.getMake().toUpperCase(), car.getModel().toUpperCase(), car.getYear(), car.getCityMpg(), car.getHighwayMpg());
                String carinfo2 = car.getBriefDescription();
                carInformation.setText(carInfo+carinfo2);
            } else {
                carInformation.setText("No car information available.");
            }
        } else {
            carInformation.setText("Please enter a model.");
        }
    }

    @FXML
    public void reset(ActionEvent actionEvent) {
        // Clear the text of the carInformation Text and modelTextField
        carInformation.setText("");
        modelTextField.clear();
    }
}
