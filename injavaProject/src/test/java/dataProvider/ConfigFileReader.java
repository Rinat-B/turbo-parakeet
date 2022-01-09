package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = "configs//Configuration.properties";


    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("configs//Configuation.properties"));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + "configs//Configuation.properties");
        }
    }

    public Integer getSearchColumn() {
        Integer searchColumn = Integer.parseInt(properties.getProperty("searchColumn"));
        if (searchColumn != null) return searchColumn;
        else throw new RuntimeException("searchColumn not specified in the Configuration.properties file.");
    }

    public Integer returnColumnText() {
        Integer returnColumnText = Integer.parseInt(properties.getProperty("returnColumnText"));
        if (returnColumnText != null) return returnColumnText;
        else throw new RuntimeException("returnColumnText not specified in the Configuration.properties file.");
    }

    public String searchText() {
        String searchText = properties.getProperty("searchText");
        if (searchText != null) return searchText;
        else throw new RuntimeException("searchText not specified in the Configuration.properties file.");
    }

    public String exeptedText() {
        String exeptedText = properties.getProperty("exeptedText");
        if (exeptedText != null) return exeptedText;
        else throw new RuntimeException("exeptedText not specified in the Configuration.properties file.");
    }

    public String path() {
        String path = properties.getProperty("path");
        if (path != null) return path;
        else throw new RuntimeException("path not specified in the Configuration.properties file.");
    }

    public String cell() {
        String cell = properties.getProperty("cell");
        if (cell != null) return cell;
        else throw new RuntimeException("cell not specified in the Configuration.properties file.");
    }

    public String id() {
        String id = properties.getProperty("id");
        if (id != null) return id;
        else throw new RuntimeException("id not specified in the Configuration.properties file.");
    }
}