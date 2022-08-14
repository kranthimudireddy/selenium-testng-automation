package com.autopractice.ui.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class GenericUtils {

    public static Properties prop = new Properties();
    public static String baseURL;
    public static final Logger logger = LogManager.getLogger(GenericUtils.class);

    public static void readProps() {
        logger.info("user.dir - " + System.getProperty("user.dir"));

        try (InputStream input = new FileInputStream(System.getProperty("user.dir") + System.getProperty("file.separator") + "dot.properties")) {
            prop = new Properties();
            prop.load(input);
            baseURL = prop.getProperty("baseURL");

        } catch (Exception e) {
            logger.info("Exception - " + e);
        }
        logger.info("baseURL - " + baseURL);

    }

}