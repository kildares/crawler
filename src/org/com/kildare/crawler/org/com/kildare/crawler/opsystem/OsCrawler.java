package org.com.kildare.crawler.org.com.kildare.crawler.opsystem;

import java.io.File;

public class OsCrawler{

    public static final PrintFileData FILE_READER = new FilePrinter();
    public static final String TYPE_TXT = "TXT";
    public static final String TYPE_DOC = "DOC";

    public static final String TYPE_DOCX = "DOCX";

    public static final String TYPE_PPT = "PPT";
    public static final String TYPE_PPTX = "PPTX";

    public static final String TYPE_PDF = "PDF";

    public static void crawl(String path, int depth) throws UnsupportedOperationException
    {

        File directory = new File(path);
        if(!directory.isDirectory()){
            throw new UnsupportedOperationException();
        }

        File childFiles[] = directory.listFiles();
        if((childFiles == null || childFiles.length == 0) && depth == 0){
            System.out.println("No files");
            return;
        }

        for(File file : childFiles){

            if(!file.isDirectory()){
                printFile(file);
            }
            else
            {
                depth++;
                try{
                    System.out.println("Reading Directory: " + file.getName());
                    crawl(file.getAbsolutePath(),depth);
                    System.out.println("End Directory: " + file.getName());
                }catch(UnsupportedOperationException e){
                    System.out.println("Error parsing subdirectories");
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Calls the suitable method to print the file data according to its extension. If is not supported, will do nothing
     * @param file must be a file, not directory
     */
    public static void printFile(File file)
    {

        String fileName = file.getName();
        int ponto = fileName.indexOf(".") + 1;

        String fileExtension = fileName.substring(ponto);
        fileExtension = fileExtension.toUpperCase();

        switch(fileExtension){
            case TYPE_TXT:{
                FILE_READER.printTxt(file);
                break;
            }
            case TYPE_DOC:{
                FILE_READER.printDoc(file);
                break;
            }

            case TYPE_DOCX:{
                FILE_READER.printDocx(file);
                break;
            }

            case TYPE_PPT:{
                FILE_READER.printPPT(file);
                break;
            }
            case TYPE_PPTX:{
                FILE_READER.printPPTX(file);
                break;
            }
            case TYPE_PDF:{
                FILE_READER.printPDF(file);
                break;
            }

            default:
                FILE_READER.printFileName(file);
        }
    }
}
