/*
  When i wrote this code only I and GOD knew whats here, 
  now only GOD know.
 */
 /*
@the_cyber_bro Copyright 2020-2021
This is a java Aplication v4.2
 */

package complexjavaapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import static javafx.application.Application.launch;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @autho root
 */
public class ComplexJavaApp extends Application {
//Declaration space

    public Stage primaryStage;
    private AnchorPane root, menuRoot, settingsRoot, shopRoot;
    private Scene defaultScene, menuScene, settingsScene, shopScene;

    MediaPlayer mp;

    Slider betSlider,
            contrastSliderImage, hueSliderImage, brightnesSliderImage, saturationSliderImage,
            contrastSliderBkg, hueSliderBkg, brightnesSliderBkg, saturationSliderBkg;

    Button btnSpin, btnBetx2, btnBetx3,
            save, exitNoSave, btnSettings,
            aplyBtn,
            startGame, resetImageSettings, resetBackgroundSettings;

    Shape slotMachineOut1, slotMachineOut2, slotMachineOut3;

    ImageView bet1, bet2, bet3,
            decorativeImageView1, decorativeImageView2,
            decorativeImageView3, decorativeImageView4,
            decorativeImageView5, decorativeImageView6,
            backToMenu1, backToMenu, freeDollar;

    Glow glow;//its not used yet

    ColorAdjust colorAdjustImage, colorAdjustBackground;

    int money = 50;
    Text balance;

    int b1 = 2, b2 = 2, b3 = 2;

    boolean firstTimeInGame = true;

    public static int SCENE_HEIGHT = 800;
    public static int SCENE_WIDTH = 1200;
    public static int START_SCREEN_BUTTON_WIDTH = 225;

    String[] imgArr = {"c#.png",
        "c++.png",
        "java.png",
        "js.png",
        "php.png",
        "python.png",
        "ruby.png",
        "sql.png",
        "swift.png"};

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {//starting start
        initComponents(primaryStage);
        addListeners(primaryStage);
    }//end of start

    //¥€$

