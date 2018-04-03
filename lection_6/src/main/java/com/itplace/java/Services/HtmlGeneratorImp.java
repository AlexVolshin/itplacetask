package com.itplace.java.Services;

import com.itplace.java.Api.HtmlGenerator;
import com.itplace.java.Api.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

@Component
public class HtmlGeneratorImp implements HtmlGenerator {

    private PropertyService propertyService;

    @Autowired
    public HtmlGeneratorImp(@Qualifier("propertyServiceImp") PropertyService service) {
        this.propertyService = service;
    }

    @Override
    public void generate(String propertyFile, String resultFile) {
        Properties properties = this.propertyService.getProperties(propertyFile);
        if (properties == null) {
            System.err.println("Error, unable read input.properties");
            return;
        }
        try (final OutputStreamWriter stream = new OutputStreamWriter(new FileOutputStream(resultFile),
                Charset.forName("UTF-8"))) {
            String content = "<!DOCTYPE html>\n"
                    + "<html lang=\"ru\">\n"
                    + "<head>\n"
                    + "    <meta charset=\"UTF-8\">\n"
                    + "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "    <title>Решение тестового задания Java</title>\n"
                    + "    <link rel=\"stylesheet\" " +
                    "href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" " +
                    "integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" " +
                    "crossorigin=\"anonymous\">\n"
                    + "</head>\n"
                    + "<body>\n"
                    + "    <div class=\"container\">\n"
                    + "        <h2 class=\"text-center\"><strong>Резюме</strong></h2>\n"
                    + "        <h3 class=\"text-center\">на должность довакина</h3>\n"
                    + "        <div class=\"row\">\n"
                    + "            <div class=\"col-md-4\">\n"
                    + "                <p class=\"text-right\"><strong>ФИО:</strong></p>\n"
                    + "                <p class=\"text-right\"><strong>Дата рождения:</strong></p>\n"
                    + "                <p class=\"text-right\"><strong>Телефон:</strong></p>\n"
                    + "                <p class=\"text-right\"><strong>e-mail:</strong></p>\n"
                    + "                <p class=\"text-right\"><strong>Skype:</strong></p>\n"
                    + "            </div>\n"
                    + "            <div class=\"col-md-4\">\n"
                    + "                " + "<p class=\"text-left\">" + properties.getProperty("FIO", "") + "</p>\n"
                    + "                " + "<p class=\"text-left\">" + properties.getProperty("DOB", "") + "</p>\n"
                    + "                " + "<p class=\"text-left\">" + properties.getProperty("phone", "") + "</p>\n"
                    + "                " + "<p class=\"text-left\">" + properties.getProperty("email", "") + "</p>\n"
                    + "                " + "<p class=\"text-left\">" + properties.getProperty("skype", "") + "</p>\n"
                    + "            </div>\n"
                    + "            <div class=\"col-md-4\">\n"
                    + "                <img src=\"" + properties.getProperty("avatar", "")
                    + "\" class=\"img-responsive img-thumbnail\" alt=\"\">\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + formatList("Цель", Arrays.asList(properties.getProperty("target", "").split("\",\"")))
                    + formatList("Опыт", Arrays.asList(properties.getProperty("experience", "").split("\",\"")))
                    + formatList("Образование", Arrays.asList(properties.getProperty("education", "").split("\",\"")))
                    + formatList("Доп. образование и курсы",
                                 Arrays.asList(properties.getProperty("additional", "").split("\",\"")))
                    + formatList("Навыки", Arrays.asList(properties.getProperty("skills", "").split("\",\"")))
                    + formatList("Пример кода", Arrays.asList(properties.getProperty("example", "").split("\",\"")))
                    + "    </div>\n"
                    + "</body>"
                    + "</html>";
            stream.write(content, 0, content.length());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private String formatList(String label, List<String> values) {
        StringBuilder str = new StringBuilder("        <h4><strong>");
        str.append(label);
        str.append("</strong></h4>\n");
        if (values.isEmpty())
            return str.toString();
        if (values.size() == 1) {
            str.append("                <p class=\"text-left\">");
            str.append(values.get(0));
            str.append("</p>\n");
            return str.toString();
        }
        str.append("<ol>\n");
        for (int i=0;i<values.size();++i) {
            str.append("<li>");
            if (i == 0)
                str.append(values.get(i).substring(1));
            else if (i == values.size() - 1)
                str.append(values.get(i).substring(0, values.get(i).length() - 1));
            else
                str.append(values.get(i));
            str.append("</li>");
        }
        str.append("</ol>\n");
        return str.toString();
    }

}
