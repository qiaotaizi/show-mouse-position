package com.jaiz.desktop;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.List;

public class Index extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var root=new StackPane();
        var scene=new Scene(root);
        primaryStage.setTitle("show mouse position");
        primaryStage.setScene(scene);
        var screenBound= Screen.getPrimary().getBounds();
        System.out.printf("height = %s, width = %s%n",screenBound.getHeight(),screenBound.getWidth());
        root.setPrefHeight(screenBound.getHeight());
        root.setPrefWidth(screenBound.getWidth());
        primaryStage.setOpacity(0.6);//透明度控制
        primaryStage.setAlwaysOnTop(true);//始终置顶
        primaryStage.initStyle(StageStyle.UNDECORATED);//无标题栏，无边框
        primaryStage.show();


        var style="-fx-font-size: 50;" +
                "-fx-fill: GRAY";
        Text quitHintText=new Text("按Command+q以关闭");
        Text coordText=new Text("(0,0)");
        quitHintText.setStyle(style);
        coordText.setStyle(style);

        VBox vBox=new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(quitHintText,coordText);
        root.getChildren().add(vBox);


        //root

        root.setOnMouseMoved(event->{
            var x=event.getX();
            var y=event.getY();
            coordText.setText(String.format("(%s,%s)",x,y));
        });

        List<Point2D> points=new ArrayList<>();

        root.setOnMouseClicked(event -> {
            var x=event.getX();
            var y=event.getY();
            points.add(new Point2D(x,y));
        });

        primaryStage.setOnCloseRequest(event->{
            points.forEach(p->{
                System.out.printf("new Point(%d,%d),%n",(int)p.getX(),(int)p.getY());
            });
        });

    }
}
