package ui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class GraphView {

    public Pane createGraph(String website,
                            String email,
                            String phone) {

        Pane pane = new Pane();

        Circle websiteNode = new Circle(100, 100, 40);
        Circle emailNode = new Circle(250, 200, 40);
        Circle phoneNode = new Circle(400, 100, 40);

        websiteNode.setFill(Color.LIGHTBLUE);
        emailNode.setFill(Color.LIGHTGREEN);
        phoneNode.setFill(Color.LIGHTCORAL);

        Line line1 = new Line(
                130,
                130,
                220,
                170
        );

        Line line2 = new Line(
                280,
                170,
                370,
                130
        );

        Label websiteText =
                new Label("🌐 " + website);

        websiteText.setLayoutX(40);
        websiteText.setLayoutY(40);

        Label emailText =
                new Label("✉ " + email);

        emailText.setLayoutX(190);
        emailText.setLayoutY(250);

        Label phoneText =
                new Label("📱 " + phone);

        phoneText.setLayoutX(340);
        phoneText.setLayoutY(40);

        pane.getChildren().addAll(

                line1,
                line2,

                websiteNode,
                emailNode,
                phoneNode,

                websiteText,
                emailText,
                phoneText

        );

        return pane;

    }

}