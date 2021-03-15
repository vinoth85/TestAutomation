package com.website.ui.utility;

import net.masterthought.cucumber.ReportBuilder;
import org.apache.velocity.exception.VelocityException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CucumberReport {

    public static void generateReport() throws VelocityException, IOException {
        File reportOutputDirectory = new File("target/cba-cucumber-report");
        List<String> list = new ArrayList<String>();
        list.add("target/cucumber-json-report.json");

        String pluginUrlPath = "";
        String buildNumber = "1";
        String buildProject = "cucumber-jvm";
        boolean skippedFails = true;
        boolean pendingFails = true;
        boolean undefinedFails = true;
        boolean missingFails = true;
        boolean flashCharts = true;
        boolean runWithJenkins = false;
        boolean artifactsEnabled = false;
        String artifactConfig = "";
        boolean highCharts = false;

        ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
                buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins, artifactsEnabled,
                artifactConfig, highCharts, false);
        reportBuilder.generateReports();
    }
}
