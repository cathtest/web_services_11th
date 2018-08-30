package com.kathy.mentoring.Reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReaderSingleton {

    private static ReaderSingleton _instance;
    private Properties properties;

    public static ReaderSingleton getInstance(){
        if (_instance == null) {
            _instance = new ReaderSingleton();
        }
        return _instance;
    }

    private FileReader reader;

    private void createReader(String fileName){
        try {
            this.reader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public FileReader getReader(){
        properties = new Properties();
        try {
            properties.load(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reader;
    }

    public String getValue(String value){
        ReaderSingleton.getInstance().createReader("src\\test\\resources\\keys.properties");
        getReader();
        return properties.getProperty(value);
    }
}
