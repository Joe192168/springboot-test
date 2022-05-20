package com.xml;


import com.test.Myrunable;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Sax {

    static final String XML_URL = "H:\\Git\\springboot-com.test\\src\\main\\resources\\book.xml";

    public static void main(String[] args) throws Exception {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sap = spf.newSAXParser();
        sap.parse(XML_URL,new MyHandler());
    }

}

class MyHandler extends DefaultHandler{

    void print(Object... objs){
        for (Object obj:objs){
            System.out.print(obj);
            System.out.print(" ");
        }
        System.out.println();
    }

    @Override
    public void startDocument() throws SAXException {
        print("start Document");
    }

    @Override
    public void endDocument() throws SAXException {
        print("end Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        print("start Element:",localName,qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        print("end Element:",localName,qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        print("characters:",new String(ch,start,length));
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        print("error:",e);
    }
}
