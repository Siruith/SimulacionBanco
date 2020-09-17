/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulacionbanco;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.Cajero;

/**
 *
 * @author Sebastián
 */
public class SimulacionBanco extends Application {

//    TableView<Cajero> table = new TableView<Cajero>();
//    private final ObservableList<Cajero> listadoCajeros
//            = FXCollections.observableArrayList(
//                    new Cajero(true, 10, 20, 10),
//                    new Cajero(),
//                    new Cajero(),
//                    new Cajero(),
//                    new Cajero()
//            );

    @Override
    public void start(Stage stage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
//        stage.setTitle("Table View Sample");
//        stage.setWidth(600);
//        stage.setHeight(700);
//
//        final Label label = new Label("- - - -");
//        label.setFont(new Font("Arial", 20));

//        table.setEditable(true);
//        table.setMinSize(300, 600);
//        TableColumn estado = new TableColumn("estado");
//        estado.setMinWidth(100);
//        estado.setCellValueFactory(
//                new PropertyValueFactory<Cajero, String>("estado"));
//        TableColumn tiempoTransaccion = new TableColumn("tiempoTransaccion");
//        tiempoTransaccion.setMinWidth(100);
//        tiempoTransaccion.setCellValueFactory(
//                new PropertyValueFactory<Cajero, String>("tiempoTransaccion"));
//        TableColumn edadClientes = new TableColumn("edadClientes");
//        edadClientes.setMinWidth(100);
//        edadClientes.setCellValueFactory(
//                new PropertyValueFactory<Cajero, String>("edadClientes"));
//        TableColumn numClientes = new TableColumn("numClientes");
//        numClientes.setMinWidth(100);
//        numClientes.setCellValueFactory(
//                new PropertyValueFactory<Cajero, String>("numClientes"));
//        TableColumn tiempoTotal = new TableColumn("tiempoTotal");
//        tiempoTotal.setMinWidth(100);
//        tiempoTotal.setCellValueFactory(
//                new PropertyValueFactory<Cajero, String>("tiempoTotal"));
//
//        table.setItems(listadoCajeros);
//        table.getColumns().addAll(estado, tiempoTransaccion, edadClientes, numClientes, tiempoTotal);
//
//        final VBox vbox = new VBox();
//        vbox.setSpacing(5);
//        vbox.setPadding(new Insets(10, 0, 0, 10));
//        vbox.getChildren().addAll(label, table);
//
//        ((Group) scene.getRoot()).getChildren().addAll(vbox);

//        stage.setScene(scene);
//        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