    public void initComponents(Stage primaryStage) throws FileNotFoundException {
        root = new AnchorPane();

        colorAdjustImage = new ColorAdjust();
        colorAdjustBackground = new ColorAdjust();

        ImageView rootBackground = creazaImageView(root, "bkg.png", 0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        rootBackground.setEffect(colorAdjustBackground);
        // mp=creazaMediaPlayer("123.mp3");
        Text title = makeText(root, "CodeChest", 230, 150, 120, Color.LIME);  //web("#ff0028")
        Shape halfCircle = creazaCerc(root, 570, 450, 200, 2, Color.BLACK, Color.web("#615B5B"));
        Shape halfCircleTiny = creazaCerc(root, 570, 275, 106, 2, Color.BLACK, Color.web("#615B5B"));
        title.setEffect(colorAdjustImage);
        halfCircle.setEffect(colorAdjustImage);
        halfCircleTiny.setEffect(colorAdjustImage);
        //   
        //
        balance = makeText(root, "" + money, 550, 240, 19, Color.web("#C9BFBF"));
        balance.setEffect(colorAdjustImage);

        betSlider = createSlider(root, 420, 470, 1, 100, 300, 5);
        Shape slotMachineBackground = makeRectangle(root, 250, 250, 200, 640, 1, Color.BLACK, Color.web("#478559"));
        slotMachineOut1 = makeRectangle(root, 260, 260, 180, 200, 1, Color.BLACK, Color.web("#beef00"));
        slotMachineOut2 = makeRectangle(root, 470, 260, 180, 200, 1, Color.BLACK, Color.web("#beef00"));
        slotMachineOut3 = makeRectangle(root, 680, 260, 180, 200, 1, Color.BLACK, Color.web("#beef00"));
        slotMachineOut1.setEffect(colorAdjustImage);
        slotMachineOut2.setEffect(colorAdjustImage);
        slotMachineOut3.setEffect(colorAdjustImage);
        slotMachineBackground.setEffect(colorAdjustImage);

        backToMenu1 = creazaImageView(root, "menu.png", 10, 20, 70, 70);
        backToMenu1.setEffect(colorAdjustImage);

        bet1 = creazaImageView(root, imgArr[b1], 260, 250, 200, 200);
        bet2 = creazaImageView(root, imgArr[b2], 470, 250, 200, 200);
        bet3 = creazaImageView(root, imgArr[b3], 680, 250, 200, 200);
        bet1.setEffect(colorAdjustImage);
        bet2.setEffect(colorAdjustImage);
        bet3.setEffect(colorAdjustImage);

        Text notImportant1 = makeText(root, "1", 420, 500, 10, Color.LIME);
        Text notImportant2 = makeText(root, "100", 700, 500, 10, Color.LIME);
        notImportant1.setEffect(colorAdjustImage);
        notImportant2.setEffect(colorAdjustImage);

        btnSpin = makeBtn(root, "  Spin  ", 520, 530, 15, 50, 0);
        btnBetx2 = makeBtn(root, "x2", 650, 530, 15, 50, 0);
        btnBetx3 = makeBtn(root, "x3", 430, 530, 15, 50, 0);
        btnSpin.setEffect(colorAdjustImage);
        btnBetx2.setEffect(colorAdjustImage);
        btnBetx3.setEffect(colorAdjustImage);

        freeDollar = creazaImageView(root, "+1$.png", 780, 470, 80, 80);
        freeDollar.setEffect(colorAdjustImage);

        btnBetx2.setStyle(
                "-fx-background-radius: 5em; "
                + "-fx-min-width: 60px; "
                + "-fx-background-color: #00DE1A; "
                + "-fx-min-height: 60px; "
                + "-fx-max-width: 60px; "
                + "-fx-max-height: 60px;"
                + "-fx-font-weight: bold"
        );
        btnBetx3.setStyle(
                "-fx-background-radius: 5em; "
                + "-fx-background-color: #00DE1A; "
                + "-fx-min-width: 60px; "
                + "-fx-min-height: 60px; "
                + "-fx-max-width: 60px; "
                + "-fx-max-height: 60px;"
                + "-fx-font-weight: bold"
        );
        btnSpin.setStyle(
                "-fx-background-radius: 5em; "
                + "-fx-background-color: #00DE1A; "
                + "-fx-min-width: 100px; "
                + "-fx-min-height: 100px; "
                + "-fx-max-width: 100px; "
                + "-fx-max-height: 100px;"
                + "-fx-font-weight: bold"
        );
        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SHOP>>
        shopRoot = createAnchorPane(SCENE_WIDTH, SCENE_HEIGHT, 0, 0, Color.web("#1DBD0F"), true);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>SETTINGS>>
        settingsRoot = createAnchorPane(SCENE_WIDTH, SCENE_HEIGHT, 0, 0, Color.web("#1DBD0F"), true);
        ImageView settingsRootBackground = creazaImageView(settingsRoot, "settingsBkg.jpeg", 0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        settingsRootBackground.setEffect(colorAdjustBackground);
        Text settingsMenuText = makeText(settingsRoot, "Settings", 450, 80, 60, Color.web("#C9FFE5"));
        backToMenu = creazaImageView(settingsRoot, "backToMenu1.png", 10, 20, 70, 70);

        Shape imageOptionsBackgroundShape = makeRectangle(settingsRoot, 70, 100, 600, 260, 2, Color.BLACK, Color.CYAN);
        imageOptionsBackgroundShape.setOpacity(0.7);
        Shape backgroundOptionsBackgroundShape = makeRectangle(settingsRoot, 440, 100, 600, 260, 2, Color.BLACK, Color.CYAN);
        backgroundOptionsBackgroundShape.setOpacity(0.7);

        Text setingsTitle1 = makeText(settingsRoot, "Image\noptions", 160, 140, 22, Color.RED);
        Text setingsTitle2 = makeText(settingsRoot, "Background\n options", 500, 140, 22, Color.RED);

        Text contrastTxt1 = makeText(settingsRoot, "Contrast", 100, 200, 20, Color.BLACK);
        contrastSliderImage = createSlider(settingsRoot, 100, 220, -1, 1, 200, 0);
        Text hueTxt1 = makeText(settingsRoot, "Hue", 100, 280, 20, Color.BLACK);
        hueSliderImage = createSlider(settingsRoot, 100, 300, -1, 1, 200, 0);
        Text brightnesTxt1 = makeText(settingsRoot, "Brightnes", 100, 360, 20, Color.BLACK);
        brightnesSliderImage = createSlider(settingsRoot, 100, 380, -1, 1, 200, 0);
        Text saturrstionTxt1 = makeText(settingsRoot, "Saturation", 100, 440, 20, Color.BLACK);
        saturationSliderImage = createSlider(settingsRoot, 100, 460, -1, 1, 200, 0);
        //---------------
        Text contrastTxt2 = makeText(settingsRoot, "Contrast", 470, 200, 20, Color.BLACK);
        contrastSliderBkg = createSlider(settingsRoot, 470, 220, -1, 1, 200, 0);
        Text hueTxt2 = makeText(settingsRoot, "Hue", 470, 280, 20, Color.BLACK);
        hueSliderBkg = createSlider(settingsRoot, 470, 300, -1, 1, 200, 0);
        Text brightnesTxt2 = makeText(settingsRoot, "Brightnes", 470, 360, 20, Color.BLACK);
        brightnesSliderBkg = createSlider(settingsRoot, 470, 380, -1, 1, 200, 0);
        Text saturrstionTxt2 = makeText(settingsRoot, "Saturation", 470, 440, 20, Color.BLACK);
        saturationSliderBkg = createSlider(settingsRoot, 470, 460, -1, 1, 200, 0);

        resetImageSettings = makeBtn(settingsRoot, "Reset", 160, 650, 15, 40, 80);
        resetBackgroundSettings = makeBtn(settingsRoot, "Reset", 530, 650, 15, 40, 80);
        aplyBtn = makeBtn(settingsRoot, "Aply", 1100, 700, 15, 40, 80);

        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU>>>
        menuRoot = createAnchorPane(SCENE_WIDTH, SCENE_HEIGHT, 0, 0, Color.web("#1DBD0F"), true);
        ImageView menuRootBackground = creazaImageView(menuRoot, "menuBCK.png", 0, 0, SCENE_WIDTH, SCENE_HEIGHT);
        menuRootBackground.setEffect(colorAdjustBackground);

        Text menuText = makeText(menuRoot, "Menu", 450, 150, 90, Color.web("#1DBD0F"));
        menuText.setEffect(new Glow(2));
        //menuText.setEffect(colorAdjustImage);

        startGame = makeBtn(menuRoot, "Start", 470, 195, 20, 65, START_SCREEN_BUTTON_WIDTH);
        btnSettings = makeBtn(menuRoot, "Settings", 470, 315, 20, 65, START_SCREEN_BUTTON_WIDTH);
        exitNoSave = makeBtn(menuRoot, "Exit without saving", 470, 435, 20, 65, START_SCREEN_BUTTON_WIDTH);
        save = makeBtn(menuRoot, "Save & Exit", 470, 555, 20, 65, START_SCREEN_BUTTON_WIDTH);
        startGame.setEffect(colorAdjustImage);
        btnSettings.setEffect(colorAdjustImage);
        exitNoSave.setEffect(colorAdjustImage);
        save.setEffect(colorAdjustImage);

        decorativeImageView1 = creazaImageView(menuRoot, imgArr[1], 100, 100, 300, 300);
        decorativeImageView2 = creazaImageView(menuRoot, imgArr[2], 100, 300, 300, 300);
        decorativeImageView3 = creazaImageView(menuRoot, imgArr[3], 100, 500, 300, 300);
        decorativeImageView4 = creazaImageView(menuRoot, imgArr[4], 800, 500, 300, 300);
        decorativeImageView5 = creazaImageView(menuRoot, imgArr[5], 800, 300, 300, 300);
        decorativeImageView6 = creazaImageView(menuRoot, imgArr[8], 800, 100, 300, 300);
        decorativeImageView1.setEffect(colorAdjustImage);
        decorativeImageView2.setEffect(colorAdjustImage);
        decorativeImageView3.setEffect(colorAdjustImage);
        decorativeImageView4.setEffect(colorAdjustImage);
        decorativeImageView5.setEffect(colorAdjustImage);
        decorativeImageView6.setEffect(colorAdjustImage);
        //scenes, lol
        defaultScene = new Scene(root, SCENE_WIDTH, SCENE_HEIGHT);
        settingsScene = new Scene(settingsRoot, SCENE_WIDTH, SCENE_HEIGHT);
        menuScene = new Scene(menuRoot, SCENE_WIDTH, SCENE_HEIGHT);

        primaryStage.setTitle("CodeChest");
        primaryStage.setScene(menuScene);
        primaryStage.show();

    }//end of initComponenets

    public void addListeners(Stage primaryStage) {

        btnSpin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double xx = betSlider.getValue();
                double temp = money - xx;
                if (temp <= 0) {
                    PopUpBox.alert_box("Hey", "Looks that you dont have enough money!", Color.BLACK);

                } else {
                    money -= betSlider.getValue();
                    balance.setText(String.valueOf(money));

                    Random rand = new Random();
                    b1 = rand.nextInt((8 - 0) + 1) + 0;
                    b2 = rand.nextInt((8 - 0) + 1) + 0;
                    b3 = rand.nextInt((8 - 0) + 1) + 0;

                    setImageOnImageView(imgArr[b1], bet1);
                    setID(imgArr[b1], bet1);
                    setImageOnImageView(imgArr[b2], bet2);
                    setID(imgArr[b2], bet2);
                    setImageOnImageView(imgArr[b3], bet3);
                    setID(imgArr[b3], bet3);

//boolean popUpAnswer = PopUpBox.confirm_box("", "Hi " + name + ". Are you ready to start the game?");
                    if (bet1.getId() == bet2.getId() && bet2.getId() == bet3.getId()) {
                        double siderVal = betSlider.getValue() * 3;
                        int test = (int) Math.round(siderVal);
                        PopUpBox.alert_box("X3", "You won: " + test + "$", Color.GREY);
                        money += test;
                        balance.setText(String.valueOf(money));
                    } else if (bet2.getId() == bet3.getId()) {
                        double siderVal = betSlider.getValue() * 2;
                        int test = (int) Math.round(siderVal);
                        PopUpBox.alert_box("X2", "You won: " + test + "$", Color.GREY);
                        money += test;
                        balance.setText(String.valueOf(money));

                    } else if (bet1.getId() == bet2.getId()) {
                        //debug here 
                        //TODO:
                        //fix the delay, its not working
                        //fuck all this shit if its not working 
                        //put a simple explication in <<<PopUp>>>

                        double siderVal = betSlider.getValue() * 2;
                        int test = (int) Math.round(siderVal);
                        PopUpBox.alert_box("X2", "You won: " + test + "$", Color.GREY);
                        money += test;                     
                        balance.setText(String.valueOf(money));


                    }

                }

            }
        });

