package cn.likegirl.java.design.factory.ioc;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * @author LikeGirl
 * @version v1.0
 * @title: Dom4jUtils
 * @description: TODO
 * @date 2019/3/1 14:32
 */
public class Dom4jUtils {

    private Dom4jUtils(){}

    public static void write(Document document) throws IOException {

        // lets write to a file
        OutputFormat format = OutputFormat.createPrettyPrint();
        XMLWriter writer = new XMLWriter(
                new FileWriter( "output.xml" ),
                format
        );
        writer.write( document );
        writer.close();


        // Pretty print the document to System.out
//        OutputFormat format = OutputFormat.createPrettyPrint();
        writer = new XMLWriter( System.out, format );
        writer.write( document );

        // Compact format to System.out
        format = OutputFormat.createCompactFormat();
        writer = new XMLWriter( System.out, format );
        writer.write( document );
    }

    public static Document parse(URL url) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(url);
        return document;
    }

    public static Document parse(String path) throws DocumentException {
        SAXReader reader = new SAXReader();
        File file = new File(path);
        Document document = reader.read(file);
        return document;
    }
}
