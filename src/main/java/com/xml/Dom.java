package com.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class Dom {

    static final String XML_URL = "H:\\Git\\springboot-test\\src\\main\\resources\\book.xml";

    public static void main(String[] args) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(XML_URL);
        printNode(doc,0);
    }

    private static void printNode(Node node, int no){
        for(int i=0;i<no;i++){
            System.out.print(' ');
        }
        switch (node.getNodeType()){
            case Node.DOCUMENT_NODE://根节点
                System.out.println("Document:"+node.getNodeName());
                break;
            case Node.ELEMENT_NODE: //元素
                System.out.println("Element:"+node.getNodeName());
                break;
            case Node.TEXT_NODE: //字符
                System.out.println("Text:"+node.getNodeName()+"="+node.getNodeValue());
                break;
            case Node.ATTRIBUTE_NODE: //属性
                System.out.println("Attr:"+node.getNodeName()+"="+node.getNodeValue());
                break;
            case Node.CDATA_SECTION_NODE: //CDATA
                System.out.println("CDATA:"+node.getNodeName()+"="+node.getNodeValue());
                break;
            case Node.COMMENT_NODE: //注释
                System.out.println("Commment:"+node.getNodeName()+"="+node.getNodeValue());
                break;
            default:
                System.out.println("NodeType:"+node.getNodeType()+",NodeName:"+node.getNodeName());
        }
        //递归打印子节点
        for(Node child=node.getFirstChild();child != null;child=child.getNextSibling()){
            printNode(child, no+1);
        }
    }

}
