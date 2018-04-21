package org.com.kildare.crawler.org.com.kildare.crawler.web;

public class WebCrawler {

    public static void crawl(String url, int depth) throws UnsupportedOperationException {

        if(depth < 0){
            throw new UnsupportedOperationException();
        }

        //TODO fetch web page content
        //TODO obtain web page hiperlinks
        //TODO print web page content

        if(depth > 0){
            depth--;
            try{
                crawl(url, depth);
            }catch(UnsupportedOperationException e){
                e.printStackTrace();
            }

        }

    }
}
