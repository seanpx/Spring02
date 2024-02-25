package com.seanpx.domain;


import java.util.Date;
import java.util.List;

public class Video {
    private int id;
    private String title;
    private String summary;
    private int price;
    private String coverImg;
    private Date createTime;

    public List<Chapter> getChapterList() {
        System.out.println("##Video.getChapterList:" );
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        System.out.println("##Video.setChapterList:" );
        this.chapterList = chapterList;
    }

    private List<Chapter> chapterList;

    public Video(){

    }

    public Video(int id, String title){
        this.id = id;
        this.title = title;
        this.createTime = new Date();

        System.out.println("##Video.Video:" + this.id + "~" + this.title + "~" + this.createTime );
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        System.out.println("##Video.toString:" );
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", price=" + price +
                ", coverImg='" + coverImg + '\'' +
                ", createTime=" + createTime +
                ", chapterList=" + chapterList +
                '}';
    }
}
