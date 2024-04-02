import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
public class SAXHandler extends DefaultHandler {
    List<Student> students = new ArrayList<>();
    Student student;
    String currentElement;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        currentElement = qName;
        if (qName.equals("student")) {
            student = new Student();
            student.numOfCreditBook = Integer.parseInt(attributes.getValue(0));
            student.surname = attributes.getValue(1);
            student.numberSemester = Integer.parseInt(attributes.getValue(2));
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String text = new String(ch, start, length);
        if (text.contains("<") || currentElement == null) {
            return;
        }
        switch (currentElement) {
            case "subj1":
                student.subject1 = text;
                break;
            case "mark1":
                student.mark1 = Integer.parseInt(text);
                break;
            case "subj2":
                student.subject2 = text;
                break;
            case "mark2":
                student.mark2 = Integer.parseInt(text);
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equals("student")) {
            students.add(student);
            student = null;
        }
        currentElement = null;
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing");
    }
}
