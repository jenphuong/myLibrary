import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author toortman
 */
public class Main {
    public static void main(String[] args){
        Library library = new Library();
        library.runSession();
    }
}

private class Book {
    private String title;
    private String author;
    
    public Book(String name, String writer){
        this.title = name;
        this.author = writer;
    }
    
    public String toString(){
        return "Title: " + title + ". Author: " + author;
    }
}


/**
 *
 * @author toortman
 */
private class Library {
    private HashSet<Book> booksRead;
    private boolean endSessionNext;
    private Scanner reader;
    
    public Library(){
        booksRead = new HashSet<Book>();
        endSessionNext = false;
        reader = new Scanner(System.in);
    }
    
    private void getBooksRead(){
        for (Book novel : booksRead){
            System.out.println(novel);
        }
    }
    
    private void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        if (!booksRead.contains(newBook)){
            booksRead.add(newBook);
            System.out.println("Book added! Great job reading!");
        }
        else{
            System.out.println("Error: Book has already been read - nice try!");
        }
    }
    
    private void removeBook(){
        
    }
    
    private void endSession(){
        endSessionNext = true;
    }
    
    public void runSession(){
        while (!endSessionNext){
            System.out.println("Welcome to the library! Here are your options:");
            System.out.println("add - add book to library that you've read");
            System.out.println("list - displays list of all books read");
            System.out.println("end - ends session");
            String command = reader.nextLine();
            if (command.equals("add")){
                System.out.println("Type title:");
                String title = reader.nextLine();
                System.out.println("Type author:");
                String author = reader.nextLine();
                addBook(title, author);
            }
            else if (command.equals("list")){
                getBooksRead();
            }
            else if (command.equals("end")){
                System.out.println("OK - ending session");
                endSession();
            }
        }
        System.out.println("Thanks for using the library! Always remember to support your local library.");
    }
}
