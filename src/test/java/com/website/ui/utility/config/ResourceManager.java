package com.website.ui.utility.config;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ResourceManager {

    private static Map<String, String> urls;
    static {
        try {
            urls = YamlHelper.loadUrlYamlFiles();
        } catch (IOException e) {

            e.printStackTrace();
        } catch (URISyntaxException e) {

        }
    }

    /**
     * return URL
     */
    public static String getUrl(final String url) {
        return urls.get(url);
    }

}
