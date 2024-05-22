package org.exercise.java;

public class Book {

    // ATTRIBUTES
    protected String title;
    protected int pages;
    protected String author;
    protected String publisher;

    // CONSTRUCTORS
    public Book(String title, int pages, String author, String publisher) {
        validateTitle(title);
        validatePages(pages);
        validateAuthor(author);
        validatePublisher(publisher);

        this.title = title;
        this.pages = pages;
        this.author = author;
        this.publisher = publisher;
    }

    // METHODS

    // Validation method
    private void validateTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
    }

    private void validatePages(int pages) {
        if (pages <= 0) {
            throw new IllegalArgumentException("Page number must be greater than 0");
        }
    }

    private void validateAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty");
        }
    }

    private void validatePublisher(String publisher) {
        if (publisher == null || publisher.trim().isEmpty()) {
            throw new IllegalArgumentException("Publisher cannot be empty");
        }
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        validateTitle(title);
        this.title = title;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        validatePages(pages);
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        validateAuthor(author);
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        validatePublisher(publisher);
        this.publisher = publisher;
    }

    // To String
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pages=" + pages +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}