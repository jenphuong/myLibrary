package BooksReadDatabase;

import java.util.HashMap;
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

class Library {
    private HashMap<String, String> booksRead;
    private boolean endSessionNext;
    private Scanner reader;
    
    public Library(){
        booksRead = new HashMap<>();
        endSessionNext = false;
        reader = new Scanner(System.in);
    }
    
    private void getBooksRead(){
        if (booksRead.isEmpty()){
            System.out.println("No books read yet! Get reading!" + "\n");
        }else{
            for (String novel : booksRead.keySet()){
               System.out.println(novel + " - Author: " + booksRead.get(novel));
            }   
            System.out.println("");
        }
    }
    
    private void addBook(String title, String author) {
        if (!booksRead.containsKey(title)){
            booksRead.put(title, author);
            System.out.println("Book added! Great job reading!" + "\n");
        }
        else{
            System.out.println("Error: Book has already been read - nice try!" + "\n");
        }   
    }
    
//    private void removeBook(){  
//    }
    
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
                System.out.println("OK - ending session" + "\n");
                endSession();
            }else{System.out.println("Didn't undertand command, try again" + "\n");}
        }
        System.out.println("Thanks for using the library! Always remember to support your local library.");
    }
}
