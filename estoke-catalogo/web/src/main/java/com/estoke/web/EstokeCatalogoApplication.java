package com.estoke.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vitor.alves
 */
@SpringBootApplication
public class EstokeCatalogoApplication {

    public static void main(String[] args) {
        EstokeCatalogoApplication.getApp().run(args);
    }

    public static SpringApplication getApp() {
        return new SpringApplication(EstokeCatalogoApplication.class);
    }
}
