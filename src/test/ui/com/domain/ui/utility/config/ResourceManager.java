package com.domain.ui.utility.config;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

@Slf4j
public class ResourceManager {

    private static Map<String, String> urls;
    static {
        try {
            urls = YamlHelper.loadUrlYamlFiles();
        } catch (IOException e) {
            log.error("Exception occurred while reading Yaml files", e);
            e.printStackTrace();
        } catch (URISyntaxException e) {
            log.error("Exception occurred while reading Yaml files", e);
        }
    }

    /**
     * return URL
     */
    public static String getUrl(final String url) {
        return urls.get(url);
    }

}
