package be.pxl.ja2.gui.controller;

import be.pxl.ja2.jpa.dao.BeerDao;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BeerInformationController implements Initializable {
    @FXML
    private TextField searchTextField;
    @FXML
    private Label numberOfResultsLabel;
    @FXML
    private TableView beerTable;

    private BeerDao beerDao;

    public BeerInformationController() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentDB");
        EntityManager em = emf.createEntityManager();
        beerDao = new BeerDao(em);
        System.out.println("EM:" + beerDao);
    }

    public void searchBeers(ActionEvent actionEvent) {
        System.out.println("SF: " + searchTextField.getText());
        List<Beer> beers = beerDao.findByName(searchTextField.getText());
        numberOfResultsLabel.setText(Integer.toString(beers.size()));
        beerTable.setItems(FXCollections.observableArrayList(beers));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TableColumn<String, Beer> column1 = new TableColumn<>("Beer");
        column1.setCellValueFactory(new PropertyValueFactory<>("beerInfo"));
        TableColumn<String, Beer> column2 = new TableColumn<>("Brewer");
        column2.setCellValueFactory(new PropertyValueFactory<>("brewerInfo"));
        TableColumn<String, Beer> column3 = new TableColumn<>("Category");
        column3.setCellValueFactory(new PropertyValueFactory<>("category"));

        beerTable.getColumns().add(column1);
        beerTable.getColumns().add(column2);
        beerTable.getColumns().add(column3);
    }
}
