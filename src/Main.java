//Orishkevich
//Парсер xml
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            File xmlFile = new File("C:\\Users\\Инженер-конструктор\\IdeaProjects\\XMLParser\\src\\1.xml");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

            Document document = documentBuilder.parse(xmlFile);

            Element root = document.getDocumentElement();
            System.out.println("Корневой элемент: " + root.getNodeName());
            System.out.println("----------------------");

            NodeList nodeList = root.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    System.out.println("Book:");

                    System.out.println("Author: " + element.getElementsByTagName("author").item(0)
                            .getChildNodes().item(0).getNodeValue());

                    System.out.println("Title: " + element.getElementsByTagName("title").item(0)
                            .getChildNodes().item(0).getNodeValue());

                    System.out.println("----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}