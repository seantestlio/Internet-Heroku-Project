package dataProvider;

import java.io.*;
import java.util.Properties;

public class ConfigReader  {
    protected static Properties properties;
    protected static ConfigReader configReader;
    public ConfigReader()  {
        BufferedReader reader;
        String propertyFilePath = "C:\\Users\\user\\Git practice\\internet\\src\\configs\\configuration.properties";
        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e)  {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e)  {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties is not found at " + propertyFilePath);
        }
    }

    public static ConfigReader getInstance()  {
        if (configReader == null)  {
            configReader = new ConfigReader();
        }
        return configReader;
    }

    public String getBaseURL()  {
        String baseUrl = properties.getProperty("baseURL");
        if(baseUrl != null)  {
            return baseUrl;
        } else {
            throw new RuntimeException("baseURL unspecified");
        }
    }

    public String getSauceLabUserName()  {
        String sauceLabsUserName = properties.getProperty("sauceLabsUserName");
        if (sauceLabsUserName != null)  {
            return sauceLabsUserName;
        } else throw new RuntimeException("sauceLabsUserName unspecified");
    }

    public String getSauceLabAccessKey()  {
        String sauceLabsAccessKey = properties.getProperty("sauceLabsAccessKey");
        if (sauceLabsAccessKey != null)  {
            return sauceLabsAccessKey;
        } else throw new RuntimeException("sauceLabsAccessKey unspecified");
    }

    public String getSauceLabUrl()  {
        String sauceLabsURL = properties.getProperty("sauceLabsURL");
        if (sauceLabsURL != null)  {
            return sauceLabsURL;
        } else throw new RuntimeException("sauceLabsURL unspecified");
    }

    public String getLambdaTestUserName()  {
        String lambdaTestUserName = properties.getProperty("lambdaTestUserName");
        if (lambdaTestUserName != null)  {
            return lambdaTestUserName;
        } else throw new RuntimeException("lambdaTestUserName unspecified");
    }

    public String getLambdaTestAccessKey()  {
        String lambdaTestAccessKey = properties.getProperty("lambdaTestAccessKey");
        if (lambdaTestAccessKey != null)  {
            return lambdaTestAccessKey;
        } else throw new RuntimeException("lambdaTestAccessKey unspecified");
    }

    public String getLambdaURL()  {
        String lambdaTestURL = properties.getProperty("lambdaTestURL");
        if (lambdaTestURL != null)  {
            return lambdaTestURL;
        } else throw new RuntimeException("lambdaTestURL unspecified");
    }
}