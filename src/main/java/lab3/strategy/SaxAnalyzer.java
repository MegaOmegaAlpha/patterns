package lab3.strategy;

import lab3.strategy.pojo.Student;
import lab3.strategy.pojo.Subject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class SaxAnalyzer implements XmlAnalyzerStrategy {

    private Student student;
    private double docAverage;

    @Override
    public void analyze(File input, File output) {
        try {
            SAXParser saxParser = SAXParserFactory.newInstance().newSAXParser();
            student = new Student();
            saxParser.parse(input, new AnalyzePerformer());
            System.out.println("Document's value: " + docAverage);
            double calculatedAverage = avg(student.getSubjectList());
            System.out.println("Calculated value: " + calculatedAverage);
            if (docAverage != calculatedAverage) {
                System.out.println("values aren't equal");
                docAverage = calculatedAverage;
            }
            writeXml(output);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private void writeXml(File output) throws ParserConfigurationException {
        try {
            Document documentOut = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            Element root = documentOut.createElement("student");
            root.setAttribute("lastname", student.getLastName());
            documentOut.appendChild(root);
            List<Subject> subjectList = student.getSubjectList();
            for (Subject subject : subjectList) {
                Element subjectElement = documentOut.createElement("subject");
                subjectElement.setAttribute("title", subject.getName());
                subjectElement.setAttribute("mark", String.valueOf(subject.getMark()));
                root.appendChild(subjectElement);
            }
            Element avgElement = documentOut.createElement("average");
            avgElement.setTextContent(String.valueOf(docAverage));
            root.appendChild(avgElement);
            DOMSource domSource = new DOMSource(documentOut);
            FileOutputStream fileOutputStream = new FileOutputStream(output);
            StreamResult streamResult = new StreamResult(fileOutputStream);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(domSource, streamResult);
        } catch (TransformerException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private double avg(List<Subject> subjectList) {
        double sum = 0;
        for (Subject subject : subjectList) {
            sum += subject.getMark();
        }
        return sum / subjectList.size();
    }

    private class AnalyzePerformer extends DefaultHandler {

        private String lastElementName;

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals("student")) {
                student.setLastName(attributes.getValue("lastname"));
            } else if (qName.equals("subject")) {
                String subjectName = attributes.getValue("title");
                int mark = Integer.parseInt(attributes.getValue("mark"));
                student.getSubjectList().add(new Subject(subjectName, mark));
                System.out.println(subjectName + " " + mark);
            }
            lastElementName = qName;
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            if (lastElementName.equals("average")) {
                String average = new String(ch, start, length);
                docAverage = Double.parseDouble(average);
                lastElementName = "";
            }
        }

    }

}
