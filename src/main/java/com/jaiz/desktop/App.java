package com.jaiz.desktop;

import javafx.application.Application;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //字体渲染抗锯齿
        System.setProperty("prism.lcdtext", "false");
        Application.launch(Index.class, args);
    }
}

