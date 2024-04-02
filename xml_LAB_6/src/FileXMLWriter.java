import javax.swing.*;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileXMLWriter {
    List<String> names = new ArrayList<>();
    public void createFile(String path) {
        try {
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(new FileWriter(path));

            xmlStreamWriter.writeStartDocument("UTF-8", "1.0");
            xmlStreamWriter.writeStartElement("Students");
            for (int i = 0; i < names.size(); i++) {
                xmlStreamWriter.writeStartElement("student");
                xmlStreamWriter.writeStartElement("name");
                xmlStreamWriter.writeCharacters(names.get(i));
                xmlStreamWriter.writeEndElement();
                xmlStreamWriter.writeEndElement();
            }
            xmlStreamWriter.writeEndElement();

            xmlStreamWriter.close();

        } catch (IOException | XMLStreamException e) {
            JOptionPane.showMessageDialog(null, "Error file writing", "" ,JOptionPane.ERROR_MESSAGE);
        }
    }
}
