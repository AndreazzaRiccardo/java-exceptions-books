package org.learning;

public class Book {
    private String title;
    private String author;
    private String publisher;
    private int nPage;

    public Book(String title, String author, String publisher, int nPage) {
        this.title = validateString(title, "Title");
        this.author = validateString(author, "Author");
        this.publisher = validateString(publisher, "Publisher");
        this.nPage = validateNumber(nPage);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = validateString(title, "Title");
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = validateString(author, "Author");
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = validateString(publisher, "Publisher");
    }

    public int getnPage() {
        return nPage;
    }

    public void setnPage(int nPage) {
        this.nPage = validateNumber(nPage);
    }

    protected String validateString(String string, String field) throws IllegalArgumentException {
        String msg = field + " field cannot be empty";
        if(string.isEmpty()){
            throw new IllegalArgumentException(msg);
        } else {
            return string;
        }
    }

    protected int validateNumber(int number) throws IllegalArgumentException {
        if(number <= 0){
            throw new IllegalArgumentException("The number of pages must be greater than zero");
        } else {
            return number;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + " - " +
                "Author: " + author + " - " +
                "Publisher: " + publisher + " - " +
                "Number of pages: " + nPage + "\n";
    }
}
