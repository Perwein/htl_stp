/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labor17rect;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.DoubleBinding;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author perwein
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Rectangle rect;
    @FXML
    private Label lb1;
    @FXML
    private Label lb2;
    @FXML
    private Slider slider1;
    @FXML
    private Slider slider2;
    @FXML
    private ChoiceBox<Paint> cb1;



    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cb1.setItems(FXCollections.observableArrayList(Color.YELLOW, Color.RED, Color.BLUE, Color.ORANGE, Color.PINK));
        /*
        cb1.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                rect.fillProperty().set(cb1.getSelectionModel().getSelectedItem());
             }
         });

        slider2.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
               rect.setWidth((double) newValue);
               a = (double) newValue;
               double u  = Math.round( (100*(a+b))) /100;
              double f =  Math.round(10*(a*b))/100;
              lb1.setText("Umfang:  " + u);
              lb2.setText("Fläche:  " + f);

            }
       });

        slider1.valueProperty().addListener(new ChangeListener<Number>() {
           @Override
           public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
            rect.setHeight((double) newValue);
            b = (double) newValue;
            double u  = Math.round((100*(a+b))) /100.0;
            double f =  Math.round(10*(a*b))/100.0;
             lb1.setText("Umfang:  " + u);
             lb2.setText("Fläche:  " + f);


           }
       });
         */

        Rechteck re = new Rechteck();
        rect.fillProperty().bind(cb1.getSelectionModel().selectedItemProperty());
        re.laenge.bind(slider1.valueProperty());
        re.breite.bind(slider2.valueProperty());
        rect.heightProperty().bind(re.laenge);

        rect.widthProperty().bind(re.breite);
        StringBinding rectInfoBinding = new StringBinding() {

            // Instanzinitialisierer
            // Legt die unabhaengigen Properties fest
            {
                super.bind(re.laenge, re.breite);
            }

            // Berechnet den erwuenschten abhaengigen Wert, hier einen String

            @Override
            protected String computeValue() {
                return String.format("Umfang: %.2f E", re.getUmfang());
            }

        };

        lb1.textProperty().bind(rectInfoBinding);
        StringBinding rectInfoBinding2 = new StringBinding() {

            // Instanzinitialisierer
            // Legt die unabhaengigen Properties fest
            {
                super.bind(re.laenge, re.breite);
            }

            // Berechnet den erwuenschten abhaengigen Wert, hier einen String

            @Override
            protected String computeValue() {
                return String.format("Fläche: %.2f E²", re.getFlaeche());
            }

        };
         lb2.textProperty().bind(rectInfoBinding2);

    }

}
