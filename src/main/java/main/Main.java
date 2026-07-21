package main;

import javafx.application.Application;
import javafx.stage.Stage;
import ui.TrustLinkUI;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        TrustLinkUI ui = new TrustLinkUI();

        //ui.show(stage);
    }

    public static void main(String[] args) {

        launch(args);

    }
}