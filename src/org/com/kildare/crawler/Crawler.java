package org.com.kildare.crawler;

import org.com.kildare.crawler.org.com.kildare.crawler.gmail.GmailCrawler;
import org.com.kildare.crawler.org.com.kildare.crawler.opsystem.OsCrawler;
import org.com.kildare.crawler.org.com.kildare.crawler.web.WebCrawler;

public class Crawler {

    public static void main(String args[])
    {
        if(args.length == 1 && args[0].equals("-h")){
            showHelp();
            return;
        }
        if(args.length == 2 && args[0].equals("1")){
            crawlOsDirectory(args[1]);
        }
        else if(args.length == 3 && args[0].equals("2")){

            try{
                int depth = Integer.parseInt(args[2]);
                crawlWebPath(args[1], depth);
            }catch(NumberFormatException e){
                showInvalidArgs();
            }

        }
        else if(args.length == 3 && args[0].equals("3")){
            crawlGmail(args[1], args[2]);
        }
        else{
            showInvalidArgs();
        }
    }


    public static void showInvalidArgs()
    {
        String args = "Argument not recognized. type: 'crawler.jar -h' for help";
        System.out.println(args);
    }

    public static void showHelp()
    {
        String args =
                "The accepted crawl search types are:\n"+
                "1 - OS path search | 2 - Web path search | 3 - Gmail search\n\n" +
                "OS path search parameter: OS absolute Path. Example:\n"+
                "crawler.jar 1 C:\\users\\username\\Documents\\myDirectory\n" +
                "\n" +
                "Web path search paramers: content URL and search depth. Example:\n" +
                "crawler.jar 2 http://example.com/content/document.html 0.\n" +
                "\n"+
                "Gmail search parameters: username and password. Example:\n" +
                "crawler.jar 3 homer.simpson dooh1234\n";

        System.out.println(args);
    }

    public static void crawlOsDirectory(String path)
    {
        try{
            OsCrawler.crawl(path, 0);
        }catch(UnsupportedOperationException e){
            showInvalidArgs();
        }

    }

    public static void crawlWebPath(String url, int depth)
    {
        try{
            WebCrawler.crawl(url, depth);
        }catch(UnsupportedOperationException e){
            showInvalidArgs();
        }

    }

    public static void crawlGmail(String user, String password)
    {
        GmailCrawler.crawl(user, password);
    }
}
