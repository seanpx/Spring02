package com.seanpx.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Video {

    static {
        System.out.println("##Video.Video: " + "static{} " + "#1");
    }

    private int id;
    private String title;
    private String summary;

    static {
        System.out.println("##Video.Video: " + "static{} " + "#2");
    }
    private int price;
    private String coverImg;
    @JsonFormat(pattern = "yyyy-mm-dd hh:mm:ss", locale = "sg", timezone = "GMT+8")
    private Date createTime;

    static {
        System.out.println("##Video.Video: " + "static{} " + "#3");
    }
    public List<Chapter> getChapterList() {
        System.out.println("##Video.getChapterList:" );
        return chapterList;
    }

    public void setChapterList(List<Chapter> chapterList) {
        System.out.println("##Video.setChapterList: Start" );
        this.chapterList = chapterList;
        System.out.println("##Video.setChapterList: End" );
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
        System.out.println("##Video.toString: Start" );
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
