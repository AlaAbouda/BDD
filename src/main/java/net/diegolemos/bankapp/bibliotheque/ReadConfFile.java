package net.diegolemos.bankapp.bibliotheque;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Name of class : ReadConfFile. Description : reading environment variables
 * 
 * @version : 1.0
 * @since : 15/12/2015
 * @author : Talan Tunis
 */
public class ReadConfFile {

  /**
   * Get_info.
   * 
   * @param paramServer
   *          position server
   * @return Table of environment variables
   */
  public static final String[] getInfo(final String paramServer) {
    final String globalsUrl = "hhttp://localhost:8081/";
    final String globalsBrowser = "FIREFOX";
    String[] info = new String[] { globalsUrl, globalsBrowser };
    String in = null;

    final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try {
      final DocumentBuilder builder = factory.newDocumentBuilder();
      final Document document = builder.parse(new File("Conf.xml"));
      final Element racine = document.getDocumentElement();
      final NodeList racineNoeuds = racine.getChildNodes();
      final int nbRacineNoeuds = racineNoeuds.getLength();
      for (int i = 0; i < nbRacineNoeuds; i++) {

        if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
          final Element personne = (Element) racineNoeuds.item(i);
          in = personne.getAttribute("param_server");
          if (in.equals(paramServer)) {
            final Element url = (Element) personne.
                getElementsByTagName("URL").item(0);
            final Element browser = (Element) personne.
                getElementsByTagName("Browser").item(0);

            info[0] = url.getTextContent();
            info[1] = browser.getTextContent();

          }
        }
      }
    } catch (final ParserConfigurationException e) {
      e.printStackTrace();
    }

    catch (final SAXException e) {
      e.printStackTrace();
    }

    catch (final IOException e) {
      e.printStackTrace();
    }
    return (info);
  }

}
