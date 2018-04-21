package org.com.kildare.crawler.org.com.kildare.crawler.opsystem;

import java.io.File;

public interface PrintFileData {

    void printPDF(File file);
    void printDoc(File file);
    void printTxt(File file);
    void printPPT(File file);
    void printPPTX(File file);
    void printFileName(File file);
    void printDocx(File file);
}
