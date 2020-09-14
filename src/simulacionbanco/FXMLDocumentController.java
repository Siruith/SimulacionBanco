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
    private int totalCaja1;
    private int totalCaja2;
    private int totalCaja3;
    private int totalCaja4;
    private int totalCaja5;
    private int totalCaja6;
    
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
        for(Iterator<Cajero> it = caja.iterator(); it.hasNext();){
            Cajero cajero = it.next();
            if(cajero.isEstado() && !cola.estaVacia()){
                Clientes c = cola.desencolar();
                cajero.setEstado(false);
                cajero.setEdadCliente(c.getEdad());
                cajero.setTiempoTransaccion(c.getTiempoTransaccion());
                cajero.setNumClientes(cajero.getNumClientes() + 1);
            }
            else{
                if(cajero.getTiempoTransaccion() > 0){
                    cajero.setTiempoTransaccion(cajero.getTiempoTransaccion() - 1);
                    if(cajero == caja.get(0)){
                        totalCaja1 += 1;
                    }
                    else if(cajero == caja.get(1)){
                        totalCaja2 += 1;
                    }
                    else if(cajero == caja.get(2)){
                        totalCaja3 += 1;
                    }
                    else if(cajero == caja.get(3)){
                        totalCaja4 += 1;
                    }
                    else if(cajero == caja.get(4)){
                        totalCaja5 += 1;
                    }
                    else if(cajero == caja.get(5)){
                        totalCaja6 += 1;
                    }
                    
                }
                if(cajero.getTiempoTransaccion() == 0){
                    cajero.setEstado(true);
                }
            }
        };
        
    }
    
}
