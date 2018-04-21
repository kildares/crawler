package org.com.kildare.crawler.org.com.kildare.crawler.opsystem;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;
import java.util.List;

public class FilePrinter implements PrintFileData {


    @Override
    public void printPDF(File file) {

    }

    @Override
    public void printDocx(File file) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            System.out.println("Reading File: " + file.getName());
            XWPFDocument document = new XWPFDocument(inputStream);
            XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
            System.out.println(wordExtractor.getText());
            System.out.println("\nEnd reading file: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("TXT file not found");
        } catch (IOException e) {
            System.out.println("Error reading Docx file");
        }

    }

    @Override
    public void printTxt(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            System.out.println("Reading File: " + file.getName());
            int data = fileInputStream.read();
            while(data > 0){
                System.out.print(Character.toChars(data));
                data = fileInputStream.read();
            }
            fileInputStream.close();
            System.out.println("\nEnd reading file: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("TXT file not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printPPTX(File file) {
        try{
            FileInputStream inputStream = new FileInputStream(file);
            XMLSlideShow xmlSlideShow = new XMLSlideShow(inputStream);

            List<XSLFSlide> list = xmlSlideShow.getSlides();

            for(XSLFSlide slide : list){

                List<XSLFShape> shapes = slide.getShapes();
                for(XSLFShape shape : shapes){
                    if(shape instanceof XSLFTextShape){
                        XSLFTextShape textShape = (XSLFTextShape)shape;
                        System.out.println(textShape.getText());
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void printFileName(File file) {
        System.out.println("File: "+ file.getName());
    }

    @Override
    public void printDoc(File file) {
        try {
            FileInputStream inputStream = new FileInputStream(file);
            System.out.println("Reading File: " + file.getName());
            HWPFDocument document = new HWPFDocument(inputStream);
            WordExtractor wordExtractor = new WordExtractor(document);
            System.out.println(wordExtractor.getText());
            System.out.println("\nEnd reading file: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("TXT file not found");
        } catch (IOException e) {
            System.out.println("Error reading Docx file");
        }
    }


    @Override
    public void printPPT(File file) {

    }
}
