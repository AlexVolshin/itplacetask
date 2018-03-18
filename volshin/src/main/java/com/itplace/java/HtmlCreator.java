package com.itplace.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.OutputStreamWriter;

public class HtmlCreator {
    HtmlCreator(Properties prop) {
        properties = prop;
    }

    /**
     * Метод генериует строку с html тегами и текстом и записывает её в файл
     * @param fileName имя файла
     */
    public void create(String fileName) {
        try (final FileOutputStream out = new FileOutputStream(fileName);
			 final OutputStreamWriter stream = new OutputStreamWriter(out, "UTF-8")) {
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
                    + "                " + getParagraph("FIO")
                    + "                " + getParagraph("DOB")
                    + "                " + getParagraph("phone")
                    + "                " + getParagraph("email")
                    + "                " + getParagraph("skype")
                    + "            </div>\n"
                    + "            <div class=\"col-md-4\">\n"
                    + "                <img src=\"" + properties.getProperty("avatar", "")
                    + "\" class=\"img-responsive img-thumbnail\" alt=\"\">\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + getList("Цель", "target")
                    + getList("Опыт", "experience")
                    + getList("Образование", "education")
                    + getList("Доп. образование и курсы", "additional")
                    + getList("Навыки", "skills")
                    + getList("Пример кода", "example")
                    + "    </div>\n"
                    + "</body>"
                    + "</html>";
			stream.write(content, 0, content.length());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    private Properties properties;

    /**
     * Метод генерации текстового параграфа на основе данных из .properties файла
     * @param key ключ в .properties файле
     * @return строка с текстом параграфа
     */
    private String getParagraph(String key) {
        return "<p class=\"text-left\">" + properties.getProperty(key, " - ") + "</p>\n";
    }

    /**
     * Метод генерации текстового абзаца со списком или без него, на основе данных из .properties файла
     * @param label заголовок абзаца
     * @param key ключ в .properties файле
     * @return строка с текстом абзаца
     */
    private String getList(String label, String key) {
        StringBuilder str = new StringBuilder("        <h4><strong>");
        str.append(label);
        str.append("</strong></h4>\n");
        String value = properties.getProperty(key, "");
        if (value.isEmpty())
            return str.toString();
        String[] values = value.split("\",\"");
        if (values.length == 1) {
            str.append("                <p class=\"text-left\">");
            str.append(values[0]);
            str.append("</p>\n");
            return str.toString();
        }
        str.append("<ol>\n");
        for (int i=0;i<values.length;++i) {
            str.append("<li>");
            if (i == 0)
                str.append(values[i].substring(1));
            else if (i == values.length - 1)
                str.append(values[i].substring(0, values[i].length() - 1));
            else
                str.append(values[i]);
            str.append("</li>");
        }
        str.append("</ol>\n");
        return str.toString();
    }
}
