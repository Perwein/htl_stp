/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labor17rect;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author perwein
 */
public class Rechteck {
    DoubleProperty laenge = new SimpleDoubleProperty(0.0);
    DoubleProperty breite = new SimpleDoubleProperty(0.0);
    ObjectProperty fill = new SimpleObjectProperty();


    public double getUmfang(){
        return 2*(laenge.get() + breite.get());
    }

    public double getFlaeche(){
        return laenge.get()*breite.get();
    }


}
