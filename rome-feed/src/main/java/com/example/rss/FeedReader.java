package com.example.rss;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FeedReader {
    public static void main(String... args) {
        URL url;
        try {
            //url = new URL("http://news.cision.com/se/rss/pressmeddelanden/");
            url = new URL("http://news.cision.com/se/avanza-bank/rss/all-information/");
        } catch (MalformedURLException e) {
            System.out.println(e);
            return;
        }

        SyndFeedInput syndFeedInput = new SyndFeedInput();
        SyndFeed syndFeed;
        try {
            syndFeed = syndFeedInput.build(new XmlReader(url));
        } catch (FeedException e) {
            System.out.println(e);
            return;
        } catch (IOException e) {
            System.out.println(e);
            return;
        }

        for (Object object : syndFeed.getEntries()) {
              SyndEntry syndEntry = (SyndEntry) object;

            String entry = "Title: " + syndEntry.getTitle()
                    + " Published: " + syndEntry.getPublishedDate();

            System.out.println(entry);
        }

    }
}
