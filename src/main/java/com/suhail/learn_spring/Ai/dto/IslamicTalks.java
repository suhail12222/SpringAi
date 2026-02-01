package com.suhail.learn_spring.Ai.dto;

import lombok.Data;

@Data
public class IslamicTalks {
    private String topic;
    private String book;
    private String dua;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getDua() {
        return dua;
    }

    public void setDua(String dua) {
        this.dua = dua;
    }

    public IslamicTalks(String topic, String book, String dua) {
        this.topic = topic;
        this.book = book;
        this.dua = dua;
    }

    public IslamicTalks() {

    }
}
