import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class ReadingStudents {
    String pathFileAllStudents = "src/allStudents.txt";
    List<Student> listOfAllStudents = new ArrayList<>();
    int parsingOption = 0;
    public ReadingStudents() { }

    public void setParsingOption(int parsingOption) {
        this.parsingOption = parsingOption;
    }

    public ReadingStudents(String pathFileAllStudents, int index) throws IOException, NumberFormatException, ParserConfigurationException, SAXException {
        if (!pathFileAllStudents.equals("")) {
            this.pathFileAllStudents = pathFileAllStudents;
        }
        if (pathFileAllStudents.endsWith(".xml")) {
            parsingOption = index;
            switch (parsingOption) {
                case 0:
                    System.out.println("SAX");
                    SAXParserFactory factory1 = SAXParserFactory.newInstance();
                    SAXParser parser = factory1.newSAXParser();
                    XMLReader reader = parser.getXMLReader();
                    SAXHandler handler = new SAXHandler();
                    reader.setContentHandler(handler);
                    reader.parse(pathFileAllStudents);
                    listOfAllStudents = handler.students;
                    break;
                case 1:
                    File file = new File(pathFileAllStudents);
                    System.out.println("DOM");

                    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    Document document = builder.parse(file);

                    NodeList studentNode = document.getElementsByTagName("student");

                    for (int i = 0; i < studentNode.getLength(); i++) {
                        Student student1 = null;
                        if (studentNode.item(i).getNodeType() == Node.ELEMENT_NODE) {
                            Element student = (Element) studentNode.item(i);
                            student1 = new Student();
                            student1.numOfCreditBook = Integer.parseInt(student.getAttribute("numberOfBook"));
                            student1.surname = student.getAttribute("surname");
                            student1.numberSemester = Integer.parseInt(student.getAttribute("numberOfSemester"));

                            NodeList subjAndMarksList = student.getChildNodes();

                            for (int j = 0; j < subjAndMarksList.getLength(); j++) {
                                if (subjAndMarksList.item(j).getNodeType() == Node.ELEMENT_NODE) {
                                    Element subjAndMark = (Element) subjAndMarksList.item(j);

                                    switch (subjAndMark.getTagName()) {
                                        case "subj1":
                                            student1.subject1 = subjAndMark.getTextContent();
                                            break;
                                        case "mark1":
                                            student1.mark1 = Integer.parseInt(subjAndMark.getTextContent());
                                            break;
                                        case "subj2":
                                            student1.subject2 = subjAndMark.getTextContent();
                                            break;
                                        case "mark2":
                                            student1.mark2 = Integer.parseInt(subjAndMark.getTextContent());
                                            break;
                                    }
                                }
                            }
                        }
                        listOfAllStudents.add(student1);
                    }
                    break;
            }
        }

        if (pathFileAllStudents.endsWith(".txt")) {
            File allStudents = new File(this.pathFileAllStudents);
            Scanner scanner = new Scanner(allStudents);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("")) {
                    continue;
                }
                StringTokenizer tokenizer = new StringTokenizer(line, " ");
                int numOfCreditBook = Integer.parseInt(tokenizer.nextToken());
                String surname = tokenizer.nextToken();
                int numberSemester = Integer.parseInt(tokenizer.nextToken());
                String subject1 = tokenizer.nextToken();
                int mark1 = Integer.parseInt(tokenizer.nextToken());
                String subject2 = tokenizer.nextToken();
                int mark2 = Integer.parseInt(tokenizer.nextToken());

                if (subject1.compareTo(subject2) < 0) {
                    String temp = subject2;
                    subject2 = subject1;
                    subject1 = temp;
                }

                if (numOfCreditBook < 0 || numberSemester < 0 || mark1 < 0 || mark2 < 0) {
                    throw new NumberFormatException();
                }
                Student student = new Student(numOfCreditBook, surname, numberSemester, subject1, mark1, subject2, mark2);
                listOfAllStudents.add(student);
            }
        }
    }

    public void addNewStudent(String newStudStr) throws NumberFormatException {
        StringTokenizer token = new StringTokenizer(newStudStr, " ");
        System.out.println("all fine");
        while (token.hasMoreTokens()) {
            int numOfCreditBook = Integer.parseInt(token.nextToken());
            String surname = token.nextToken();
            int numberSemester = Integer.parseInt(token.nextToken());
            String subject1 = token.nextToken();
            int mark1 = Integer.parseInt(token.nextToken());
            String subject2 = token.nextToken();
            int mark2 = Integer.parseInt(token.nextToken());

            if (subject1.compareTo(subject2) < 0) {
                String temp = subject2;
                subject2 = subject1;
                subject1 = temp;
            }

            if (numOfCreditBook < 0 || numberSemester < 0 || mark1 < 0 || mark2 < 0) {
                throw new NumberFormatException();
            }
            Student student = new Student(numOfCreditBook, surname, numberSemester, subject1, mark1, subject2, mark2);
            System.out.println(student);
            listOfAllStudents.add(student);
        }
    }
    int numOfSemester = 1;
    String theFirstSubj;
    String theSecondSubj;
    public void getStringForSort(String strForSort) throws NumberFormatException {
        StringTokenizer tokenizer = new StringTokenizer(strForSort, " ");
        numOfSemester = Integer.parseInt(tokenizer.nextToken());
        theFirstSubj = tokenizer.nextToken();
        theSecondSubj = tokenizer.nextToken();

        if (theFirstSubj.compareTo(theSecondSubj) < 0) {
            String temp = theSecondSubj;
            theSecondSubj = theFirstSubj;
            theFirstSubj = temp;
        }
    }
}
