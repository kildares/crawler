package org.com.kildare.crawler.org.com.kildare.crawler.web;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.ConnectException;

public class WebCrawler {

    public static void crawl(String url, int depth) throws UnsupportedOperationException {

        if(depth < 0){
            throw new UnsupportedOperationException();
        }

        try {
            System.out.println("Retrieving web page: " + url);
            Document doc = Jsoup.connect(url).get();
            String text = doc.text();
            System.out.println(text);
            System.out.println("End retrieving web page");
            Elements links = doc.select("a[href]");
            depth--;
            if(depth >= 0)
            {
                for(Element link : links)
                {
                    try{
                        String nextUrl = link.attr("abs:href").toString();
                        crawl(nextUrl, depth);
                    }catch(UnsupportedOperationException e){
                        break;
                    }
                }
            }

        }catch (ConnectException e){
            System.out.println("Connection refused to url: " + url);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
