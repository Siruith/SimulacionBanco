/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionbanco;

import core.Base;
import core.Cola;
import modelo.Cajero;
import datos.Clientes;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.LinkedList;
import principal.ImplementarCola;
import java.util.Iterator;

/**
 *
 * @author Sebastián
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    @FXML
    private void handleButtonAction1(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Sup!");
    }
    
    private Cola<Clientes> cola;
    private LinkedList<Cajero> caja;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cola = new Cola<>();
        caja = new LinkedList<>();
        for(int i = 0; i <=5; i++){
            caja.add(new Cajero());
        }
    } 
    private void generarCliente(){
        int edad = (int)(Math.random()*(80-16+1)+16);
        int tiempo = (int)(Math.random()*(60-5+1)+5);
        Clientes c = new Clientes(edad, tiempo);
        cola.encolar(c);
    }
    private void comprobarCajas(){
        
    }
    
}
