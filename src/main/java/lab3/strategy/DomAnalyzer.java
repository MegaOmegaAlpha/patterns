package lab3.strategy;

import lab3.strategy.pojo.Student;
import lab3.strategy.pojo.Subject;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DomAnalyzer implements XmlAnalyzerStrategy {

    @Override
    public void analyze(File input, File output) {
        try {
            double averageDoc = 0, averageCalc = 0;
            Student student = new Student();
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document documentIn = documentBuilder.parse(input);
            NodeList nodeList = documentIn.getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node studentNode = nodeList.item(i);
                NamedNodeMap namedNodeMap = studentNode.getAttributes();
                Node lastNameNode = namedNodeMap.getNamedItem("lastname");
                String studentLastName = lastNameNode.getNodeValue();
                NodeList studentTagChildList = studentNode.getChildNodes();
                List<Subject> subjectList = new ArrayList<>();
                for (int j = 0; j < studentTagChildList.getLength(); j++) {
                    Node studentChildNode = studentTagChildList.item(j);
                    if (studentChildNode.getNodeName().equals("subject")) {
                        NamedNodeMap nodeMap = studentChildNode.getAttributes();
                        Node subjectName = nodeMap.getNamedItem("title");
                        Node mark = nodeMap.getNamedItem("mark");
                        subjectList.add(new Subject(subjectName.getNodeValue(), Integer.parseInt(mark.getNodeValue())));
                        System.out.println(subjectName.getNodeValue() + " " + mark.getNodeValue());
                    } else {
                        if (studentChildNode.getNodeName().equals("average")) {
                            String avgNode = studentChildNode.getTextContent();
                            averageDoc = Double.parseDouble(avgNode);
                            System.out.println("Document's value: " + averageDoc);
                        }
                    }
                }
                student.setLastName(studentLastName);
                student.setSubjectList(subjectList);
            }
            System.out.println("Calculated value: " + (averageCalc = avg(student.getSubjectList())));
            if (averageCalc != averageDoc) {
                System.out.println("Values aren't equal");
                averageDoc = averageCalc;
            } else {
                System.out.println("It's ok");
            }
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
            avgElement.setTextContent(String.valueOf(averageDoc));
            root.appendChild(avgElement);
            DOMSource domSource = new DOMSource(documentOut);
            FileOutputStream fileOutputStream = new FileOutputStream(output);
            StreamResult streamResult = new StreamResult(fileOutputStream);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(domSource, streamResult);

        } catch (ParserConfigurationException | TransformerException | IOException | SAXException e) {
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

}
