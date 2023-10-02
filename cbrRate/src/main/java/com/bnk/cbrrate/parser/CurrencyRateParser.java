package com.bnk.cbrrate.parser;

import com.bnk.cbrrate.model.CurrencyRate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

@Service
public class CurrencyRateParser {
    public List<CurrencyRate> parse(String ratesAsString) {

        ArrayList<CurrencyRate> currencyRates = new ArrayList<>();
        //Для создания древовидной структуры создается объект класса DocumentBuilder
        DocumentBuilder builder = null;
        try (StringReader reader = new StringReader(ratesAsString)){

            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //Создается объект Document — он является представлением всей информации внутри XML
            Document document = builder.parse(new InputSource(reader));
            NodeList nodeList = document.getElementsByTagName("Valute");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    CurrencyRate currencyRate = CurrencyRate.builder()
                            .nominal(element.getElementsByTagName("Nominal").item(0).getTextContent())
                            .numCode(element.getElementsByTagName("NumCode").item(0).getTextContent())
                            .value(element.getElementsByTagName("Value").item(0).getTextContent())
                            .charCode(element.getElementsByTagName("CharCode").item(0).getTextContent())
                            .name(element.getElementsByTagName("Name").item(0).getTextContent())
                            .build();
                    currencyRates.add(currencyRate);
                }
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }

        return currencyRates;
    }
}
