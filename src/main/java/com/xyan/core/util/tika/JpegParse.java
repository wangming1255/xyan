package com.xyan.core.util.tika;
/*package com.eliteams.quick4j.core.util.tika;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.jpeg.JpegParser;
import org.apache.tika.sax.BodyContentHandler;

import org.xml.sax.SAXException;

public class JpegParse {

   public static void main(final String[] args) throws IOException,SAXException, TikaException {

      //detecting the file type
      BodyContentHandler handler = new BodyContentHandler();
      Metadata metadata = new Metadata();
      FileInputStream inputstream = new FileInputStream(new File("boy.jpg"));
      ParseContext pcontext = new ParseContext();
      
      //Jpeg Parse
      JpegParser  JpegParser = new JpegParser();
      JpegParser.parse(inputstream, handler, metadata,pcontext);
      System.out.println("Contents of the document:" + handler.toString());
      System.out.println("Metadata of the document:");
      String[] metadataNames = metadata.names();
      
      for(String name : metadataNames) { 		        
         System.out.println(name + ": " + metadata.get(name));
      }
   }
}*/