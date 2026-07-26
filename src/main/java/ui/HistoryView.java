package ui;

import dao.ScanHistoryDAO;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.ScanHistory;

public class HistoryView {

    public void show(Stage stage) {

        TableView<ScanHistory> table =
                new TableView<>();

        TableColumn<ScanHistory, String> inputCol =
                new TableColumn<>("Input");

        inputCol.setCellValueFactory(data ->
                new SimpleStringProperty(
                        data.getValue().getInputValue()
                ));

        TableColumn<ScanHistory, Integer> scoreCol =
                new TableColumn<>("Trust Score");

        scoreCol.setCellValueFactory(data ->
                new SimpleIntegerProperty(
                        data.getValue().getTrustScore()
                ).asObject());

        TableColumn<ScanHistory, String> statusCol =
                new TableColumn<>("Status");

        statusCol.setCellValueFactory(data ->
                new SimpleStringProperty(
                        data.getValue().getStatus()
                ));

        inputCol.setPrefWidth(280);
        scoreCol.setPrefWidth(120);
        statusCol.setPrefWidth(150);

        table.getColumns().addAll(
                inputCol,
                scoreCol,
                statusCol
        );

        ScanHistoryDAO dao =
                new ScanHistoryDAO();

        table.getItems().addAll(
                dao.getAllScans()
        );

        VBox root =
                new VBox(table);

        Scene scene =
                new Scene(root, 600, 400);

        stage.setTitle(
                "TrustLink Scan History"
        );

        stage.setScene(scene);

        stage.show();

    }

}