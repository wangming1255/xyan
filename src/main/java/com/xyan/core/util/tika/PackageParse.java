package com.xyan.core.util.tika;
/*package com.eliteams.quick4j.core.util.tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.sax.BodyContentHandler;
import org.apache.tika.parser.pkg.PackageParser;

import org.xml.sax.SAXException;

*//**下面给出的程序是用来从一个Java存档(JAR)文件提取内容和元数据：*//*
public class PackageParse {

   public static void main(final String[] args) throws IOException,SAXException, TikaException {

      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File("Example.jar"));
      ParseContext pcontext = new ParseContext();
      
      //Package parser
      PackageParser packageparser = new PackageParser();
      packageparser.parse(inputstream, handler, metadata,pcontext);
      System.out.println("Contents of the document: " + handler.toString());
      System.out.println("Metadata of the document:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) {
         System.out.println(name + ":   " + metadata.get(name));
      }
   }
}*/