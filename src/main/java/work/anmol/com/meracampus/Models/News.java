package work.anmol.com.meracampus.Models;

import android.graphics.Bitmap;

import java.util.Date;

public class News {
    String news;
    Date date;
    Bitmap image;

    public News() {
        this.news = "Msit is Best";
        this.date = new Date();
    }

    public News(String news, Date date) {
        this.news = news;
        this.date = date;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
