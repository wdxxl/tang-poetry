package com.wdxxl.tangpoetry.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "category", "title", "author", "content", "notes", "translate",
        "description", "brief", "quotes"})
public class Poetry {
    private int id;
    private String category;
    private String title;
    private String author;
    private String content;
    private String notes;
    private String translate;
    private String description;
    private String brief;
    private String quotes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTranslate() {
        return translate;
    }

    public void setTranslate(String translate) {
        this.translate = translate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getQuotes() {
        return quotes;
    }

    public void setQuotes(String quotes) {
        this.quotes = quotes;
    }

    @Override
    public String toString() {
        return "Poetry [id=" + id + ", category=" + category + ", title=" + title + ", author="
                + author + ", content=" + content + ", notes=" + notes + ", translate=" + translate
                + ", description=" + description + ", brief=" + brief + ", quotes=" + quotes + "]";
    }

}
