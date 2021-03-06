/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionbanco;

import core.Cola;
import modelo.Cajero;
import datos.Clientes;
import java.awt.Button;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyListWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.Duration;

/**
 *
 * @author Jairo Vergara Portocarrero 2151714
 * @author Jorge Enrique Moreno Barragan 2175321
 * @author Juan David Mosquera Castro 2150186
 * @author Sebastián Bejarano Cuero 2190853
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private WebView WebViewCajas;
    private WebEngine webEngineCajas;

    @FXML
    private TextArea TxtArea;
    @FXML
    private TableView TableView;
    //private TableView table = new TableView();

    @FXML
    private void inicializar(ActionEvent event) {
        System.out.println("You clicked me!");
        System.out.println(colaCliente.toString());
        construirViewCajeros();
    }

    private Cola<Clientes> colaCliente;

    @FXML
    private void finalizar(ActionEvent event) {
        System.out.println("You clicked me!");

    }
    private ObservableList<Cajero> cajas;
    private LinkedList<Cajero> caja;
    private int totalCaja1;
    private int totalCaja2;
    private int totalCaja3;
    private int totalCaja4;
    private int totalCaja5;
    private int totalCaja6;
    private int tiempoAtendido1;
    private int tiempoAtendido2;
    private int tiempoAtendido3;
    private int tiempoAtendido4;
    private int tiempoAtendido5;
    private int tiempoAtendido6;
    private int promedio1;
    private int promedio2;
    private int promedio3;
    private int promedio4;
    private int promedio5;
    private int promedio6;
    private Timeline time;
    private ObservableList<Cajero> listadoCajeros;
    private int tiempoTotal;
    TableColumn numCaja = new TableColumn("numCaja");
    TableColumn estado = new TableColumn("estado");
    TableColumn tiempoTransaccion = new TableColumn("tiempoTransaccion");
    TableColumn edadCliente = new TableColumn("edadCliente");
    TableColumn numClientes = new TableColumn("numClientes");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
//AL INICIALIZAR SE CREAN LOS 6 CAJEROS POR DEFECTO
        // TODO
        colaCliente = new Cola<>();
        caja = new LinkedList<>();
        listadoCajeros = FXCollections.observableArrayList();
        for (int i = 0; i <= 5; i++) {

            caja.add(new Cajero());

            listadoCajeros.add(i, new Cajero());
        }

        System.out.println(caja.size());
        //  construirViewCajeros();
    }

    public void iniciarCajas() {
        generarCliente();
        comprobarCajas();
        tiempoTotal++;
//        webEngineCajas.loadContent(construirViewCajeros());
    }

    public void renderTableViewCajas() {
        TableView.setItems(listadoCajeros);
        //  TableView.getColumns().addAll(estado, tiempoTransaccion, edadCliente, numClientes);

    }

    public void construirViewCajeros() {
//AQUI SE INICIALIZARA LA VISTA DEL TABLEVIEW

//        listadoCajeros = FXCollections.observableArrayList(
//                new Cajero(true, 10, 20, 10),
//                new Cajero(),
//                new Cajero(),
//                new Cajero(),
//                new Cajero()
//        );
        TableView.setEditable(true);
//        TableView.setMinSize(200, 300);

//        numCaja.setCellValueFactory(new Callback<CellDataFeatures<Cajero, String>, ObservableList<String>>() {
//            @Override
//            public ObservableList<String> call(CellDataFeatures<Cajero, String> param) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//            }
//           
//        });
//        estado.setMinWidth(20);
        estado.setCellValueFactory(
                new PropertyValueFactory<Cajero, String>("estado"));

//        tiempoTransaccion.setMinWidth(10);
        tiempoTransaccion.setCellValueFactory(
                new PropertyValueFactory<Cajero, String>("tiempoTransaccion"));

//        edadClientes.setMinWidth(10);
        edadCliente.setCellValueFactory(
                new PropertyValueFactory<Cajero, String>("edadCliente"));

//        numClientes.setMinWidth(10);
        numClientes.setCellValueFactory(
                new PropertyValueFactory<Cajero, String>("numClientes"));
//        numCaja.setText("");
        TableView.setItems(listadoCajeros);//
        TableView.getColumns().addAll(estado, tiempoTransaccion, edadCliente, numClientes);

        Timer timer = new Timer();
        TimerTask caja = new TimerTask() {

            @Override
            public void run() {

                iniciarCajas();
// construirViewCajeros();
            }
        };
        timer.schedule(caja, 0, 1000);

//        TableView.setEditable(true);
//        TableView.setItems(listadoCajeros);
        //        listadoCajeros.add(0, new Cajero());
        //        time = new Timeline(new KeyFrame(Duration.millis(1000), new EventHandler<ActionEvent>() {
        //            @Override
        //            public void handle(ActionEvent event) {
        ////                iniciarCajas();
        //                System.out.println("entre aca");
        //            }
        //        }));
        //        time.setCycleCount(Animation.INDEFINITE);
        //        new Timer().schedule(new TimerTask() {
        //            @Override
        //            public void run() {
        //                System.out.println("entre");
        //            }
        //        }, 0, 5000);
//                webEngineCajas = WebViewCajas.getEngine();
//        comprobarCajas();
//        String htmlcode = "";
//        String estado;
//        int contador = 0;
//
//        for (int i = 0; i < 6; i++) {
//
//            if (contador == 0) {
//                htmlcode += "<th> caja </th> ";
//            }
//            if (caja.get(i).isEstado()) {
//                htmlcode += "<th bgcolor=\"green\">" + (i + 1) + "<\th>";
//            } else {
//                htmlcode += "<th bgcolor=\"red\">" + (i + 1) + "<\th>";
//            }
//            contador++;
//        }
//
//        return htmlcode;
    }

    @FXML
    public void finalizar() {
        // TODO
        System.out.println("Finaliza proceso");
    }

    private void generarCliente() {
        int edad = (int) (Math.random() * (80 - 16 + 1) + 16);
        int tiempo = (int) (Math.random() * (60 - 5 + 1) + 5);
        Clientes c = new Clientes(edad, tiempo);
        colaCliente.encolar(c);
        //System.out.println(colaCliente.toString());
    }

    private void comprobarCajas() {
        for (Iterator<Cajero> it = caja.iterator(); it.hasNext();) {
            Cajero cajero = it.next();
            if (cajero.isEstado() && !colaCliente.estaVacia()) {
                Clientes c = colaCliente.desencolar();
//                System.out.println(colaCliente.toString());
                cajero.setEstado(false);
                cajero.setEdadCliente(c.getEdad());
                cajero.setTiempoTransaccion(c.getTiempoTransaccion());
                cajero.setNumClientes(cajero.getNumClientes() + 1);

                if (cajero == caja.get(0)) {
                    tiempoAtendido1 += c.getTiempoTransaccion();
                } else if (cajero == caja.get(1)) {
                    tiempoAtendido2 += c.getTiempoTransaccion();
                } else if (cajero == caja.get(2)) {
                    tiempoAtendido3 += c.getTiempoTransaccion();
                } else if (cajero == caja.get(3)) {
                    tiempoAtendido4 += c.getTiempoTransaccion();
                } else if (cajero == caja.get(4)) {
                    tiempoAtendido5 += c.getTiempoTransaccion();
                } else if (cajero == caja.get(5)) {
                    tiempoAtendido6 += c.getTiempoTransaccion();
                }
            } else {
                if (cajero.getTiempoTransaccion() > 0) {
                    cajero.setTiempoTransaccion(cajero.getTiempoTransaccion() - 1);
                    if (cajero == caja.get(0)) {
                        totalCaja1 += 1;
                    } else if (cajero == caja.get(1)) {
                        totalCaja2 += 1;
                    } else if (cajero == caja.get(2)) {
                        totalCaja3 += 1;
                    } else if (cajero == caja.get(3)) {
                        totalCaja4 += 1;
                    } else if (cajero == caja.get(4)) {
                        totalCaja5 += 1;
                    } else if (cajero == caja.get(5)) {
                        totalCaja6 += 1;
                    }

                }
                if (cajero.getTiempoTransaccion() == 0) {
                    cajero.setEstado(true);
                }
            }
            System.out.println(cajero.toString());
        };

    }

    public LinkedList<Cajero> getCaja() {
        return caja;
    }

    public void setCaja(LinkedList<Cajero> caja) {
        this.caja = caja;
    }

    public Timeline getTime() {
        return time;
    }

    public void setTime(Timeline time) {
        this.time = time;
    }

    public ObservableList<Cajero> getListadoCajeros() {
        return listadoCajeros;
    }

    public void setListadoCajeros(ObservableList<Cajero> listadoCajeros) {
        this.listadoCajeros = listadoCajeros;
    }

    public Cola<Clientes> getColaCliente() {
        return colaCliente;
    }

    public void setColaCliente(Cola<Clientes> colaCliente) {
        this.colaCliente = colaCliente;
    }

    public ObservableList<Cajero> getCajas() {
        return cajas;
    }

    public void setCajas(ObservableList<Cajero> cajas) {
        this.cajas = cajas;
    }

    public TableColumn getEstado() {
        return estado;
    }

    public void setEstado(TableColumn estado) {
        this.estado = estado;
    }

    public TableColumn getEdadCliente() {
        return edadCliente;
    }

    public void setEdadCliente(TableColumn edadCliente) {
        this.edadCliente = edadCliente;
    }

    public TableColumn getNumClientes() {
        return numClientes;
    }

    public void setNumClientes(TableColumn numClientes) {
        this.numClientes = numClientes;
    }

    public TableColumn getNumCaja() {
        return numCaja;
    }

    public void setNumCaja(TableColumn numCaja) {
        this.numCaja = numCaja;
    }

}