        backToMenu1.setOnMousePressed((event) -> {
            primaryStage.setScene(menuScene);

        });
        backToMenu.setOnMousePressed((event) -> {
            primaryStage.setScene(menuScene);

        });
        freeDollar.setOnMouseClicked((event) -> {
            
            if (money < 100) {
                money += 1;
                balance.setText(String.valueOf(money));//refresing money
            }

        });

        save.setOnAction((ActionEvent event) -> {
            //PopUpBox.alert_box("Warning", "Name cannot be null!");
            boolean popUpAnswer = PopUpBox.confirm_box("", "Are you sure you want to leave?", Color.web("#FC2D2D"));
            if (popUpAnswer == true) {
                SaveIO.saveScorToFile(money);
                System.exit(0);
            }
        });
        exitNoSave.setOnAction((ActionEvent event) -> {
            //PopUpBox.alert_box("Warning", "Name cannot be null!");
            System.exit(0);
        });
        aplyBtn.setOnAction((ActionEvent event) -> {
            //setingsRoot
            //image color adjust     
            colorAdjustImage.setContrast(contrastSliderImage.getValue());
            colorAdjustImage.setHue(hueSliderImage.getValue());
            colorAdjustImage.setBrightness(brightnesSliderImage.getValue());
            colorAdjustImage.setSaturation(saturationSliderImage.getValue());

            colorAdjustBackground.setContrast(contrastSliderBkg.getValue());
            colorAdjustBackground.setHue(hueSliderBkg.getValue());
            colorAdjustBackground.setBrightness(brightnesSliderBkg.getValue());
            colorAdjustBackground.setSaturation(saturationSliderBkg.getValue());
        });
        resetImageSettings.setOnAction((ActionEvent event) -> {
            contrastSliderImage.setValue(0);
            hueSliderImage.setValue(0);
            brightnesSliderImage.setValue(0);
            saturationSliderImage.setValue(0);
        });
        resetBackgroundSettings.setOnAction((ActionEvent event) -> {
            contrastSliderBkg.setValue(0);
            hueSliderBkg.setValue(0);
            brightnesSliderBkg.setValue(0);
            saturationSliderBkg.setValue(0);
        });
        startGame.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(defaultScene);
            if (firstTimeInGame) {
                PopUpBox.alert_box("Hello!", "Welcome to game", Color.GREY);
                firstTimeInGame = false;
            }
        });
        btnSettings.setOnAction((ActionEvent event) -> {
            primaryStage.setScene(settingsScene);
        });
        btnBetx2.setOnAction((ActionEvent event) -> {
            double test = betSlider.getValue() * 2;
            if (test <= 100) {
                betSlider.setValue(betSlider.getValue() * 2);
            } else {
                PopUpBox.alert_box("Warning!", "The maximum bet is 100$.", Color.GREY);
            }
        });
        btnBetx3.setOnAction((ActionEvent event) -> {
            double test = betSlider.getValue() * 3;
            if (test <= 100) {
                betSlider.setValue(test);
            } else {
                PopUpBox.alert_box("Warning!", "The maximum bet is 100$.", Color.GREY);

            }
        });

        decorativeImageView1.setOnMouseEntered((event) -> {
            decorativeImageView1.setFitHeight(330);
            decorativeImageView1.setLayoutY(decorativeImageView1.getLayoutY() - 15);
            decorativeImageView1.setFitWidth(330);
        });
        decorativeImageView1.setOnMouseExited((event) -> {
            decorativeImageView1.setFitHeight(300);
            decorativeImageView1.setLayoutY(100);
            decorativeImageView1.setFitWidth(300);
        });

        decorativeImageView2.setOnMouseEntered((event) -> {
            decorativeImageView2.setFitHeight(330);
            decorativeImageView2.setLayoutY(decorativeImageView2.getLayoutY() - 15);
            decorativeImageView2.setFitWidth(330);
        });
        decorativeImageView2.setOnMouseExited((event) -> {
            decorativeImageView2.setFitHeight(300);
            decorativeImageView2.setLayoutY(300);
            decorativeImageView2.setFitWidth(300);
        });

        decorativeImageView3.setOnMouseEntered((event) -> {
            decorativeImageView3.setFitHeight(330);
            decorativeImageView3.setLayoutY(decorativeImageView3.getLayoutY() - 15);
            decorativeImageView3.setFitWidth(330);
        });
        decorativeImageView3.setOnMouseExited((event) -> {
            decorativeImageView3.setFitHeight(300);
            decorativeImageView3.setLayoutY(500);
            decorativeImageView3.setFitWidth(300);
        });

        decorativeImageView4.setOnMouseEntered((event) -> {
            decorativeImageView4.setFitHeight(330);
            decorativeImageView4.setLayoutY(decorativeImageView4.getLayoutY() - 15);
            decorativeImageView4.setFitWidth(330);
        });
        decorativeImageView4.setOnMouseExited((event) -> {
            decorativeImageView4.setFitHeight(300);
            decorativeImageView4.setLayoutY(500);
            decorativeImageView4.setFitWidth(300);
        });

        decorativeImageView5.setOnMouseEntered((event) -> {
            decorativeImageView5.setFitHeight(330);
            decorativeImageView5.setLayoutY(decorativeImageView5.getLayoutY() - 15);
            decorativeImageView5.setFitWidth(330);
        });
        decorativeImageView5.setOnMouseExited((event) -> {
            decorativeImageView5.setFitHeight(300);
            decorativeImageView5.setLayoutY(300);
            decorativeImageView5.setFitWidth(300);
        });

        decorativeImageView6.setOnMouseEntered((event) -> {
            decorativeImageView6.setFitHeight(330);
            decorativeImageView6.setLayoutY(decorativeImageView6.getLayoutY() - 15);
            decorativeImageView6.setFitWidth(330);
        });
        decorativeImageView6.setOnMouseExited((event) -> {
            decorativeImageView6.setFitHeight(300);
            decorativeImageView6.setLayoutY(100);
            decorativeImageView6.setFitWidth(300);
        });

    }//end of addListners

