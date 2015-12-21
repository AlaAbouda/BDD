package net.diegolemos.bankapp.bibliotheque;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Name of class : MyTestRunner. 
 * Description : Execute all  
 * @version : 1.0 
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public class MyTestRunner {

  /**
   * main.
   * @throws ParserConfigurationException
   *           exception thread sleep.
   * @throws SAXException 
   * @throws IOException
   * @throws ClassNotFoundException */
  public final void main(String[] args) 
      throws ParserConfigurationException, SAXException,
      IOException, ClassNotFoundException {
    List<Class<?>> testCases = new ArrayList<Class<?>>();
    String val = null;
    String[] tab2 = ReadXML("UsesCase/Conf.xml");
    for (int i = 0; i < tab2.length; i++) {
      val = tab2[i];
      if (val != null) {
        System.out.println(val);
        testCases.add(Class.forName(val));
      }
    }

    for (Class testCase : testCases) {
      runTestCase(testCase);
    }
  }

  private final void runTestCase(final Class testCase) {
    Result result = JUnitCore.runClasses(testCase);
    if (result.wasSuccessful()) {
      System.out.println("succes " + testCase.getName());
    } else {
      System.out.println("failure " + testCase.getName());
    }

    for (Failure failure : result.getFailures()) {
      System.out.println(failure.toString());
    }
  }

  public final String[] ReadXML(final String nameXML) 
      throws ParserConfigurationException, SAXException,
      IOException {
    String[] tab = new String[300];
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(new File(nameXML));

    NodeList nodeList = document.getDocumentElement().getChildNodes();
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node firstPersonNode = nodeList.item(i);

      if (firstPersonNode.getNodeType() == Node.ELEMENT_NODE) {

        Element firstPersonElement = (Element) firstPersonNode;

        // -------
        NodeList firstNameList = firstPersonElement.
            getElementsByTagName("TestCase");
        Element firstNameElement = (Element) firstNameList.item(0);

        NodeList textFNList = firstNameElement.getChildNodes();
        tab[i] = textFNList.item(0).getNodeValue().trim();
      }
    }
    return (tab);
  }
}