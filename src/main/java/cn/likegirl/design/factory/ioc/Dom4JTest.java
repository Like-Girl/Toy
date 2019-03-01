package cn.likegirl.design.factory.ioc;

import org.dom4j.*;

import java.util.Iterator;
import java.util.List;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Dom4J
 * @description: TODO
 * @date 2019/2/19 13:20
 */
public class Dom4JTest {


    public static Document createDocument() {
        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("root");

        Element author1 = root.addElement("author")
                .addAttribute("name", "James")
                .addAttribute("location", "UK")
                .addText("James Strachan");

        Element author2 = root.addElement("author")
                .addAttribute("name", "Bob")
                .addAttribute("location", "US")
                .addText("Bob McWhirter");

        return document;
    }

    public static void bar(Document document) throws DocumentException {

        Element root = document.getRootElement();

        // iterate through child elements of root
        for (Iterator i = root.elementIterator(); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println(element.toString());
            // do something
        }

        // iterate through child elements of root with element name "foo"
        for (Iterator i = root.elementIterator("author"); i.hasNext(); ) {
            Element element = (Element) i.next();
            System.out.println(element.toString());
            // do something
        }

        // iterate through attributes of root
        for (Iterator i = root.attributeIterator(); i.hasNext(); ) {
            Attribute attribute = (Attribute) i.next();
            System.out.println(attribute.toString());
            // do something
        }
    }


    public static void bar1(Document document) {
        List<Node> nodes = document.selectNodes("//root/author");
        System.out.println("Node Total: " + nodes.size());
        for (Node n : nodes) {
            String name = n.valueOf("@name");
            System.out.println(name);
        }

        Node node = document.selectSingleNode("//root/author/node");

        if (node != null) {
            String name = node.valueOf("@name");
            System.out.println(name);
        }

    }


    public static void main(String[] args) {
//        try {
//            Dom4jUtils.write(createDocument());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            bar(Dom4jUtils.parse(System.getProperty("user.dir") + "\\output.xml"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        try {
            bar1(Dom4jUtils.parse(System.getProperty("user.dir") + "\\output.xml"));
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}
