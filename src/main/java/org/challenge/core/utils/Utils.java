package org.challenge.core.utils;

import org.challenge.app.BaseConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Utils {

    private  static final Properties properties = new Properties();


    public static String getProperty(String property, String filename) throws IOException {
        try {
            String userDir = System.getProperty("user.dir");

            FileInputStream fis = new FileInputStream(userDir + "/src/main/resources/properties/"+filename.toLowerCase()+".properties");
            properties.load(fis);

            return properties.getProperty(property);

        } catch (Exception | Error e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void setProperties() throws IOException {
        BaseConfig.setURl(getProperty("url", "settings"));
    }

    /************
     *  GENERATE RANDOM NUMBER
     ***********/
    public static int generateRandomNumber(int lenght) {
        int number;
        do {
            switch (lenght) {
                case 1:
                    number = (int) (10 * Math.random());
                    break;
                case 2:
                    number = (int) (100 * Math.random());
                    break;
                case 3:
                    number = (int) (1000 * Math.random());
                    break;
                case 4:
                    number = (int) (10000 * Math.random());
                    break;
                case 5:
                    do
                        number = (int) Math.floor(Math.random() * 99999 + 1);
                    while (String.valueOf(number).length() < 5);
                    break;
                case 6:
                    number = (int) (1000000 * Math.random());
                    break;
                case 7:
                    number = (int) (10000000 * Math.random());
                    break;
                case 8:
                    number = (int) (100000000 * Math.random() + 1);
                    break;
                default:
                    number = (int) (1 * Math.random());
                    break;
            }
        } while (String.valueOf(number).length() < lenght);


        return number;
    }

    public static String getRandomEmail(){
        return "Test" + generateRandomNumber(5) + "@yopmail.com";
    }


}
