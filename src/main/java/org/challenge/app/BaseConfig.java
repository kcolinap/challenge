package org.challenge.app;

public class BaseConfig {

    private static String URl;
    public static int INICIATED = 0;

    public static String getURl() {
        return URl;
    }

    public static void setURl(String URl) {
        BaseConfig.URl = URl;
    }
}
