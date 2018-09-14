package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShopManagmentAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShopManagmentAppApplication.class, args);
    }

    /*
    * TODO
    * -add jwt + authenticate roles
    * -Validation
    * -logout button change with login button
    * */
}
