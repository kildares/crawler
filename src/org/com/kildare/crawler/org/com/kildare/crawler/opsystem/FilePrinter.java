package org.com.kildare.crawler.org.com.kildare.crawler.opsystem;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hslf.extractor.PowerPointExtractor;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.*;

public class FilePrinter implements PrintFileData {


    @Override
    public void printPDF(File file) {
        try {
            PDDocument doc = PDDocument.load(file);
            PDFTextStripper textStripper = new PDFTextStripper();
            System.out.println("Reading File: " + file.getName());
            System.out.println(textStripper.getText(doc));
            System.out.println("\nEnd reading file: " + file.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            System.out.println("Reading PPTX: " + file.getName());

            FileInputStream inputStream = new FileInputStream(file);
            XMLSlideShow xmlSlideShow = new XMLSlideShow(inputStream);
            XSLFPowerPointExtractor powerPointExtractor = new XSLFPowerPointExtractor(xmlSlideShow);
            System.out.println(powerPointExtractor.getText());
            System.out.println("End reading PPTX: " + file.getName());
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
            System.out.println("Reading Doc: " + file.getName());
            HWPFDocument document = new HWPFDocument(inputStream);
            WordExtractor wordExtractor = new WordExtractor(document);
            System.out.println(wordExtractor.getText());
            System.out.println("\nEnd reading Doc: " + file.getName());
        } catch (FileNotFoundException e) {
            System.out.println("TXT file not found");
        } catch (IOException e) {
            System.out.println("Error reading Docx file");
        }
    }


    @Override
    public void printPPT(File file) {
        try{
            System.out.println("Reading PPT: " + file.getName());
            FileInputStream inputStream = new FileInputStream(file);
            PowerPointExtractor powerPointExtractor = new PowerPointExtractor(inputStream);
            System.out.println(powerPointExtractor.getText());
            System.out.println("End reading PPT: " + file.getName());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
