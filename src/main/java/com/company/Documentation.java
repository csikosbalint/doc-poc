package com.company;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import com.company.template.technology.SoftwareDetailesDesign;
import com.component.document.technology.CLIToolSDD;

public class Documentation {
    public static void main(String[] args) throws JAXBException, IOException, TransformerException, ParserConfigurationException, SAXException {
        SoftwareDetailesDesign cliToolSDD = new CLIToolSDD();
        JAXBContext jaxbContext = JAXBContext.newInstance(CLIToolSDD.class);

        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        jaxbMarshaller.marshal(cliToolSDD, System.out);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        jaxbMarshaller.marshal(cliToolSDD, outputStream);

        String xml = new String(outputStream.toByteArray());
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setNamespaceAware(true);
        factory.setValidating(false);

        InputStream inputStream = new FileInputStream(Documentation.class.getClassLoader().getResource("html.xsl").getFile());

        // Use a Transformer for output
        TransformerFactory tFactory = TransformerFactory.newInstance();
        StreamSource stylesource = new StreamSource(inputStream);
        Transformer transformer = tFactory.newTransformer(stylesource);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new StringBufferInputStream(xml));

        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(System.out);
        //        transformer.transform(source, result);

    }
}
