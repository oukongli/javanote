package com.shdev.demo.mail.javamail;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.File;
import java.io.IOException;

/**
 * Created by ou_ko on 2016/7/17.
 */
public class TemplateUtil {
    public static Configuration configuration;

    static {
        configuration = new Configuration(Configuration.VERSION_2_3_25);
        try {
            configuration.setDirectoryForTemplateLoading(new File("template"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        configuration.setDefaultEncoding("UTF-8");
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        configuration.setLogTemplateExceptions(false);
    }

    public static Template getFreeMarkerTemplate(String templateName) throws IOException {
        return configuration.getTemplate(templateName);
    }
}
