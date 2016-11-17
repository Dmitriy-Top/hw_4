package ru.hw_4.Utilites;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import ru.hw_4.Entity.Purchase;
import ru.hw_4.assets.PurchaseType;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 * Created by admin on 16.11.2016.
 */
public class XMLDB {
    private static String pathDb = "src\\ru\\hw_4\\assets\\bd.xml";


    public static ArrayList<Purchase> getPurchasesFromXML() {
        ArrayList<Purchase> purchases = new ArrayList<Purchase>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(pathDb);
            NodeList purchaseList = document.getElementsByTagName("purchase");
            for (int i = 0; i < purchaseList.getLength(); i++){
                int id = Integer.parseInt(purchaseList.item(i).getAttributes().getNamedItem("id").getNodeValue());
                long time = Long.parseLong(purchaseList.item(i).getChildNodes().item(1).getTextContent());
                String name = purchaseList.item(i).getChildNodes().item(3).getTextContent();
                PurchaseType type = PurchaseType.valueOf(purchaseList.item(i).getChildNodes().item(5).getTextContent());
                int price = Integer.parseInt(purchaseList.item(i).getChildNodes().item(7).getTextContent());
                Purchase purchase = new Purchase(new Date(time),name,type,price);
                purchases.add(id, purchase);
            }


        } catch (ParserConfigurationException e) {
            System.out.println("Ошибка ParserConfigurationException");
        } catch (SAXException e) {
            System.out.println("Ошибка SAXException");
        } catch (IOException e) {
            System.out.println("Ошибка IOException");
        }

        return purchases;
    }

    public static void setPurchasesToXML(ArrayList<Purchase> purchasesArray) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);

        try {
            Document doc = factory.newDocumentBuilder().newDocument();
            Element root = doc.createElement("purchases");
            doc.appendChild(root);

            for (int i = 0; i < purchasesArray.size(); i++) {
                Purchase prchs = purchasesArray.get(i);

                Element purchase = doc.createElement("purchase");
                purchase.setAttribute("id", i + "");
                root.appendChild(purchase);

                Element date = doc.createElement("date");
                date.setTextContent(prchs.getDate().getTime() + "");
                purchase.appendChild(date);

                Element name = doc.createElement("name");
                name.setTextContent(prchs.getName());
                purchase.appendChild(name);

                Element type = doc.createElement("type");
                type.setTextContent(prchs.getType() + "");
                purchase.appendChild(type);

                Element price = doc.createElement("price");
                price.setTextContent(prchs.getPrice() + "");
                purchase.appendChild(price);

            }
            File file = new File(pathDb);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(new DOMSource(doc), new StreamResult(file));
        } catch (ParserConfigurationException e){
            System.out.println("Ошибка ParserConfigurationException");
        } catch (TransformerConfigurationException e){
            System.out.println("Ошибка TransformerConfigurationException");
        } catch (TransformerException e){
            System.out.println("Ошибка TransformerException");
        }


    }


}
