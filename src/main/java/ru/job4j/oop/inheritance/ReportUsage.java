package ru.job4j.oop.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        HtmlReport report = new HtmlReport();
        JSONReport jsonReport = new JSONReport();

        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        text = jsonReport.generate("Report's JSON", "Report's Json body");
        System.out.println(text);
    }
}
