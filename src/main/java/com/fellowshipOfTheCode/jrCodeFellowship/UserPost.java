package com.fellowshipOfTheCode.jrCodeFellowship;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;

@Entity
public class UserPost {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO) Long id;

    private String body;
    private DateFormat timestamp;

    public UserPost() {    }

    public UserPost(String body, DateFormat timestamp) {
        this.body = body;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public DateFormat getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(DateFormat timestamp) {
        this.timestamp = timestamp;
    }
}
