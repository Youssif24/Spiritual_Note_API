package com.spiritual.note.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
/*
* this class was created because i want to change default exception body or description
* thrown exception will be formatted as my class variables like:
* "message":"my message"
* "url":"http://localhost:8080:........."
* "datestamp":"02/09/2020 01:31:22"
* */

public class ErrorDetails {

    private String message;
    private String url;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd/MM/yyyy HH:mm:ss",timezone = "Europe_Eastern")
    private Date dateStamp;

    public ErrorDetails() {
        dateStamp=new Date();
    }

    public ErrorDetails(String message, String url) {
        this();
        this.message = message;
        this.url = url;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDateStamp() {
        return dateStamp;
    }
}
