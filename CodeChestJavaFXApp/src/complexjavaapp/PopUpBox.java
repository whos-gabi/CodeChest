/*
   This is an alert BOX class!
   do not make any changes here 

   copyright:
   @the_cyber_bro
 */
package complexjavaapp;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
//import javafx.scene.geometry.*;

/**
 * @author theCYBERbro
 */
public class PopUpBox {

    public static boolean answer;

    public static boolean confirm_box(String title, String message,Color backgroundColor) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(255);
        VBox layout = new VBox(17);
        Text txt = makeText(layout, message, 0, 0, 20, Color.LIME);
        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");
        yesButton.setOnAction((event) -> {
            answer = true;
            window.close();
            //return answer;
        });
        noButton.setOnAction((event) -> {
            answer = false;
            window.close();
            //return answer;
        });

        layout.setBackground(new Background(new BackgroundFill(backgroundColor, CornerRadii.EMPTY, Insets.EMPTY)));

        layout.getChildren().addAll(yesButton, noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30, 30, 30, 30));

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }

    public static void alert_box(String title, String message,Color c) {
        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(255);
        VBox layout = new VBox(17);
        Text txt = makeText(layout, message, 0, 0, 20, Color.LIME);
        Button btn = new Button("Ok");
        btn.setOnAction(e -> window.close());

        layout.getChildren().addAll(btn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(30, 30, 30, 30));
        layout.setBackground(new Background(new BackgroundFill(c, CornerRadii.EMPTY, Insets.EMPTY)));
        Scene scene = new Scene(layout);

        window.setScene(scene);
        window.showAndWait();
    }

    public static Text makeText(Pane pane, String text, int x, int y, int font, Color txtColor) {
        Text txt = new Text(text);
        txt.setLayoutX(x);
        txt.setLayoutY(y);
        txt.setFont(Font.font(font));
        txt.setFill(txtColor);
        txt.setStyle("-fx-font-weight: bold");

        pane.getChildren().addAll(txt);
        return txt;

    }

}
