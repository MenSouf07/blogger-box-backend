package com.dauphine.blogger.models;

import java.util.Date;
import java.util.UUID;

public class Post {
    private UUID id;
    private String title;
    private String text;
    private UUID category_id;
    private Date created_date;

    public Post(String title, String text, UUID category_id){
        this.id = UUID.randomUUID();
        this.title = title;
        this.text = text;
        this.category_id = category_id;
        this.created_date = new Date();
    }

    

    /**
     * @return UUID return the id
     */
    public UUID getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * @return String return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return String return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return UUID return the category_id
     */
    public UUID getCategoryId() {
        return category_id;
    }

    /**
     * @param category_id the category_id to set
     */
    public void setCategoryId(UUID category_id) {
        this.category_id = category_id;
    }

    /**
     * @return Date return the created_date
     */
    public Date getCreatedDate() {
        return created_date;
    }

    /**
     * @param created_date the created_date to set
     */
    public void setCreatedDate(Date created_date) {
        this.created_date = created_date;
    }

}
