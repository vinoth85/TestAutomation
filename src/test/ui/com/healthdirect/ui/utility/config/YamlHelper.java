package com.healthdirect.ui.utility.config;

import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class YamlHelper {

    public static Map<String, String> loadUrlYamlFiles() throws IOException, URISyntaxException {
        return loadYamlFiles("/config/url.yml");
    }

    /**
     * Parse the YAML file and return the output as a series of Maps and Lists
     */
    private static Map loadYamlFiles(String filePath) throws IOException, URISyntaxException {
        Yaml yaml = new Yaml();
        return (Map) yaml.load(YamlHelper.class.getResourceAsStream(filePath));
    }
}
