package ui;

import dao.ScanHistoryDAO;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Risk;
import model.ScanHistory;
import utils.TrustScore;

import java.util.ArrayList;

public class TrustLinkUI {

    public void show(Stage stage) {

        Label title = new Label("TrustLink");

        Label subtitle = new Label(
                "Digital Trust Intelligence Tool"
        );

        TextField input = new TextField();

        input.setPromptText(
                "Enter Website / Email / Phone"
        );

        Button analyzeButton
                = new Button("Analyze");

        Button historyButton
                = new Button("Scan History");

        Label result
                = new Label(
                        "Trust Score will appear here"
                );

        ProgressBar riskBar
                = new ProgressBar(0);

        riskBar.setPrefWidth(400);

        GraphView graphView
                = new GraphView();

        Pane graphPane
                = graphView.createGraph(
                        "Website",
                        "Email",
                        "Phone"
                );

        // Open History Window
        historyButton.setOnAction(e -> {

            HistoryView history
                    = new HistoryView();

            history.show(new Stage());

        });

        analyzeButton.setOnAction(e -> {

            String value = input.getText().toLowerCase();

            if (value.isEmpty()) {

                result.setText("Please enter a value");
                return;

            }

            ArrayList<Risk> risks = new ArrayList<>();

            // Website Risk
            if (value.contains("fake")
                    || value.contains("login")
                    || value.contains("bank")
                    || value.contains("verify")) {

                risks.add(
                        new Risk(
                                "Suspicious Domain",
                                50
                        )
                );

            }

            // Email Risk
            if (value.contains("@")) {

                if (!value.contains("gmail")
                        && !value.contains("outlook")
                        && !value.contains("yahoo")) {

                    risks.add(
                            new Risk(
                                    "Unknown Email Connection",
                                    20
                            )
                    );

                }

            }

            // Phone Risk
            if (value.matches(".*\\d.*")) {

                risks.add(
                        new Risk(
                                "Reported Phone Number",
                                30
                        )
                );

            }

            TrustScore calculator
                    = new TrustScore();

            int score
                    = calculator.calculateScore(risks);

            String status
                    = calculator.getStatus(score);

            riskBar.setProgress(score / 100.0);

            if (score >= 80) {

                riskBar.setStyle("-fx-accent: green;");

            } else if (score >= 50) {

                riskBar.setStyle("-fx-accent: orange;");

            } else {

                riskBar.setStyle("-fx-accent: red;");

            }

            StringBuilder riskFactors
                    = new StringBuilder();

            if (risks.isEmpty()) {

                riskFactors.append("\nNo threats detected");

            } else {

                for (Risk risk : risks) {

                    riskFactors.append("\n- ")
                            .append(risk.getName());

                }

            }

            result.setText(
                    "Analyzing: "
                    + value
                    + "\n\nTrust Score: "
                    + score
                    + "/100"
                    + "\n\nStatus: "
                    + status
                    + "\n\nRisk Factors:"
                    + riskFactors
            );

            // Save Scan into MySQL
            ScanHistory history
                    = new ScanHistory(
                            value,
                            score,
                            status
                    );

            ScanHistoryDAO dao
                    = new ScanHistoryDAO();

            dao.saveScan(history);

            // Update Dynamic Graph
            graphPane.getChildren().clear();

            graphPane.getChildren().addAll(
                    graphView.createGraph(
                            value,
                            "support@suspicious.com",
                            "+94771234567"
                    ).getChildren()
            );

        });

        VBox layout
                = new VBox(20);

        layout.setPadding(
                new Insets(30)
        );

        layout.getChildren().addAll(
                title,
                subtitle,
                input,
                analyzeButton,
                historyButton,
                result,
                riskBar,
                graphPane
        );

        Scene scene = new Scene(
                layout,
                700,
                700
        );

        stage.setTitle("TrustLink");

        stage.setScene(scene);

        stage.show();
    }

}
