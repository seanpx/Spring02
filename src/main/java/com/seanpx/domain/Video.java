package com.seanpx.domain;


import java.util.Date;

public class Video {
    private int id;
    private String title;
    private String summary;
    private int price;
    private String coverImg;
    private Date createTime;

    public void video(){

    }

    public Video(int id, String title){
        this.id = id;
        this.title = title;
        this.createTime = new Date();

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public int getPrice() {
        return price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                '}';
    }


}
