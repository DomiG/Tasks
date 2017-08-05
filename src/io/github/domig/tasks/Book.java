package io.github.domig.tasks;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class Book implements Serializable {

    private String title;
    private int percentage;
    private List<Book> bookList = new ArrayList<>();

    public Book(String title, int percentage) {
        this.title = title;
        this.percentage = percentage;
    }

    String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    int getPercentage() {
        return percentage;
    }

    private void setPercentage(int percentage) {
        this.percentage = percentage;
    }

    void updateBookProgress(String bookTitle, String newValue) {

        for(Book b : bookList){
            if(b.getTitle().equals(bookTitle)){
                b.setPercentage(Integer.parseInt(newValue));
            }
        }
    }

    List<Book> getBookList(){
        return bookList;
    }

    void loadBookList(List<Book> loadedBookList){

        bookList.clear();
        for (Book b : loadedBookList){
            bookList.add(b);
        }
    }

    void addBook(Book b){
        bookList.add(b);
    }
}

