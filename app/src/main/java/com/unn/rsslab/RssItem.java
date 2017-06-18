package com.unn.rsslab;

import java.util.Date;

/**
 * Created by Администратор on 14.11.2016.
 */

public class RssItem {

    private String title;
    private String link;
    private String description;
    private Date publishedDate;
    private String theme;

    public RssItem(String title, String link, String description, Date publishedDate) {
        this.title = title;
        this.link = link;
        this.description = description;
        this.publishedDate = publishedDate;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

}