//Voids here:
    public void setID(String x, ImageView bet) {

        switch (x) {
            case "swift.png":
                bet.setId(x);
                break;
            case "sql.png":
                bet.setId(x);

                break;
            case "ruby.png":
                bet.setId(x);

                break;
            case "python.png":
                bet.setId(x);

                break;
            case "php.png":
                bet.setId(x);

                break;
            case "js.png":
                bet.setId(x);

                break;
            case "java.png":
                bet.setId(x);

                break;
            case "c++.png":
                bet.setId(x);

                break;
            case "c#.png":
                bet.setId(x);

                break;

            default:
                bet.setId("java.png");

                break;
        }
    }

    @Override
    public void stop() {
        boolean popUpAnswer = PopUpBox.confirm_box("Atention", "Do you want to save?", Color.web("#FC2D2D"));
        if (popUpAnswer == true) {
            SaveIO.saveScorToFile(money);
            System.exit(0);
        }
    }

    public void setImageOnImageView(String imageName, ImageView imageView) {
        try {
            Image imagine = new Image(new FileInputStream(imageName), 200, 200, false, false);
            imageView.setImage(imagine);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ComplexJavaApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setBackgroundImage(Pane pane, String imagePath) {
        BackgroundImage myBI = new BackgroundImage(new Image(imagePath, SCENE_WIDTH, SCENE_HEIGHT, false, true),
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        pane.setBackground(new Background(myBI));
    }

    public static void main(String[] args) {//Voids up .....Methods down
        launch(args);
    }//end of main

    private Button makeBtn(Pane pane, String tt, int x, int y, int font, int height, int width) {
        Button btn = new Button();
        btn.setLayoutX(x);
        btn.setLayoutY(y);
        btn.setText(tt);
        btn.setMinSize(width, height);
        btn.setCursor(Cursor.HAND);
        btn.setEffect(new Glow(-2));
        btn.setFont(Font.font(STYLESHEET_MODENA, font));
        btn.setStyle("-fx-background-color: #00DE1A; "
                + "-fx-border-color: #000000; -fx-border-width: 3px;");
        pane.getChildren().add(btn);
        return btn;

    }//end of makeBtn 

    public Circle creazaCerc(Pane pane, int x, int y, int r, int strwith, Color cool, Color color) {
        Circle c = new Circle();
        c.setLayoutX(x);
        c.setLayoutY(y);
        c.setRadius(r);
        c.setFill(color);
        c.setStroke(cool);
        c.setStrokeWidth(strwith);

        pane.getChildren().add(c);
        return c;

    }

    private Rectangle makeRectangle(Pane pane, int X, int Y, int l, int L, int strokeWidth, Color strokeColor, Color fillColor) {
        //rectangle setting Wachout
        Rectangle rekt = new Rectangle();
        rekt.setX(X);
        rekt.setY(Y);
        rekt.setWidth(L);
        rekt.setHeight(l);
        rekt.setArcHeight(40);
        rekt.setArcWidth(40);
        rekt.setFill(fillColor);
        rekt.setStroke(strokeColor);
        rekt.setStrokeWidth(strokeWidth);
        pane.getChildren().add(rekt);

        return rekt;
    }//end of makeRectangle

    private AnchorPane createAnchorPane(int paneWidth, int paneHeight, int x, int y, Color paneColor, boolean setVisible) {
        AnchorPane vb = new AnchorPane();
        vb.setLayoutX(x);
        vb.setLayoutY(y);
        vb.setMinSize(paneWidth, paneHeight);
        vb.setMaxSize(paneWidth, paneHeight);
        vb.setBackground(new Background(new BackgroundFill(paneColor, CornerRadii.EMPTY, Insets.EMPTY)));
        vb.setVisible(setVisible);
        //pane.getChildren().add(vb);
        return vb;

    }

    private TextField createTextField(Pane pano, int x, int y, int l, int L, double opacity) {
        TextField textField = new TextField();
        textField.setOpacity(opacity);
        textField.setMaxSize(L, l);
        textField.setLayoutX(x);
        textField.setLayoutY(y);
        pano.getChildren().add(textField);
        return textField;
    }

    private Slider createSlider(Pane pane, int x, int y, int min, int max, int minWidth, int defaultV) {
        Slider slider = new Slider();
        slider.setMax(max);
        slider.setLayoutX(x);
        slider.setLayoutY(y);
        slider.setMin(min);
        //slider.setShowTickLabels(true);
        //slider.setShowTickMarks(true);
        slider.setValue(defaultV);
        slider.setMinWidth(minWidth);
        slider.setMinHeight(10);
        slider.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                String style = String.format("-fx-background-color: linear-gradient(to right, #2D819D %d%%, #969696 %d%%);",
                        new_val.intValue(), new_val.intValue());

            }
        });

        slider.setBlockIncrement(5);
        pane.getChildren().add(slider);
        return slider;
    }//end of createSlider

    private Text makeText(Pane pane, String text, int x, int y, int font, Color txtColor) {
        Text txt = new Text(text);
        txt.setLayoutX(x);
        txt.setLayoutY(y);
        txt.setFont(Font.font(font));
        txt.setFill(txtColor);
        txt.setStyle("-fx-font-weight: bold");

        pane.getChildren().addAll(txt);
        return txt;

    }

    private ImageView creazaImageView(Pane pane, String filePath, int x, int y, int width, int height) throws FileNotFoundException {
        Image imagine = new Image(new FileInputStream(filePath));
        ImageView imageView = new ImageView(imagine);
        imageView.setLayoutX(x);
        imageView.setLayoutY(y);
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);
        imageView.setPreserveRatio(false);
        pane.getChildren().add(imageView);
        return imageView;
    }//end of creazaImageView

    public MediaPlayer creazaMediaPlayer(String fileName) {
        Media media = new Media(new File(fileName).toURI().toString());
        MediaPlayer madiaPlayer = new MediaPlayer(media);
        madiaPlayer.setAutoPlay(true);
        return madiaPlayer;
    }
}
